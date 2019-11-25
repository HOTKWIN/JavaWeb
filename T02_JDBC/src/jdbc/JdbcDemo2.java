package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * boys表添加一条记录 insert语句
 *
 * @author kwin
 * @create 2019-11-23 2:12
 */
public class JdbcDemo2 {

    public static void main(String[] args)  {

        Connection conn = null;
        Statement statement = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.定义sql
            String sql = "insert into boys values(null,'李四',4000)";

            //3.获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql:///girls", "root", "123456");

            //4.获取执行sql的对象statement
            statement = conn.createStatement();

            //5.执行sql
            int count = statement.executeUpdate(sql);

            //6.处理结果
            System.out.println(count);
            if (count > 0)
                System.out.println("添加成功!");
            else
                System.out.println("添加失败！");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            //7.释放资源
            //避免空指针异常

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
