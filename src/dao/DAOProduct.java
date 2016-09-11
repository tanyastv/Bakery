package dao;

import entity.Order;
import entity.Product;

import javax.naming.NamingException;
//import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Class realize access to data of products entity
 *
 * @author Sarnavskaya
 */
public class DAOProduct {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DAOProduct.class);

    /**
     * Create object of connection with database
     *
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
     *
     * @return list of products
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static List<Product> getProduct() throws SQLException, ClassNotFoundException {
        ArrayList<Product> product = null;
        try {
            Connection c = getConnection();
            ResourceBundle props = ResourceBundle.getBundle("accountSQL");
            String res = props.getString("product.select");
            PreparedStatement ps = c.prepareStatement(res);
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
            log.error("NamingException");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method removes records to database
     *
     * @param id_product products identifier
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws NamingException
     */
    public static void deleteProduct(int id_product) throws SQLException, ClassNotFoundException, NamingException {
        try {
            Connection c = getConnection();
            ResourceBundle props = ResourceBundle.getBundle("accountSQL");
            String res = props.getString("product.remove");
            PreparedStatement ps = c.prepareStatement(res);
            {
                ps.setInt(1, id_product);
                ps.executeUpdate();
            }
        } catch (NamingException e) {
            log.error("NamingException");
            e.printStackTrace();
        }

    }

    /**
     * Method adds new orders to database
     *
     * @param name_product name of product
     * @param cost         the price of the product
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void addProduct(String name_product, String cost) throws SQLException, ClassNotFoundException {
        try {
            Connection c = getConnection();
            ResourceBundle props = ResourceBundle.getBundle("accountSQL");
            String res = props.getString("product.insert");
            PreparedStatement ps = c.prepareStatement(res);
            {
                ps.setString(1, name_product);
                ps.setInt(2, Integer.parseInt(cost));
                ps.executeUpdate();
            }
        } catch (NamingException e) {
            log.error("NamingException");
            e.printStackTrace();
        }

    }

}
