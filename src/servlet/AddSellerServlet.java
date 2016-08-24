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
 * @author Sarnavskaya
 */

/**
 * AddSellerServlet - класс
 * doPost -
 * doGet -
 */

@WebServlet(name = "servlet.AddSellerServlet", urlPatterns = "/addseller")
public class AddSellerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name_seller = request.getParameter("name_seller");
        String id_order = request.getParameter("id_order");

        try {
            DAOSeller.addSeller(name_seller, id_order);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/seller");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
    }
}
