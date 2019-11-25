package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 执行DDL语句
 *
 * @author kwin
 * @create 2019-11-23 5:31
 */
public class JdbcDemo5 {

    public static void main(String[] args) {

        Connection conn = null;
        Statement statement = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.定义sql
            String sql = "create table student1 (id int,name varchar(20))";
            //3.获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql:///girls","root","123456");
            //4.获取执行sql的对象statement
            statement = conn.createStatement();
            //5.执行sql
            int count = statement.executeUpdate(sql);
            //6.处理结果
            System.out.println(count);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            //避免空值异常
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
