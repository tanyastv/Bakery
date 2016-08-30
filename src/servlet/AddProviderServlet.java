package servlet;

import dao.DAOProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet responds to the URL /addprovider
 *
 * @author Sarnavskaya
 */
@WebServlet(name = "servlet.AddProviderServlet", urlPatterns = "/addprovider")
public class AddProviderServlet extends HttpServlet {
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AddProviderServlet.class);

    /**
     * Method that call when POST request came from server
     *
     * @param request  request from client
     * @param response response to client
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id_product = request.getParameter("id_product");
        String date_of_delivery = request.getParameter("date_of_delivery");
        String name_provider = request.getParameter("name_provider");

        try {
            DAOProvider.addProvider(id_product, date_of_delivery, name_provider);
        } catch (SQLException | ClassNotFoundException e) {
            log.error("SQLException");
            e.printStackTrace();
        }
        response.sendRedirect("/provider");
    }

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
    }
}
