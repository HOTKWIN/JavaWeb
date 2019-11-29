package jedis.test;

import jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jedis的测试类
 *
 * @author kwin
 * @create 2019-11-29 14:03
 */
public class JedisTest {

    /**
     * 快速入门
     */
    @Test
    public void test1(){
        //1.获取连接
        Jedis jedis = new Jedis("localhost",6379);

        //2.操作
        jedis.set("username","zhangsan");

        //3.关闭资源
        jedis.close();
    }

    /**
     * string数据结构操作
     */
    public void test2(){
        //1.获取连接
        Jedis jedis = new Jedis();//空参，默认值"localhost","6379"
        //2.操作
        //存储
        jedis.set("username","zhangsan");
        //获取
        String username = jedis.get("username");
        System.out.println(username);

        //可以使用setex()方法存储可以指定过期时间的key value
        jedis.setex("activecode",20,"hehe");//20秒后自动删除该键值对

        //3.关闭连接
        jedis.close();
    }

    /**
     * hash数据结构操作
     */
    @Test
    public void test3(){
        //1.获取连接
        Jedis jedis = new Jedis();
        //2.操作
        //存储hash
        jedis.hset("user","name","lisi");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","female");

        //获取hash
        String name = jedis.hget("user", "name");
        System.out.println(name);

        //获取hash的所有map中的数据
        Map<String, String> user = jedis.hgetAll("user");
        //keyset
        Set<String> keySet = user.keySet();
        for (String key:keySet){
            //获取value
            String value = user.get(key);
            System.out.println(key + ":" + value);
        }

        //3.关闭连接
        jedis.close();
    }

    /**
     * list数据结构操作
     *
     */
    @Test
    public void test4(){
        //1.获取连接
        Jedis jedis = new Jedis();
        //2.操作
        //list存储
        jedis.lpush("mylist","a","b","c");
        jedis.rpush("mylist","a","b","c");

        //list范围获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        //list弹出
        String element1 = jedis.lpop("mylist");
        System.out.println(element1);
        String element2 = jedis.rpop("mylist");
        System.out.println(element2);

        //list范围获取
        List<String> mylist2 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist2);

        //3.关闭连接
        jedis.close();
    }

    /**
     * set 数据结构操作
     */
    @Test
    public void test5(){
        //1.获取连接
        Jedis jedis = new Jedis();
        //2.操作
        jedis.sadd("myset","java","php","c++");
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);

        //3.关闭连接
        jedis.close();
    }

    /**
     * sortedset数据结构操作
     */
    @Test
    public void test6(){
        Jedis jedis = new Jedis();

        jedis.zadd("mysortedset",3,"亚瑟");
        jedis.zadd("mysortedset",30,"后裔");
        jedis.zadd("mysortedset",55,"孙悟空");

        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
        System.out.println(mysortedset);

        jedis.close();
    }

    /**
     * jedis连接池使用
     */
    @Test
    public void test7(){
        //1.创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);

        //2.创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);

        //3.获取连接
        Jedis jedis = jedisPool.getResource();

        //4.关闭 归还到连接池中
        jedis.close();
    }

    /**
     * jedis连接池工具类使用
     */
    @Test
    public void test8(){
        Jedis jedis = JedisPoolUtils.getJedis();

        jedis.set("hehe","heihei");

        jedis.close();
    }

}
