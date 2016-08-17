package dao;

import entity.Provider;

import javax.naming.NamingException;
import java.sql.*;
import java.sql.Date;
import java.util.*;

//import static org.apache.taglibs.standard.Version.getProvider;

public class DAOProvider {
    public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {
        String url = "jdbc:mysql://localhost:3306/bakery";
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(url, "root", "root");
        return connection;

    }

    public static List<Provider> getProvider() throws SQLException, ClassNotFoundException {
        try {Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM provider");
            ResultSet resultSet = ps.executeQuery();

            ArrayList<Provider> provider = new ArrayList<>();
            while (resultSet.next()) {
                int id_provider = resultSet.getInt(1);
                int id_product = resultSet.getInt(2);
                Date date_of_delivery = resultSet.getDate(3);
                String name_product = resultSet.getString(4);

                provider.add(new Provider(id_provider,id_product,date_of_delivery,name_product));
               // System.out.println(provider.size());
            }
            return provider;
        }
        catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void deleteProvider(int id_provider) throws SQLException, ClassNotFoundException, NamingException {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("DELETE FROM provider WHERE id_provider=?");
            {
                ps.setInt(1, id_provider);
                ps.executeUpdate();
            }
            System.out.println("PreparedStatement: " + ps);
        }
        catch(NamingException e){
            e.printStackTrace();
        }
        //return null;

    }
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
        }
        catch(NamingException e){
            e.printStackTrace();
        }

    }

}
