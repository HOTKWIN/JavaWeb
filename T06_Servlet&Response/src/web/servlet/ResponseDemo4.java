package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 案例2：服务器输出字符数据到浏览器
 *      *步骤：
 *          1.获取字符输出流
 *          2.输出数据
 *      *注意：
 *          *乱码问题：
 *              1.PrintWriter pw = response.getWriter();获取的流的默认编码是ISO-8859-1
 *              2.设置该流的默认编码
 *              3.告诉浏览器响应体使用的编码
 *
 * @author kwin
 * @create 2019-11-26 21:22
 */
@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        //获取流对象之前，设置流的默认编码：ISO-8859-1 设置为：GBK
//        response.setCharacterEncoding("utf-8");
//        //告诉浏览器,服务器发送的消息体数据的编码。建议浏览器使用该编码解码
//        response.setHeader("content-type","text/html;charset=utf-8");

        //简单的形式。设置编码
        response.setContentType("text/html;charset=utf-8");

        //1.获取字符输出流
        PrintWriter pw = response.getWriter();
        //2.输出数据
        pw.write("你好，response");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
