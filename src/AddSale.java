import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by USER on 22.07.2016.
 */
@WebServlet(name = "AddSale", urlPatterns = "/add")
public class AddSale extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_seller = request.getParameter("id_seller");
        String id_product = request.getParameter("id_product");
        String cost_sale = request.getParameter("cost_sale");
        String date_of_sale = request.getParameter("date_of_sale");

        try {
            DAO_Sale.addSale(id_seller,id_product,cost_sale, date_of_sale);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/sale");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
