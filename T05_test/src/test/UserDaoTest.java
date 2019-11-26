package test;

import dao.UserDao;
import domain.User;
import org.junit.Test;

/**
 * @author kwin
 * @create 2019-11-26 17:09
 */
public class UserDaoTest {

    @Test
    public void testLogin(){
        User user = new User();
        user.setUsername("superbaby");
        user.setPassword("123456");

        UserDao dao = new UserDao();
        User loginUser = dao.login(user);
        System.out.println(loginUser);

    }
}
