package gdut.Dao;

import gdut.entity.Goods;
import gdut.entity.PageBean;

import java.util.List;
//
public interface GoodsDao {
    public PageBean<Goods> findByPage(int pc);

    public PageBean<Goods> findTypeByPage(String goods_type);

    public Goods getOneGoods(int goods_id);

    public PageBean<Goods> findNamePage(String goods_name);

}


