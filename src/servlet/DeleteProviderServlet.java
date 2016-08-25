package servlet;

import dao.DAOProvider;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet responds to the URL /deleteprovider
 * @author Sarnavskaya
 */
@WebServlet(name = "servlet.DeleteProviderServlet", urlPatterns = "/deleteprovider")
public class DeleteProviderServlet extends HttpServlet {
    /**
     * Method that call when POST request came from server
     * @param request request from client
     * @param response response to client
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
    }

    /**
     * Method that call when GET request came from server
     * @param request request from client
     * @param response response to client
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id_provider = Integer.parseInt(request.getParameter("id_provider"));

        try {
            DAOProvider.deleteProvider(id_provider);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/provider");

    }

}