package gdut.service;

import gdut.Dao.GoodsDao;
import gdut.Dao.GoodsDaoImpl;
import gdut.entity.Goods;
import gdut.entity.PageBean;

import java.util.List;

public class GoodService {
    GoodsDao goodsdao = new GoodsDaoImpl();
    public PageBean<Goods> findByPage(int pc){
        try {
            return goodsdao.findByPage(pc);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Goods getOneGoods(int goods_id) {
        try{
            return goodsdao.getOneGoods(goods_id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    public PageBean<Goods> findTypeByPage(String goods_type){
        try {
            return goodsdao.findTypeByPage(goods_type);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    public PageBean<Goods> findNamePage(String goods_name){
        try {
            return goodsdao.findNamePage(goods_name);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}