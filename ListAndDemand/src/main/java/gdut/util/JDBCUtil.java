package gdut.util;
import java.sql.*;

public class JDBCUtil {
    private static String DRIVER="com.mysql.cj.jdbc.Driver";
    private static String URL="jdbc:mysql://localhost:3306/ss_goods?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&autoReconnect=true";
    private static String USERNAME="root";//用户名
    private static String PWD="123456";//密码

    static {
        try{
            Class.forName(DRIVER);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    public static Connection getConnection(){//获得连接
        Connection connection=null;

        try {
            connection=DriverManager.getConnection(URL, USERNAME, PWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection,Statement statement,ResultSet resultSet){//关闭连接
        try{
            if(connection!=null){
                connection.close();
            }
            if(statement!=null){
                statement.close();
            }
            if (resultSet!=null){
                resultSet.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void close(Connection connection,Statement statement){//关闭连接
        close(connection,statement,null);
    }

}
