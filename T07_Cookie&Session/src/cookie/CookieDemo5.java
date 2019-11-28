package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1.中文问题
 * 2.同一服务器下不同项目的共享问题
 *
 * @author kwin
 * @create 2019-11-28 9:01
 */
@WebServlet("/cookieDemo5")
public class CookieDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.创建Cookie对象
        Cookie cookie1 = new Cookie("msg", "你好");

        //2.设置path,让当前服务器下部署的所有项目共享Cookie信息
        cookie1.setPath("/");

        //3.发送Cookie
        response.addCookie(cookie1);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
