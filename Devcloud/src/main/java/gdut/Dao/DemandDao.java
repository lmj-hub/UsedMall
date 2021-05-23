package gdut.Dao;

import gdut.entity.Demand;
import gdut.util.JDBCUtil;

import java.sql.*;
import java.util.Vector;

public class DemandDao extends JDBCUtil {
    public static Vector<Demand> getAllDemand() throws ClassNotFoundException, SQLException {
        Vector<Demand> demands =new Vector<>();
        Connection connection=getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from ss_requirements");
        while(resultSet.next()) {
            Demand demand = new Demand();
            demand.setRe_id(resultSet.getInt(1));
            demand.setRe_msg(resultSet.getString(2));
            demand.setRe_date(resultSet.getDate(3));
            demand.setUser_id(resultSet.getInt(4));
            demands.add(demand);
        }
        closeAll(connection, statement,resultSet);
        return demands;
    }
}
