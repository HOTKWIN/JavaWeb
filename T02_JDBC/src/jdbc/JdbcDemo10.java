package jdbc;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 事务操作
 *
 * @author kwin
 * @create 2019-11-23 9:20
 */
public class JdbcDemo10 {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            conn = JDBCUtils.getConnection();

            //开启事务
            conn.setAutoCommit(false);

            String sql1 = "update boys set userCP = userCP - ? where id = ?";
            String sql2 = "update boys set userCP = userCP + ? where id = ?";

            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);

            pstmt1.setInt(1,500);
            pstmt1.setInt(2,2);
            pstmt2.setInt(1,500);
            pstmt2.setInt(2,3);

            pstmt1.executeUpdate();
            System.out.println(1/0);
            pstmt2.executeUpdate();

            //提交事务
            conn.commit();
        } catch (SQLException e) {
            //回滚事务
            if (conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt1,conn);
            JDBCUtils.close(pstmt2,null);
        }
    }
}
