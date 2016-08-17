package servlet;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by USER on 12.08.2016.
 */
@WebServlet(name = "servlet.LoginServlet", urlPatterns = "/login/")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // String title = "login";
       // super.doGet(request, response);
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        request.getRequestDispatcher("../WEB-INF/login.jsp").forward(request, response);
        session.removeAttribute("error");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // авторизация
       // super.doPost(request, response);
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        try {
            User user = User.get(request.getParameter("login"));

            if (user != null) {
                if (User.valid(user, request.getParameter("password"))) { // проверяет, совпадает ли пароль введенный с паролем для данного юзера
                    session.setAttribute("user", user);
                    response.sendRedirect("/");
                } else {
                    throw new Exception("Incorrect password");
                }
            } else {
                throw new Exception("entity.User ain't exist");
            }
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

}