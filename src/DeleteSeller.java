import javax.naming.NamingException;
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
@WebServlet(name = "DeleteSeller", urlPatterns = "/delete")
public class DeleteSeller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_seller = Integer.parseInt(request.getParameter("id_seller"));
        try {
            DAO_Seller.deleteSeller(id_seller);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/seller");

    }
}
