package datasource.Jdbctemplate;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * JdbcTemplateDemo入门
 *
 * @author kwin
 * @create 2019-11-25 20:39
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {

        //1.导入jar包

        //2.获取DataSource
        DataSource ds = null;
        try {
            Properties pro = new Properties();
            pro.load(JdbcTemplateDemo1.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //3.获取JdbcTemplate
        JdbcTemplate template = new JdbcTemplate(ds);

        //4.执行sql
        String sql = "update boys set userCP = ? where id = ?";
        int count = template.update(sql, 2000, 2);
        System.out.println(count);
    }
}
