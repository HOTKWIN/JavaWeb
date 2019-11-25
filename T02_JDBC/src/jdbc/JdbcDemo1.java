package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC快速入门（不规范）
 *
 * @author kwin
 * @create 2019-11-23 2:12
 */
public class JdbcDemo1 {

    public static void main(String[] args) throws Exception {

        //1.导入驱动jar包

        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //3.获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/girls","root","123456");

        //4.定义sql语句
        String sql = "update boys set userCP = 2000 where id = 2";

        //5.获取执行sql语句的对象statement
        Statement statement = conn.createStatement();

        //6.执行sql
        int count = statement.executeUpdate(sql);

        //7.处理结果
        System.out.println(count);

        //8.释放资源
        statement.close();
        conn.close();
    }

}
