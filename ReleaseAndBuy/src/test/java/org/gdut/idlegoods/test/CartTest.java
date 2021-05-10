package org.gdut.idlegoods.test;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.gdut.idlegoods.bean.Cart;
import org.gdut.idlegoods.bean.Goods;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:SpringApplicationContext.xml","classpath:SpringWebmvc.xml"})
@WebAppConfiguration
public class CartTest {
	
	//构造虚拟mvc请求
	MockMvc mockMvc;
	
	//拿到mvc容器
	@Autowired
	WebApplicationContext context;
	//初始化虚拟请求
	@Before
	public void initmockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	//发送并获取请求数据
	@Test
	public void testAddToCart() throws Exception {
		//创建sessoin域对象
		MockHttpSession session = new MockHttpSession();
		Cart cart2 = new Cart();
		//假设购物车里面已经有商品了
		cart2.getBasket().put(1,new Goods(1, null, null, null, null, null, null, null));
		cart2.getCount().put(1, 1);
		cart2.getBasket().put(2,new Goods(1, null, null, null, null, null, null, null));
		cart2.getCount().put(2, 2);
		session.setAttribute("1", cart2);
		session.setAttribute("userId", "1");
		//测试添加一件商品到购物车
		MvcResult result1 = mockMvc.perform(MockMvcRequestBuilders.post("/addToCart").session(session)
				.param("goodsId", "2")).andReturn();
		String userId = (String)result1.getRequest().getSession().getAttribute("userId");
		Cart cart = (Cart)result1.getRequest().getSession().getAttribute(userId);
		for(Integer key:cart.getBasket().keySet()) {
		System.out.println(key+":"+cart.getBasket().get(key));
		
		}
		System.out.println(cart.getCount().get(1));
		System.out.println(cart.getCount().get(2));
	}
	

	//测试从购物车删除商品
	@Test
	public void testDeleteGoods() throws Exception {
		MockHttpSession session = new MockHttpSession();
		session.setAttribute("userId", "1");
		Cart cart = new Cart();
		cart.getBasket().put(1,new Goods(1, null, null, null, null, null, null, null));
		cart.getCount().put(1, 3);
		session.setAttribute("1", cart);
		MvcResult result1 = mockMvc.perform(MockMvcRequestBuilders.delete("/deleteGoods/1").session(session)).andReturn();
		Cart cart2 = (Cart)result1.getRequest().getSession().getAttribute("1");
		System.out.println(cart2.getCount().get(1));
		System.out.println(cart2.getBasket().get(1));
	}
	
	//测试清空购物车
	@Test
	public void testClearCart() throws Exception {
		MockHttpSession session = new MockHttpSession();
		Cart cart2 = new Cart();
		//假设购物车里面已经有商品了
		cart2.getBasket().put(1,new Goods(1, null, null, null, null, null, null, null));
		cart2.getCount().put(1, 1);
		cart2.getBasket().put(2,new Goods(1, null, null, null, null, null, null, null));
		cart2.getCount().put(2, 2);
		session.setAttribute("1", cart2);
		session.setAttribute("userId", "1");
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/clearCart").session(session)).andReturn();
		Cart cart = (Cart)result.getRequest().getSession().getAttribute("1");
		/*
		for(java.util.Map.Entry<Integer, Object> entry:cart.getBasket().entrySet()) {
			System.out.println(entry.getValue());
		}
		*/
		System.out.println(cart.getBasket().get(1));
		
	}
	

}
