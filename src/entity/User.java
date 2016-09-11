package entity;

import dao.DAOOrders;

import javax.naming.NamingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

import static java.sql.DriverManager.getConnection;

/**
 * Class describing the users registered in this application
 *
 * @author Sarnavskaya
 */
public class User {
    private int id_user;
    private String name_user;
    private String passwordd;
    private int is_admin;

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(User.class);

    public int getId_user() {
        return id_user;
    }

    public String getName_user() {
        return name_user;
    }

    public String getPasswordd() {
        return passwordd;
    }

    /**
     * Field displays the user status (administrator/regular user)
     *
     * @return is_admin
     */
    public boolean is_admin() {
        return (is_admin == 1);
    }

    public User(String name_user, String passwordd, int is_admin) {
        this.name_user = name_user;
        this.passwordd = passwordd;
        this.is_admin = is_admin;
    }

    /**
     * Create object of connection with database
     *
     * @return
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

    public User(int id_user, String name_user, String passwordd, int is_admin) throws NoSuchAlgorithmException {
        this(name_user, passwordd, is_admin);
        this.id_user = id_user;
    }

    /**
     * Method adds new user to database
     *
     * @param name_user user name
     * @param passwordd user password
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws NamingException
     */

    public static void add(String name_user, String passwordd) throws SQLException, ClassNotFoundException, NamingException {

        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO users (name_user, passwordd, is_admin) VALUES (?, ?, 0)");

            ps.setString(1, name_user);
            ps.setString(2, passwordd);
            ps.executeUpdate();

        } catch (NamingException e) {
            log.error("NamingException");
            throw e;
        }

    }

    /**
     * Method that getting list of user from database
     *
     * @param name_user user name
     * @return list of user
     * @throws SQLException
     * @throws NamingException
     * @throws NoSuchAlgorithmException
     * @throws ClassNotFoundException
     */
    public static User get(String name_user) throws SQLException, NamingException, NoSuchAlgorithmException, ClassNotFoundException {
        User user = null;

        PreparedStatement statement = null;
        ResultSet rs;

        try {

            Connection c = getConnection();
            statement = c.prepareStatement("SELECT * FROM users WHERE name_user = ?");
            statement.setString(1, name_user);

            rs = statement.executeQuery();

            if (rs.first()) {
                user = new User(rs.getInt("id_user"), rs.getString("name_user"), rs.getString("passwordd"), rs.getInt("is_admin"));
            }
        } catch (Exception e) {
            log.error("Exception");
            throw e;
        }
        return user;
    }

    /**
     * Method gets list of user from database
     *
     * @param id_user user identifier
     * @return list of user
     * @throws SQLException
     * @throws NamingException
     * @throws NoSuchAlgorithmException
     */
    public static User get(int id_user) throws SQLException, NamingException, NoSuchAlgorithmException {
        User user = null;

        PreparedStatement statement = null;
        ResultSet rs;

        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE id_user = ?");
            statement.setInt(1, id_user);

            rs = statement.executeQuery();

            if (rs.first()) {
                user = new User(rs.getInt("id_user"), rs.getString("name_user"), rs.getString("passwordd"), rs.getInt("is_admin"));
            }
        } catch (Exception e) {
            log.error("Exception");
            throw e;
        } finally {
            return user;
        }

    }

    /**
     * Method validate users password
     *
     * @param user      user
     * @param passwordd user password
     * @return true/false
     * @throws Exception
     */
    public static boolean valid(User user, String passwordd) throws Exception {
        try {
            return (user.getPasswordd().equals(passwordd));
        } catch (Exception e) {
            log.error("Exception");
            throw e;
        }
    }

}


