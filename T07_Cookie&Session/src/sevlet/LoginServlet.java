package sevlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author kwin
 * @create 2019-11-28 15:45
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.设置request编码
        request.setCharacterEncoding("utf-8");

        //2.获取输入的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        //3.获取生成的验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String)session.getAttribute("checkCode_session");
        //在session中删除刚刚生成的验证码
        session.removeAttribute("checkCode_session");

        //4.先判断验证码是否正确
        if (checkCode_session != null && checkCode.equalsIgnoreCase(checkCode_session)){//验证吗正确
            //判断用户名密码是否正确
            if ("zhangsan".equals(username) && "123".equals(password)){
                session.setAttribute("user",username);
                //重定向到success.jsp
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            }else{
                request.setAttribute("login_error","用户名或密码错误");
                //转发到login.jsp
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }

        }else{//验证吗不正确

            request.setAttribute("cc_error","请重新输入验证码");
            //转发到login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
