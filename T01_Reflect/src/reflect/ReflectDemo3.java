package reflect;

import domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 获取成员方法
 *
 * @author kwin
 * @create 2019-11-22 23:36
 */
public class ReflectDemo3 {

    public static void main(String[] args) throws Exception {

        //1.获取Person的Class对象
        Class personClass = Person.class;

        //2.获取所有public修饰的成员方法
        Method[] methods = personClass.getMethods();
        for (Method method:methods)
            System.out.println(method);

        System.out.println("===================");

        //3.获取指定的public修饰的成员方法
        Method eat = personClass.getMethod("eat", String.class);
        System.out.println(eat);

        //4.执行通过反射获取的指定方法
        Person person = new Person();
        eat.invoke(person,"香蕉");

        System.out.println("=====================");

        //5.获取类名
        String className = personClass.getName();
        System.out.println(className);
    }

}
