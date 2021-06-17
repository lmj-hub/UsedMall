package org.gdut.idlegoods.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.gdut.idlegoods.bean.Cart;
import org.gdut.idlegoods.bean.Goods;
import org.gdut.idlegoods.bean.Message;
import org.gdut.idlegoods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author mj
 *商品控制器，负责与前端交互
 */
@Controller
@SessionAttributes(types = Cart.class)
public class GoodsController {
	@Autowired
	GoodsService goodService;
	
	//转发请求到"我的发布"页面
	@RequestMapping(value="/myRelease",method=RequestMethod.GET)
	public String toRelease() {
		return "myRelease";
	}
	
	//发布商品
	@ResponseBody
	@RequestMapping(value="/publishGoods",method=RequestMethod.POST)
	public Message releaseGoods(@RequestParam(value = "file",required=false) MultipartFile file,
			@Valid Goods goods,BindingResult errors,
			HttpServletRequest request) throws IOException {
		if(errors.hasErrors()) {
			return Message.fail();
		}
		if(file!=null) {
			Goods dealedGoods = getImgUrl(file,goods,request);
			boolean result = goodService.saveGoods(dealedGoods);
			if(result) {
				return Message.success();
			}
		}
			return Message.fail();
	}
	
	
	//获取图片路径，并把上传图片存在服务器的ROOT文件夹下
	public Goods getImgUrl(MultipartFile file,Goods goods,HttpServletRequest request) throws IOException {
			ServletContext sctx = request.getServletContext();//获取工程路径，把图片保存在工程路径之下
			String ip = request.getServerName();//获取服务器名称(ip)
			int port = request.getServerPort();	//获取服务器端口号
			String date = new Date().getTime()+"";//获取时间戳
			String userPicturePath ="/picture"+goodService.getUserId(request);//获取用户对应的图片文件夹
			String rootPath = goodService.getImgUrl(request);//服务器的ROOT文件夹
			// String rootPath = "/usr/local/tomcat/apache-tomcat-9.0.4/webapps/ROOT";
			String realPath=rootPath+userPicturePath;
			String name = date+file.getOriginalFilename();
			File dir = new File(realPath);
			if(!dir.exists()) {
				dir.mkdir();
			}
			File path = new File(realPath,name);
			InputStream in = file.getInputStream();
			FileOutputStream out= new FileOutputStream(path);
			BufferedInputStream bsi = new BufferedInputStream(in);
			BufferedOutputStream bso = new BufferedOutputStream(out);
			byte[] b = new byte[in.available()];
			int len=0;
			try {
				while((len=bsi.read(b))!=-1) {
					bso.write(b,0,len);
					bso.flush();
				}
				goods.setGoodsImgurl("http://"+ip+":"+port+userPicturePath+"/"+name);
				int sellerId = Integer.parseInt(goodService.getUserId(request));
				goods.setSellerId(sellerId);
			}finally {
				in.close();
				out.close();
				bsi.close();
				bso.close();
			}
			return goods;
	}
	
	//添加商品到购物车
	@ResponseBody
	@RequestMapping(value="/addToCart",method=RequestMethod.POST)
	public Message addToCart(Goods goods,HttpServletRequest request,Map<String,Object> map) {
		String userId = goodService.getUserId(request);
		Cart cart =(Cart) request.getSession().getAttribute(userId);
		if(cart==null) {
			cart = new Cart();
		}
		goodService.addToCart(goods, cart);
		map.put(userId,cart);
		return Message.success();
	}
	
	//从购物车上移除商品
	@ResponseBody
	@RequestMapping(value="/deleteGoods/{goodsId}",method=RequestMethod.DELETE)
	public Message deleteGoods(@PathVariable("goodsId") String goodsId,HttpServletRequest request) {
		String userId = goodService.getUserId(request);
		Cart cart = (Cart)request.getSession().getAttribute(userId);
		if(goodsId.contains("-")) {
		//删除多个
			String[] ids=goodsId.split("-");
			for(int i =0;i<ids.length;i++) {
				goodService.deleteGoods(Integer.parseInt(ids[i]), cart);
			}
			return Message.success();
		}else {
			goodService.deleteGoods(Integer.parseInt(goodsId), cart);
			return Message.success();
		}
	}
	
