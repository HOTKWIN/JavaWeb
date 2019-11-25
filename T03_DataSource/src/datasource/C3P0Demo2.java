package datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0的演示
 *
 * @author kwin
 * @create 2019-11-23 11:38
 */
public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {

        //1.获取DataSource,使用默认配置
        DataSource ds = new ComboPooledDataSource();
        //2.获取连接
        for (int i = 1; i <= 11; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);
            if (i == 5)
                conn.close();
        }

        //使用指定名称配置
//        DataSource ds1 = new ComboPooledDataSource("otherc3p0");
//        for (int i = 1; i <= 11; i++) {
//            Connection conn = ds1.getConnection();
//            System.out.println(i + ":" + conn);
//            if (i == 5)
//                conn.close();
//        }
    }
}
