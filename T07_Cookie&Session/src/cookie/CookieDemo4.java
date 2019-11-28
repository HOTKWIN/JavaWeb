package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 持久化存储cookie
 *
 * @author kwin
 * @create 2019-11-28 9:01
 */
@WebServlet("/cookieDemo4")
public class CookieDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.创建Cookie对象
        Cookie cookie1 = new Cookie("msg", "helloDemo4");

        //2.设置cookie的存活时间
        cookie1.setMaxAge(60);
//        cookie1.setMaxAge(-1);
//        cookie1.setMaxAge(0);

        //3.发送Cookie
        response.addCookie(cookie1);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
