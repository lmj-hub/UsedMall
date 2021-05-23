package gdut.Dao;

import gdut.entity.Goods;
import gdut.util.JDBCUtil;

import java.sql.*;
import java.util.Vector;

public class GoodsDao extends JDBCUtil {
    public static Vector<Goods> getAllGoods() throws ClassNotFoundException, SQLException {
        Vector<Goods> good=new Vector<>();
            Connection connection=getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from ss_goods");
            while(resultSet.next()) {
                Goods goods=new Goods();
                goods.setGoods_id(resultSet.getInt(1));
                goods.setGoods_name(resultSet.getString(2));
                goods.setGoods_price(resultSet.getDouble(3));
                goods.setGoods_num(resultSet.getInt(4));
                goods.setGoods_imgurl(resultSet.getString(5));
                goods.setGoods_desp(resultSet.getString(6));
                goods.setGoods_type(resultSet.getString(7));
                goods.setGoods_cdate(resultSet.getString(8));
                good.add(goods);
        }
        closeAll(connection, statement,resultSet);
        return good;
    }


    public static Goods getOneGoods(int goods_id) throws ClassNotFoundException, SQLException {
        Goods goods=null;
        Connection connection=getConnection();
        PreparedStatement statement=connection.prepareStatement("select * from ss_goods where goods_id=?");
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
        closeAll(connection, statement,resultSet);
        return goods;
    }

    public static Goods findOneGoods(String goods_name) throws ClassNotFoundException, SQLException{
        Goods goods = null;
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from ss_goods where goods_name like CONCAT('%',?,'%')");
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
        closeAll(connection, statement,resultSet);
        return goods;

    }

}
