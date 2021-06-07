package gdut.util;
import java.sql.*;

public class JDBCUtil {
    private static String DRIVER="com.mysql.cj.jdbc.Driver";
    private static String URL="jdbc:mysql://localhost:3306/idlegoodstrading?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&autoReconnect=true";
    private static String USERNAME="root";//用户名
    private static String PWD="991109";//密码


    public static Connection getConnection() throws ClassNotFoundException, SQLException {//获得连接
        Connection connection=null;
        Class.forName(DRIVER);
        connection=DriverManager.getConnection(URL, USERNAME, PWD);
        return connection;
    }

    public static void closeAll(Connection connection,Statement statement,ResultSet resultSet) throws SQLException {//关闭连接
        if(connection!=null) connection.close();
        if(statement!=null) statement.close();
        if(resultSet!=null) resultSet.close();
    }

    public static void closeAll(Connection connection,Statement statement) throws SQLException {//关闭连接
        if(connection!=null) connection.close();
        if(statement!=null) statement.close();
    }

    public static void main(String[] args){
        Connection connection = null;
        try {
            //加载mysql的驱动类
            Class.forName(DRIVER);
            //获取数据库连接
            connection = DriverManager.getConnection(URL, USERNAME, PWD);
            //mysql查询语句
            String sql = "SELECT goods_name FROM ss_goods";
            PreparedStatement prs = connection.prepareStatement(sql);
            //结果集
            ResultSet rs = prs.executeQuery();
            while (rs.next()) {
                System.out.println("用户名:" + rs.getString("goods_name"));
            }
            rs.close();
            prs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
