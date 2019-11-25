package jdbc;

import utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 练习：
 *      需求：
 *          1.通过键盘录入用户名和密码
 *          2.判断用户是否登录成功
 *
 * @author kwin
 * @create 2019-11-23 8:42
 */
public class JdbcDemo9 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = sc.nextLine();
        System.out.println("请输入密码：");
        String password = sc.nextLine();

        boolean flag = new JdbcDemo9().login2(username, password);
        if (flag)
            System.out.println("登陆成功！");
        else
            System.out.println("登录失败! ");

    }


    /**
     * 登录方法（有bug）
     */
    public boolean login(String username,String password){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        //1.获取数据库连接
        try {
            conn = JDBCUtils.getConnection();
            //2.定义sql语句
            String sql = "select * from boys where boyName = '" + username + "' and userCP = '" + password + "'";
            System.out.println(sql);
            //3.获取执行sql语句的对象statement
            stmt = conn.createStatement();
            //4.执行sql
            rs = stmt.executeQuery(sql);
            //5.判断结果
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return false;
    }

    /**
     * 登录方法
     */
    public boolean login2(String username,String password){

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from boys where boyName = ? and userCP = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,username);
            stmt.setString(2,password);
            rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,stmt,conn);
        }

        return false;
    }
}
