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
 * Servlet responds to the URL /login/
 *
 * @author Sarnavskaya
 */
@WebServlet(name = "servlet.LoginServlet", urlPatterns = "/login/")
public class LoginServlet extends HttpServlet {
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(LoginServlet.class);

    /**
     * Method that call when GET request came from server
     *
     * @param request  request from client
     * @param response response to client
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        request.getRequestDispatcher("../login.jsp").forward(request, response);
        session.removeAttribute("error");
    }

    /**
     * Method that call when POST request came from server
     *
     * @param request  request from client
     * @param response response to client
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // авторизация
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        try {
            User user = User.get(request.getParameter("login"));
            if (user != null) {
                if (User.valid(user, request.getParameter("password"))) {
                    session.setAttribute("user", user);
                    response.sendRedirect("/");
                } else {
                    throw new Exception("Incorrect password");
                }
            } else {
                throw new Exception("User ain't exist");
            }
        } catch (Exception e) {
            log.error("Exception");
            session.setAttribute("error", e.getMessage());
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

}