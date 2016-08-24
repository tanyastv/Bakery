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
 * @author Sarnavskaya
 */

/**
 * RegistrationServlet - класс
 * doPost -
 * doGet -
 */

@WebServlet(name = "servlet.RegistrationServlet", urlPatterns = "/registration/")
public class RegistrationServlet extends HttpServlet {
    HttpSession session;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            if (User.get(request.getParameter("login")) == null) {
                User.add(request.getParameter("login"), request.getParameter("password"));

                response.sendRedirect("/");
            } else {
                throw new Exception("entity.User exists");
            }
        } catch (Exception e) {
            session.setAttribute("error", e.getMessage());
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        session = request.getSession();
        request.getRequestDispatcher("../registration.jsp").forward(request, response);
        session.removeAttribute("error");
    }
}
