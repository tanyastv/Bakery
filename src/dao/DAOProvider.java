package dao;

import entity.Order;
import entity.Provider;

import javax.naming.NamingException;
import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Class realize access to data of providers entity
 * @author Sarnavskaya
 */

public class DAOProvider {
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
     * Method that getting list of providers from database
     * @return list of providers
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static List<Provider> getProvider() throws SQLException, ClassNotFoundException {
        ArrayList<Provider> provider = null;
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM provider");
            ResultSet resultSet = ps.executeQuery();

            provider = new ArrayList<>();
            while (resultSet.next()) {
                int id_provider = resultSet.getInt(1);
                int id_product = resultSet.getInt(2);
                Date date_of_delivery = resultSet.getDate(3);
                String name_product = resultSet.getString(4);
                provider.add(new Provider(id_provider, id_product, date_of_delivery, name_product));
            }
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return provider;
    }

    /**
     * Method removes records to database
     * @param id_provider providers identifier
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws NamingException
     */
    public static void deleteProvider(int id_provider) throws SQLException, ClassNotFoundException, NamingException {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("DELETE FROM provider WHERE id_provider=?");
            {
                ps.setInt(1, id_provider);
                ps.executeUpdate();
            }
            System.out.println("PreparedStatement: " + ps);
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method adds new providers to database
     * @param id_product products identifier
     * @param date_of_delivery date of delivery
     * @param name_provider providers name
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void addProvider(String id_product, String date_of_delivery, String name_provider) throws SQLException, ClassNotFoundException {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO provider (id_product, date_of_delivery,name_provider) VALUES (?,?,?)");
            {
                ps.setInt(1, Integer.parseInt(String.valueOf(id_product)));
                ps.setDate(2, Date.valueOf(date_of_delivery));
                ps.setString(3, name_provider);
                ps.executeUpdate();
            }
            System.out.println("PreparedStatement: " + ps);
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

}
