package jdbc;

import domain.Emp;
import utils.JDBCUtils;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 练习：定义一个方法，查询employees表的数据将其封装为对象，然后装载集合，返回
 *
 * @author kwin
 * @create 2019-11-23 5:41
 */
public class JdbcDemo8 {

    public static void main(String[] args) {
        List<Emp> list = new JdbcDemo8().findAll2();
        System.out.println(list);
        System.out.println(list.size());
    }

    private List<Emp> findAll(){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Emp> list = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.定义sql
            String sql = "select * from employees";
            //3.获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql:///myemployees","root","123456");
            //4.获取执行sql的对象statement
            stmt = conn.createStatement();
            //5.执行sql语句
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，加入集合
            list = new ArrayList<>();
            Emp emp = null;
            while (rs.next()){
                int employee_id = rs.getInt("employee_id");
                String last_name = rs.getString("last_name");
                Date hiredate = rs.getDate("hiredate");
                double salary = rs.getDouble("salary");

                emp = new Emp();
                emp.setEmployee_id(employee_id);
                emp.setLast_name(last_name);
                emp.setHiredate(hiredate);
                emp.setSalary(salary);

                list.add(emp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (stmt != null){
                try {
                    stmt.close();
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
        return list;
    }

    private List<Emp> findAll2(){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Emp> list = null;

        try {
            //1.获取数据库连接
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String sql = "select * from employees";
            //3.获取执行sql语句的statement对象
            stmt = conn.createStatement();
            //4.执行sql
            rs = stmt.executeQuery(sql);
            //5.遍历结果集，封装对象，加入list中
            list = new ArrayList<>();
            Emp emp = null;
            while (rs.next()){
                int employee_id = rs.getInt("employee_id");
                String last_name = rs.getString("last_name");
                Date hiredate = rs.getDate("hiredate");
                double salary = rs.getDouble("salary");

                emp = new Emp();
                emp.setEmployee_id(employee_id);
                emp.setLast_name(last_name);
                emp.setHiredate(hiredate);
                emp.setSalary(salary);

                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }
}
