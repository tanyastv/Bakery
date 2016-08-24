package dao;

import entity.Product;

import javax.naming.NamingException;
//import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sarnavskaya
 */

/**
 * getConnection - метод для установления соединения с БД
 * getProduct - метод для выборки данных из сущности Продукты и доюавления их в список
 * deleteProduct - метод для удаления записей из сущности Продукты
 * addProduct - метод для добавления записей в сущность Продукты
 */

public class DAOProduct {
    public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {
        String url = "jdbc:mysql://localhost:3306/bakery";
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(url, "root", "root");
        return connection;
    }

    public static List<Product> getProduct() throws SQLException, ClassNotFoundException {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT id_product,name_product,cost from product");
            ResultSet resultSet = ps.executeQuery();

            ArrayList<Product> product = new ArrayList<>();
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
