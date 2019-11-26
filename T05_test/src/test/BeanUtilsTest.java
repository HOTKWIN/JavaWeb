package test;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author kwin
 * @create 2019-11-26 17:37
 */
public class BeanUtilsTest {

    @Test
    public void test1(){
        User user = new User();
        user.setUsername("kwin");
        user.setPassword("123456");

        try {
            String username = BeanUtils.getProperty(user, "username");
            System.out.println(username);
            String password = BeanUtils.getProperty(user, "password");
            System.out.println(password);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
