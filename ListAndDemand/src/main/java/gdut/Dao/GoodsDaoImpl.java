package gdut.Dao;

import gdut.entity.Goods;
import gdut.entity.PageBean;
import gdut.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public PageBean<Goods> findByPage(int pc) {
        int ps = 4;
        int all = 0;
//        String sql = "select count(*) from ss_goods";
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("select count(*) from ss_goods");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                all = Integer.parseInt(resultSet.getString("count(*)"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,resultSet);
        }


        PageBean<Goods> pageBean = new PageBean<Goods>();
        pageBean.setAll(all);
        pageBean.setPc(pc);
        pageBean.setPs(ps);

        pageBean.setBeanlist(new ArrayList<Goods>());
//        sql = "select * from ss_goods limit ?,?";

        connection = JDBCUtil.getConnection();
        resultSet = null;
        try{
            statement = connection.prepareStatement("select goods_id,goods_name,goods_price,goods_num,goods_imgurl,goods_desp,goods_type,goods_cdate from ss_goods limit ?,?");
            statement.setInt(1,(pc-1)*ps);
            statement.setInt(2,ps);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Goods goods = new Goods();
                goods.setGoods_id(resultSet.getInt(1));
                goods.setGoods_name(resultSet.getString(2));
                goods.setGoods_price(resultSet.getDouble(3));
                goods.setGoods_num(resultSet.getInt(4));
                goods.setGoods_imgurl(resultSet.getString(5));
                goods.setGoods_desp(resultSet.getString(6));
                goods.setGoods_type(resultSet.getString(7));
                goods.setGoods_cdate(resultSet.getString(8));
                pageBean.getBeanlist().add(goods);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,resultSet);
        }

        return pageBean;
    }

    @Override
    public PageBean<Goods> findTypeByPage(String goods_type) {
        int pc = 1;
        int ps = 4;
        int all = 0;
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("select count(*) from ss_goods where goods_type=?");
            statement.setString(1,goods_type);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                all = Integer.parseInt(resultSet.getString("count(*)"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,resultSet);
        }


        PageBean<Goods> pageBean = new PageBean<Goods>();
        pageBean.setAll(all);
        pageBean.setPc(pc);
        pageBean.setPs(ps);

        pageBean.setBeanlist(new ArrayList<Goods>());
//        sql = "select * from ss_goods limit ?,?";

        connection = JDBCUtil.getConnection();
        resultSet = null;
        try{
            statement = connection.prepareStatement("select goods_id,goods_name,goods_price,goods_num,goods_imgurl,goods_desp,goods_type,goods_cdate from ss_goods where goods_type=? limit ?,?");
            statement.setString(1,goods_type);
            statement.setInt(2,(pc-1)*ps);
            statement.setInt(3,ps);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Goods goods = new Goods();
                goods.setGoods_id(resultSet.getInt(1));
                goods.setGoods_name(resultSet.getString(2));
                goods.setGoods_price(resultSet.getDouble(3));
                goods.setGoods_num(resultSet.getInt(4));
                goods.setGoods_imgurl(resultSet.getString(5));
                goods.setGoods_desp(resultSet.getString(6));
                goods.setGoods_type(resultSet.getString(7));
                goods.setGoods_cdate(resultSet.getString(8));
                pageBean.getBeanlist().add(goods);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,resultSet);
        }

        return pageBean;
    }

    @Override
    public Goods getOneGoods(int goods_id) {
        Goods goods=null;
        PreparedStatement statement = null;
        Connection connection = JDBCUtil.getConnection();
        try{
            statement=connection.prepareStatement("select * from ss_goods where goods_id=?");
            statement.setInt(1,goods_id);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()) {
                goods=new Goods();
                goods.setGoods_id(resultSet.getInt(1));
                goods.setGoods_name(resultSet.getString(2));
                goods.setGoods_price(resultSet.getDouble(3));
                goods.setGoods_num(resultSet.getInt(4));
                goods.setGoods_imgurl(resultSet.getString(5));
                goods.setGoods_desp(resultSet.getString(6));
                goods.setGoods_type(resultSet.getString(7));
                goods.setGoods_cdate(resultSet.getString(8));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,null);
        }
        return goods;
    }

    @Override
    public PageBean<Goods> findNamePage(String goods_name) {
        int pc = 1;
        int ps = 4;
        int all = 0;
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement("select count(*) from ss_goods where goods_name like CONCAT('%',?,'%')");
            statement.setString(1,goods_name);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                all = Integer.parseInt(resultSet.getString("count(*)"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,resultSet);
        }


        PageBean<Goods> pageBean = new PageBean<Goods>();
        pageBean.setAll(all);
        pageBean.setPc(pc);
        pageBean.setPs(ps);

        pageBean.setBeanlist(new ArrayList<Goods>());
//        sql = "select * from ss_goods limit ?,?";

        connection = JDBCUtil.getConnection();
        resultSet = null;
        try{
            statement = connection.prepareStatement("select goods_id,goods_name,goods_price,goods_num,goods_imgurl,goods_desp,goods_type,goods_cdate from ss_goods where goods_name like CONCAT('%',?,'%') limit ?,?");
            statement.setString(1,goods_name);
            statement.setInt(2,(pc-1)*ps);
            statement.setInt(3,ps);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                Goods goods = new Goods();
                goods.setGoods_id(resultSet.getInt(1));
                goods.setGoods_name(resultSet.getString(2));
                goods.setGoods_price(resultSet.getDouble(3));
                goods.setGoods_num(resultSet.getInt(4));
                goods.setGoods_imgurl(resultSet.getString(5));
                goods.setGoods_desp(resultSet.getString(6));
                goods.setGoods_type(resultSet.getString(7));
                goods.setGoods_cdate(resultSet.getString(8));
                pageBean.getBeanlist().add(goods);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(connection,statement,resultSet);
        }

        return pageBean;
    }


}