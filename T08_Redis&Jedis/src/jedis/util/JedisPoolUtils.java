package jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * JedisPool工具类
 *      加载配置文件，配置连接池参数
 *      提供获取连接的方法
 * @author kwin
 * @create 2019-11-29 14:44
 */
public class JedisPoolUtils {

    private static JedisPool jedisPool;

    static {
        try {
            Properties pro = new Properties();
            InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
            pro.load(is);

            String host = pro.getProperty("host");
            String port = pro.getProperty("port");
            String maxTotal = pro.getProperty("maxTotal");
            String maxIdle = pro.getProperty("maxIdle");

            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(Integer.parseInt(maxTotal));
            config.setMaxIdle(Integer.parseInt(maxIdle));

            jedisPool = new JedisPool(config, port, Integer.parseInt(host));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取连接的方法
     */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
