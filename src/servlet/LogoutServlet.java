package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet responds to the URL /exit
 * @author Sarnavskaya
 */
@WebServlet(name = "servlet.LogoutServlet", urlPatterns = "/exit")
public class LogoutServlet extends HttpServlet {
    /**
     * Method that call when GET request came from server
     * @param request request from client
     * @param response response to client
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) session.invalidate();
        response.sendRedirect("/");
    }
}
