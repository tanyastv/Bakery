package servlet;

import dao.DAOOrders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet responds to the URL /addorders
 * @author Sarnavskaya
 */
@WebServlet(name = "servlet.AddOrdersServlet", urlPatterns = "/addorders")
public class AddOrdersServlet extends HttpServlet {
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
        String name_order = request.getParameter("name_order");
        String id_product = request.getParameter("id_product");
        String id_provider = request.getParameter("id_provider");
        String nds = request.getParameter("nds");

        try {

            DAOOrders.addOrders(name_order, id_product, id_provider, nds);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/orders");
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
    }
}
