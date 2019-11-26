package web.servlet;

import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author kwin
 * @create 2019-11-26 17:13
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);

        Map<String, String[]> parameterMap = request.getParameterMap();
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        if (user != null){
            request.setAttribute("user",user);
            request.getRequestDispatcher("/successServlet").forward(request,response);
        }else{
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
