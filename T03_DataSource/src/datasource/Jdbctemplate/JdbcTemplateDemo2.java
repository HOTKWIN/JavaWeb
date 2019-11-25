package datasource.Jdbctemplate;

import datasource.domain.Boy;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 练习：
 *      1.修改2号数据的userCP为10000
 *      2.添加一条记录
 *      3.删除刚才添加的记录
 *      4.查询id为2的记录，将其封装为Map对象
 *      5.查询所有记录，将其封装为List
 *      6.查询所有记录,将其封装为Boy对象的List集合（使用自定义RowMapper）
 *      7.查询所有记录,将其封装为Boy对象的List集合（使用BeanPropertyRowMapper）
 *      8.查询总记录数
 *
 * @author kwin
 * @create 2019-11-25 20:52
 */
public class JdbcTemplateDemo2 {

    @Test
    public void test1(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "update boys set userCP = ? where id = ?";
        int count = template.update(sql, 10000, 2);
        System.out.println(count);
    }

    @Test
    public void test2(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into boys(id,boyName,userCP) values(?,?,?)";
        int count = template.update(sql, 4, "张三", "666");
        System.out.println(count);
    }

    @Test
    public void test3(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "delete from boys where id = ?";
        int count = template.update(sql, 4);
        System.out.println(count);
    }

    @Test
    public void test4(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from boys where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 2);
        System.out.println(map);
    }

    @Test
    public void test5(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from boys";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map map:list)
            System.out.println(map);
    }

    @Test
    public void test6(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from boys";
        List<Boy> list = template.query(sql, new RowMapper<Boy>() {

            @Override
            public Boy mapRow(ResultSet rs, int i) throws SQLException {

                Boy boy = new Boy();

                int id = rs.getInt("id");
                String boyName = rs.getString("boyName");
                int userCP = rs.getInt("userCP");

                boy.setId(id);
                boy.setBoyName(boyName);
                boy.setUserCP(userCP);

                return boy;
            }
        });

        for (Boy boy:list)
            System.out.println(boy);
    }

    @Test
    public void test7(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from boys";
        List<Boy> list = template.query(sql, new BeanPropertyRowMapper<Boy>(Boy.class));
        for (Boy boy:list)
            System.out.println(boy);
    }

    @Test
    public void test8(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select count(id) from boys";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
