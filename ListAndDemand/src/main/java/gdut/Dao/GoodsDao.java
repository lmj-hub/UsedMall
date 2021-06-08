package gdut.Dao;

import gdut.entity.Goods;
import gdut.entity.PageBean;

public interface GoodsDao {
    public PageBean<Goods> findByPage(int pc);
}

