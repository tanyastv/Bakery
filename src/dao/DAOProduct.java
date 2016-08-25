package dao;

import entity.Order;
import entity.Product;

import javax.naming.NamingException;
//import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class realize access to data of products entity
 * @author Sarnavskaya
 */
public class DAOProduct {
    /**
     * Create object of connection with database
     * @return object of connection with database
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws NamingException
     */
    public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {
        String url = "jdbc:mysql://localhost:3306/bakery";
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(url, "root", "root");
        return connection;
    }

    /**
     * Method that getting list of products from database
     * @return list of products
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static List<Product> getProduct() throws SQLException, ClassNotFoundException {
        ArrayList<Product> product = null;
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT id_product,name_product,cost from product");
            ResultSet resultSet = ps.executeQuery();

            product = new ArrayList<>();
            while (resultSet.next()) {
                int id_product = resultSet.getInt(1);
                String name_product = resultSet.getString(2);
                int cost = resultSet.getInt(3);
                product.add(new Product(id_product, name_product, cost));
            }
            return product;
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method removes records to database
     * @param id_product products identifier
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws NamingException
     */
    public static void deleteProduct(int id_product) throws SQLException, ClassNotFoundException, NamingException {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("DELETE FROM product WHERE id_product=?");
            {
                ps.setInt(1, id_product);
                ps.executeUpdate();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method adds new orders to database
     * @param name_product name of product
     * @param cost the price of the product
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void addProduct(String name_product, String cost) throws SQLException, ClassNotFoundException {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO product (name_product,cost) VALUES (?,?)");
            {
                ps.setString(1, name_product);
                ps.setInt(2, Integer.parseInt(cost));
                ps.executeUpdate();
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

}
