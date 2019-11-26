package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 演示Request对象获取请求头数据:user-agent
 *
 * @author kwin
 * @create 2019-11-26 14:34
 */
@WebServlet("/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String agent = request.getHeader("user-agent");
        //判断agent的浏览器版本
        if (agent.contains("Chrome")){
            System.out.println("这是谷歌浏览器");
        }else if (agent.contains("Firefox")){
            System.out.println("这是狐浏览器");
        }
    }
}
