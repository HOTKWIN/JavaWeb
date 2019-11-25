package reflect;

import domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.sql.Connection;

/**
 * 获取构造器
 *
 * @author kwin
 * @create 2019-11-22 23:36
 */
public class ReflectDemo2 {

    public static void main(String[] args) throws Exception {

        //1.获取Person的Class对象
        Class personClass = Person.class;

        //2.获取所有构造器
        Constructor[] constructors = personClass.getConstructors();
        for (Constructor constructor:constructors)
            System.out.println(constructor);

        System.out.println("-----------------------");

        //3.获取特定的构造器
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);

        //4.使用通过反射获取的构造器创建对象

        //带参构造器
        Object person = constructor.newInstance("张三", 23);
        System.out.println(person);

        System.out.println("-----------------------");

        //空参构造器
        Constructor constructor1 = personClass.getConstructor();
        Object person1 = constructor1.newInstance();
        System.out.println(person1);

    }

}
