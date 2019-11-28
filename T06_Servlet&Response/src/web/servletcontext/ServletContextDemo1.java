package web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext对象获取：
 *      1.通过request对象获取
 *          request.getServletContext();
 *      2.通过HttpServlet获取
 *          this.getServletContext();
 *
 * @author kwin
 * @create 2019-11-26 22:36
 */
@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.通过request对象获取
        ServletContext context = request.getServletContext();
        //2.通过HttpServlet获取
        ServletContext context1 = this.getServletContext();

        System.out.println(context);
        System.out.println(context1);

        System.out.println(context == context1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
