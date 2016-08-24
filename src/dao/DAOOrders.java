package dao;

import entity.Order;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sarnavskaya
 */

/**
 * getConnection - метод для установления соединения с БД
 * getOrders - метод для выборки данных из сущности Заказы и доюавления их в список
 * deleteOrders - метод для удаления записей из сущности Заказы
 * addOrders - метод для добавления записей в сущность Заказы
 */

public class DAOOrders {
    public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {
        String url = "jdbc:mysql://localhost:3306/bakery";
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(url, "root", "root");
        return connection;
    }

    public static List<Order> getOrders() throws SQLException, ClassNotFoundException {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM orders");
            ResultSet resultSet = ps.executeQuery();

            ArrayList<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                int id_order = resultSet.getInt(1);
                String name_order = resultSet.getString(2);
                int id_product = resultSet.getInt(3);
                int id_provider = resultSet.getInt(4);
                int nds = resultSet.getInt(5);
                orders.add(new Order(id_order, name_order, id_product, id_provider, nds));
            }
            return orders;
        } catch (NamingException e) {
            log.error("NamingException");
            e.printStackTrace();
        }
        return null;
    }

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
