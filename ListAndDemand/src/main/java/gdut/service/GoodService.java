package gdut.service;

import gdut.Dao.GoodsDao;
import gdut.Dao.GoodsDaoImpl;
import gdut.entity.Goods;
import gdut.entity.PageBean;

public class GoodService {
    GoodsDao goodsdao = new GoodsDaoImpl();
    public PageBean<Goods> findByPage(int pc){
        try {
            return goodsdao.findByPage(pc);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}