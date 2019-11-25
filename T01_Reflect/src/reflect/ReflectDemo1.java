package reflect;

import domain.Person;

import java.lang.reflect.Field;

/**
 * 获取成员变量
 *
 * @author kwin
 * @create 2019-11-22 23:36
 */
public class ReflectDemo1 {

    public static void main(String[] args) throws Exception {

        //1.获取Person的Class对象
        Class<Person> cls = Person.class;

        //2.获取所有public修饰的成员变量
        Field[] fields = cls.getFields();
        for (Field field : fields)
            System.out.println(field);

        //3.获取指定的public修饰的成员变量
        Field a = cls.getField("a");
        System.out.println(a);

        //4.获取特定对象的成员变量a的值
        Person person = new Person();
        Object o = a.get(person);
        System.out.println(o);

        //5.设置特定对象的成员变量a的值
        a.set(person,"张三");
        System.out.println(a.get(person));

        System.out.println("============================");

        //6.获取所有的成员变量，不考虑修饰符
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field:declaredFields)
            System.out.println(field);

        System.out.println("--------------------");

        //7.获取特定的成员变量
        Field d = cls.getDeclaredField("d");
        System.out.println(d);

        //8.尝试直接获取或设置非public权限的成员变量，会报错
//        System.out.println(d.get(person));

        //9.忽略访问权限修饰符的安全检查(暴力反射)
        d.setAccessible(true);
        System.out.println(d.get(person));

        d.set(person,"李四");
        System.out.println(d.get(person));

    }
}
