package web.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 1.获取文件名称
 * 2.使用字节输入流加载文件进内存
 * 3.指定response的响应头：content-disposition:attachment;filename=xxx
 * 4.将数据写出到response输出流
 *
 * @author kwin
 * @create 2019-11-27 15:46
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取文件名称
        String filename = request.getParameter("filename");

        //2.使用字节输入流加载文件进内存
        ServletContext servletContext = this.getServletContext();
        System.out.println(servletContext);
        String realPath = servletContext.getRealPath("/img/" + filename);
        FileInputStream fis = new FileInputStream(realPath);

        //3.设置response响应头
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("context-type",mimeType);
        response.setHeader("context-disposition","attachment;filename=" + filename);

        //4.将输入流的数据写出到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = fis.read(buff)) != -1){
            sos.write(buff,0,len);
        }
        fis.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
