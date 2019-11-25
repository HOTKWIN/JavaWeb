package datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid演示
 *
 * @author kwin
 * @create 2019-11-25 19:49
 */
public class DruidDemo1 {

    public static void main(String[] args) throws Exception {

        //1.导入jar包
        //2.加载配置文件
        Properties pro = new Properties();
        pro.load(DruidDemo1.class.getClassLoader().getResourceAsStream("druid.properties"));

        //3.获取DataSource
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        //4.获取数据库连接
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
