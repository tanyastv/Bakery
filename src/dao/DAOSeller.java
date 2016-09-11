package dao;

import entity.Order;
import entity.Seller;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Class realize access to data of sellers entity
 *
 * @author Sarnavskaya
 */
public class DAOSeller {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DAOSeller.class);

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
     * Method that getting list of sellers from database
     *
     * @return list of sellers
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static List<Seller> getSeller() throws SQLException, ClassNotFoundException {
        ArrayList<Seller> seller = null;
        try {
            Connection c = getConnection();
            ResourceBundle props = ResourceBundle.getBundle("accountSQL");
            String res = props.getString("seller.select");
            PreparedStatement ps = c.prepareStatement(res);
            ResultSet resultSet = ps.executeQuery();

            seller = new ArrayList<>();
            while (resultSet.next()) {
                int id_seller = resultSet.getInt(1);
                String name_seller = resultSet.getString(2);
                int id_order = resultSet.getInt(3);
                seller.add(new Seller(id_seller, name_seller, id_order));
            }

        } catch (NamingException e) {
            log.error("NamingException");
            e.printStackTrace();
        }
        return seller;
    }

    /**
     * Method removes records to database
     *
     * @param id_seller sellers identifier
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws NamingException
     */
    public static void deleteSeller(int id_seller) throws SQLException, ClassNotFoundException, NamingException {
        try {
            Connection c = getConnection();
            ResourceBundle props = ResourceBundle.getBundle("accountSQL");
            String res = props.getString("seller.remove");
            PreparedStatement ps = c.prepareStatement(res);
            {
                ps.setInt(1, id_seller);
                ps.executeUpdate();
            }
        } catch (NamingException e) {
            log.error("NamingException");
            e.printStackTrace();
        }

    }

    /**
     * Method adds new sellers to database
     *
     * @param name_seller sellers name
     * @param id_order    orders identifier
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static void addSeller(String name_seller, String id_order) throws SQLException, ClassNotFoundException {
        try {
            Connection c = getConnection();
            ResourceBundle props = ResourceBundle.getBundle("accountSQL");
            String res = props.getString("seller.insert");
            PreparedStatement ps = c.prepareStatement(res);
            {
                ps.setString(1, name_seller);
                ps.setInt(2, Integer.parseInt(id_order));
                ps.executeUpdate();
            }
        } catch (NamingException e) {
            log.error("NamingException");
            e.printStackTrace();
        }

    }

}
