package servlet;

import dao.DAOSeller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet responds to the URL /addseller
 *
 * @author Sarnavskaya
 */
@WebServlet(name = "servlet.AddSellerServlet", urlPatterns = "/addseller")
public class AddSellerServlet extends HttpServlet {
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AddSellerServlet.class);

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
        String name_seller = request.getParameter("name_seller");
        String id_order = request.getParameter("id_order");

        try {
            DAOSeller.addSeller(name_seller, id_order);
        } catch (SQLException | ClassNotFoundException e) {
            log.error("SQLException");
            e.printStackTrace();
        }
        response.sendRedirect("/seller");
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
