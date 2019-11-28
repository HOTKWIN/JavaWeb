package web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext功能：
 *      1.获取MIME类型：
 *          MIME类型：在互联网通信过程中定义的一种文件数据类型
 *              格式：大类型/小类型 text/html image/jpeg
 *          *获取：String getMimeType(String file)
 *      2.域对象：共享数据
 *      3.获取文件的真实(服务器)路径
 *
 * @author kwin
 * @create 2019-11-26 22:36
 */
@WebServlet("/servletContextDemo3")
public class ServletContextDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = this.getServletContext();

        //设置数据
        context.setAttribute("msg","haha");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
