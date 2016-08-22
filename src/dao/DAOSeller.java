package dao;

import entity.Seller;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import static org.apache.taglibs.standard.Version.getSeller;

/**
 * Created by USER on 22.07.2016.
 */
public class DAOSeller {
    public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {
        String url = "jdbc:mysql://localhost:3306/bakery";
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(url, "root", "root");
        return connection;
    }

    public static List<Seller> getSeller() throws SQLException, ClassNotFoundException {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM seller");
            ResultSet resultSet = ps.executeQuery();

            ArrayList<Seller> seller = new ArrayList<>();
            while (resultSet.next()) {
                int id_seller = resultSet.getInt(1);
                String name_seller = resultSet.getString(2);
                int id_order = resultSet.getInt(3);
                seller.add(new Seller(id_seller, name_seller, id_order));
            }
            return seller;
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deleteSeller(int id_seller) throws SQLException, ClassNotFoundException, NamingException {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("DELETE FROM seller WHERE id_seller=?");
            {
                ps.setInt(1, id_seller);
                ps.executeUpdate();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
        //return null;

    }

    public static void addSeller(String name_seller, String id_order) throws SQLException, ClassNotFoundException {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO seller (name_seller,id_order) VALUES (?,?)");
            {
                ps.setString(1, name_seller);
                ps.setInt(2, Integer.parseInt(id_order));
                ps.executeUpdate();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

}
