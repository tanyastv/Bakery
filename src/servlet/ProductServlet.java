package servlet;

import dao.DAOProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet responds to the URL /product
 *
 * @author Sarnavskaya
 */
@WebServlet(name = "servlet.ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ProductServlet.class);

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
        try {
            request.setAttribute("product", DAOProduct.getProduct());
        } catch (SQLException e) {
            log.error("SQLException");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            log.error("ClassNotFoundException");
            e.printStackTrace();
        }
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }
}
