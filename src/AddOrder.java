import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by USER on 22.07.2016.
 */
@WebServlet(name = "AddOrder", urlPatterns = "/addorder")
public class AddOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name_order = request.getParameter("name_order");
        String id_product = request.getParameter("id_product");
        String id_provider = request.getParameter("id_provider");
        String nds = request.getParameter("nds");

        try {

            DAOOrder.addOrder(name_order,id_product,id_provider,nds);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/order");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
