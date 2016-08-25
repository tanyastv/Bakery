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
 * Servlet responds to the URL /seller
 * @author Sarnavskaya
 */
@WebServlet(name = "servlet.SellerServlet", urlPatterns = "/seller")
public class SellerServlet extends HttpServlet {
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
        try {
            request.setAttribute("seller", DAOSeller.getSeller());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("seller.jsp").forward(request, response);
    }
}