	//清空购物车
	@ResponseBody
	@RequestMapping(value="/clearCart",method=RequestMethod.DELETE)
	public Message clearGoods(HttpServletRequest request) {
		String userId = goodService.getUserId(request);
		Cart cart =(Cart) request.getSession().getAttribute(userId);
		goodService.clear(cart);
		return Message.success();
	}
	
	//查看购物车
	@RequestMapping("/checkMyCart")
	public String showCart(HttpServletRequest request,Map<String,Object> map) {
		String userId = goodService.getUserId(request);
		Cart cart =(Cart) request.getSession().getAttribute(userId);
		if(cart==null) {
			cart = new Cart();
			map.put(userId,cart);
		}
		return "myCart";
	}
	
	/*
	//获取用户id
	public String getUserId(HttpServletRequest request) {
		ServletContext context = request.getSession().getServletContext();
		ServletContext targetContext = context.getContext("/User");
		HttpSession session = (HttpSession)targetContext.getAttribute(request.getSession().getId());
		Integer userId =(Integer) session.getAttribute("userId");
		String idstr=userId.intValue()+"";
		return idstr;
	}
	*/
	//获取所有商品种类
	@ResponseBody
	@RequestMapping("/categories")
	public List getCategroies() {
		return goodService.getCategroies();
	}
	
	
	//查看已经发布的商品
	@RequestMapping(value="/getMyGoods",method=RequestMethod.GET)
	@ResponseBody
	public Message getMyGoods(@RequestParam(value="pn", defaultValue="1") Integer pn,HttpServletRequest request) {
		Integer userId = Integer.parseInt(goodService.getUserId(request));
		//pn为当前页，每页放5条数据
		PageHelper.startPage(pn,5);
		//查询数据(默认是分页查询)
		List<Goods> goodsList = goodService.getMyGoods(userId);
		//pageInfo封装了数据信息，里面包含了详细的分页信息，包括当前页的数据
		PageInfo<Goods> pageInfo = new PageInfo<Goods>(goodsList,3);
		return Message.success().add("pageInfo", pageInfo);
	}
	
	//通过商品id查找商品
	@ResponseBody
	@RequestMapping(value="/getOneGoods/{currentId}",method = RequestMethod.GET)
	public Message getOneGoods(@PathVariable("currentId") String goodsId) {
		Goods goods = goodService.getOneGoods(goodsId);
		return Message.success().add("goods", goods);
	}
	
	//更新商品
		@ResponseBody
		@RequestMapping(value="/updateGoods",method=RequestMethod.POST)
		public Message updateGoods(@RequestParam(value = "file",required=false) MultipartFile file,
		@Valid Goods goods,BindingResult errors,
		HttpServletRequest request) throws IOException {
			if(errors.hasErrors()) {
				return Message.fail();
			}
			boolean result;
			if(file!=null&&file.getSize()!=0) {
				Goods dealedGoods = getImgUrl(file,goods,request);
				 result = goodService.updateGoods(dealedGoods);
			}else {
				 result =goodService.updateGoods(goods);
				}
			if(result) {
				return Message.success();
			}else {
					return Message.fail();
		}
	}
		
	//删除商品
		@ResponseBody
		@RequestMapping(value="/delete/{goodsId}",method=RequestMethod.DELETE)
	public Message delete(@PathVariable(value = "goodsId") String goodsId) {
			if(goodsId.contains("-")) {
				//删除多个
					String[] ids=goodsId.split("-");
					for(int i =0;i<ids.length;i++) {
						goodService.delete(ids[i]);
					}
					return Message.success();
			}else {
				//删除单个
						boolean result = goodService.delete(goodsId);
						if(result) {
							return Message.success();
						}
					}
			return Message.fail();
		}
		
//清空所有发布的商品
		@ResponseBody
		@RequestMapping(value="/clearPublishedGoods",method = RequestMethod.DELETE)
		public Message clearPublishedGoods(HttpServletRequest request) {
			String userId = goodService.getUserId(request);
			boolean result = goodService.clearGoods(userId);
			if(result) {
				return Message.success();
			}
			return Message.fail();
		}
}
