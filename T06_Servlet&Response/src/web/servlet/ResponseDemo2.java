package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 案例1：完成重定向
 *      *重定向：资源跳转的方式
 *      *重定向的特点：redirect
 *          1.地址栏发生变化
 *          2.重定向可以访问其他站点(服务器)的资源
 *          3.重定向是两次请求。不能使用request对象来共享数据
 *      *转发的特点：forward
 *          1.转发地址栏路路径不变
 *          2.转发只能访问当前服务器下的资源
 *          3.转发是一次请求，可以使用request对象来共享数据
 *
 *
 * @author kwin
 * @create 2019-11-26 20:49
 */
@WebServlet("/responseDemo2")
public class ResponseDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问了demo2！");

       //重定向是两次请求，不能使用request对象来共享数据
        Object msg = request.getAttribute("msg");
        System.out.println(msg);//null

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
