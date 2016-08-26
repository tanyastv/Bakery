package dao;

import entity.Order;
import entity.Sale;

import javax.naming.NamingException;
//import javax.sql.DataSource;
import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Class realize access to data of sale entity
 * @author Sarnavskaya
 */
public class DAOSale {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DAOSale.class);

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
     * Method that getting list of sale from database
     * @return list of sale
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static List<Sale> getSale() throws SQLException, ClassNotFoundException {
        ArrayList<Sale> sale = null;
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM sale");
            ResultSet resultSet = ps.executeQuery();

            sale = new ArrayList<>();
            while (resultSet.next()) {
                int id_sale = resultSet.getInt(1);
                int id_seller = resultSet.getInt(2);
                int id_product = resultSet.getInt(3);
                int cost_sale = resultSet.getInt(4);
                java.sql.Date date_of_sale = resultSet.getDate(5);
                sale.add(new Sale(id_sale, id_seller, id_product, cost_sale, date_of_sale));
            }

        } catch (NamingException e) {
            log.error("NamingException");
            e.printStackTrace();
        }
        return sale;
    }

    /**
     * Method removes records to database
     * @param id_sale sale identifier
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws NamingException
     */
    public static void deleteSale(int id_sale) throws SQLException, ClassNotFoundException, NamingException {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("DELETE FROM sale WHERE id_sale=?");
            {
                ps.setInt(1, id_sale);
                ps.executeUpdate();
            }
        } catch (NamingException e) {
            log.error("NamingException");
            e.printStackTrace();
        }

    }

    /**
     * Method adds new sale to database
     * @param id_seller sellers identifier
     * @param id_product products identifier
     * @param cost_sale cost sale
     * @param date_of_sale date of sale
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void addSale(String id_seller, String id_product, String cost_sale, String date_of_sale) throws SQLException, ClassNotFoundException {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO sale (id_seller, id_product, cost_sale, date_of_sale) VALUES (?,?,?,?)");
            {
                ps.setInt(1, Integer.parseInt(String.valueOf(id_seller)));
                ps.setInt(2, Integer.parseInt(String.valueOf(id_product)));
                ps.setInt(3, Integer.parseInt(String.valueOf(cost_sale)));
                ps.setDate(4, Date.valueOf(date_of_sale));
                ps.executeUpdate();
            }
        } catch (NamingException e) {
            log.error("NamingException");
            e.printStackTrace();
        }

    }

}
