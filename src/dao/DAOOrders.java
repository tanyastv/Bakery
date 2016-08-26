package dao;

import entity.Order;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Class realize access to data of orders entity
 * @author Sarnavskaya
 */
public class DAOOrders {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DAOOrders.class);

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
     * Method that getting list of orders from database
     * @return list of orders
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static List<Order> getOrders() throws SQLException, ClassNotFoundException {
        ArrayList<Order> orders = null;
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM orders");
            ResultSet resultSet = ps.executeQuery();

            orders = new ArrayList<>();
            while (resultSet.next()) {
                int id_order = resultSet.getInt(1);
                String name_order = resultSet.getString(2);
                int id_product = resultSet.getInt(3);
                int id_provider = resultSet.getInt(4);
                int nds = resultSet.getInt(5);
                orders.add(new Order(id_order, name_order, id_product, id_provider, nds));
            }
        } catch (NamingException e) {
            log.error("NamingException");
            e.printStackTrace();
        }
        return orders;
    }

    /**
     * Method removes records to database
     * @param id_order orders identifier
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws NamingException
     */
    public static void deleteOrders(int id_order) throws SQLException, ClassNotFoundException, NamingException {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("DELETE FROM orders WHERE id_order=?");
            {
                ps.setInt(1, id_order);
                ps.executeUpdate();
            }
            System.out.println("PreparedStatement: " + ps);
        } catch (NamingException e) {
            log.error("NamingException");
            e.printStackTrace();
        }
    }

    /**
     * Method adds new orders to database
     * @param name_order name of order
     * @param id_product products identifier
     * @param id_provider providers identifier
     * @param nds value-added tax
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void addOrders(String name_order, String id_product, String id_provider, String nds) throws SQLException, ClassNotFoundException {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO orders (name_order,id_product,id_provider,nds) VALUES (?,?,?,?)");
            {
                ps.setString(1, name_order);
                ps.setInt(2, Integer.parseInt(id_product));
                ps.setInt(3, Integer.parseInt(id_provider));
                ps.setInt(4, Integer.parseInt(nds));
                ps.executeUpdate();
            }
        } catch (NamingException e) {
            log.error("NamingException");
            e.printStackTrace();
        }

    }

}
