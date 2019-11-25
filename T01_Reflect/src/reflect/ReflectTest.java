package reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射案例:框架类
 *      可以创建任意的对象 可以执行任意方法
 *
 * 前提：不能改变该类的任何代码。可以创建任意类的对象，可以执行任意的方法
 *
 * @author kwin
 * @create 2019-11-23 0:47
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {


        //(*)1.加载配置文件
        Properties pro = new Properties();
        InputStream is = ReflectTest.class.getClassLoader().getResourceAsStream("pro.properties");
        pro.load(is);

        //2.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        System.out.println(className);
        System.out.println(methodName);

        //3.加载该类进内存
        Class cls = Class.forName(className);

        //4.创建对象
        Object o = cls.newInstance();
        System.out.println(o);

        //5.获取对象方法
        Method method = cls.getMethod(methodName);
        System.out.println(method);

        //6.执行方法
        method.invoke(o);
    }
}
