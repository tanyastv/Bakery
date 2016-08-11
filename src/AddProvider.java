import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by USER on 21.07.2016.
 */
@WebServlet(name = "AddProvider", urlPatterns = "/addprovider")
public class AddProvider extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_product = request.getParameter("id_product");
        String date_of_delivery = request.getParameter("date_of_delivery");
        String name_provider = request.getParameter("name_provider");

        try {
            DAOProvider.addProvider(id_product, date_of_delivery, name_provider);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/provider");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
