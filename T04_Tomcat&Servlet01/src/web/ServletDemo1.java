package web;

import javax.servlet.*;
import java.io.IOException;

/**
 * Servlet快速入门
 *
 * @author kwin
 * @create 2019-11-26 10:09
 */
public class ServletDemo1 implements Servlet{


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //提供服务的方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service......");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
