package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kwin
 * @create 2019-11-28 10:14
 */
@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应的ContentType
        response.setContentType("text/html;charset=utf-8");

        //1.获取Cookies数组
        Cookie[] cookies = request.getCookies();
        boolean flag = false;

//        //删除cookie
//        if (cookies != null && cookies.length > 0){
//            for (Cookie cookie:cookies) {
//                String name = cookie.getName();
//                if ("lastTime".equals(name)) {
//                    cookie.setMaxAge(0);
//                    response.addCookie(cookie);
//                }
//            }
//        }

        //2.非第一次访问
        if (cookies != null && cookies.length >0){
            for (Cookie cookie:cookies){
                if ("lastTime".equals(cookie.getName())){
                    flag = true;

                    //获取上次访问的时间
                    String value = cookie.getValue();
                    System.out.println("解码前：" + value);
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后：" + value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问的时间是：" + value + "</h>");

                    //保存这次的访问时间
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    System.out.println("编码前：" + str_date);
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println("编码后：" + str_date);
                    cookie.setValue(str_date);

                    //设置最大存活时间
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(cookie);
                }
            }
        }

        //3.第一次访问
        if (cookies == null || cookies.length == 0 || flag == false){

            response.getWriter().write("<h1>您好，欢迎您首次光临！</h1>");

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            System.out.println("编码前：" + str_date);
            str_date = URLEncoder.encode(str_date, "utf-8");
            System.out.println("编码后：" + str_date);

            Cookie cookie = new Cookie("lastTime", str_date);
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
