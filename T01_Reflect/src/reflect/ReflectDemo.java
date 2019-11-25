package reflect;

import domain.Person;

import java.lang.reflect.Method;

/**
 * 获取Class对象的方式
 *
 * @author kwin
 * @create 2019-11-22 23:36
 */
public class ReflectDemo {

    public static void main(String[] args) throws Exception {

        //1.Class.forName("全类名")方式
        Class cls1 = Class.forName("domain.Person");
        System.out.println(cls1);

        //2.类.class方式
        Class cls2 = Person.class;
        System.out.println(cls2);

        //3.对象实例.getClass()方式
        Person person = new Person();
        Class cls3 = person.getClass();
        System.out.println(cls3);

        System.out.println(cls1 == cls2 && cls2 == cls3);
    }

}
