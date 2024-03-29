package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 发送多个cookie
 *
 * @author kwin
 * @create 2019-11-28 9:01
 */
@WebServlet("/cookieDemo3")
public class CookieDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.创建Cookie对象
        Cookie cookie1 = new Cookie("msg", "hello");
        Cookie cookie2 = new Cookie("name", "zhangsan");
        //2.发送Cookie
        response.addCookie(cookie1);
        response.addCookie(cookie2);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
