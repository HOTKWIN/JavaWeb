package jdbc;

import java.sql.*;
import java.util.Collections;

/**
 * 执行DQL语句：遍历结果集
 *
 * @author kwin
 * @create 2019-11-23 5:41
 */
public class JdbcDemo6 {

    public static void main(String[] args){

        Statement statement = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            //1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///girls", "root", "123456");
            //3.定义sql
            String sql = "select * from boys";
            //4.获取执行sql对象
            statement = conn.createStatement();
            //5.执行sql
            rs = statement.executeQuery(sql);
            //6.处理结果
            rs.next();
            int id = rs.getInt(1);
            String boyName = rs.getString("boyName");
            String userCP = rs.getString("userCP");
            System.out.println(id + "---" + boyName + "---" + userCP);

            rs.next();
            int id1 = rs.getInt(1);
            String boyName1 = rs.getString("boyName");
            String userCP1 = rs.getString("userCP");
            System.out.println(id1 + "---" + boyName1 + "---" + userCP1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            //避免空值异常
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
