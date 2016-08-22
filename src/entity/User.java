package entity;

import javax.naming.NamingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

import static java.sql.DriverManager.getConnection;

/**
 * Created by USER on 13.08.2016.
 */
public class User {
    int id_user;
    String name_user;
    String passwordd;
    int is_admin;

    public int getId_user() {
        return id_user;
    }

    public String getName_user() {
        return name_user;
    }

    public String getPasswordd() {
        return passwordd;
    }

    public boolean is_admin() {
        return (is_admin == 1);
    }

    public User(String name_user, String passwordd, int is_admin) {
        this.name_user = name_user;
        this.passwordd = passwordd;
        this.is_admin = is_admin;
    }

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

    public static void add(String name_user, String passwordd) throws SQLException, ClassNotFoundException, NamingException {

        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO users (name_user, passwordd, is_admin) VALUES (?, ?, 0)");

            ps.setString(1, name_user);
            ps.setString(2, passwordd);
            ps.executeUpdate();

        } catch (NamingException e) {
            throw e;
        }

    }

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
            throw e;
        }
        return user;
    }


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
            throw e;
        } finally {
            return user;
        }

    }

    public static boolean valid(User user, String passwordd) throws Exception {
        try {
            return (user.getPasswordd().equals(passwordd));
        } catch (Exception e) {
            throw e;
        }
    }



}


