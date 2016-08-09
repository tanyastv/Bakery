import javax.activation.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.*;
import java.util.*;
import javax.activation.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
//import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//import static org.apache.taglibs.standard.Version.getOrder

/**
 * Created by USER on 22.07.2016.
 */
public class DAO_Order {
    public static Connection getConnection() throws ClassNotFoundException, SQLException, NamingException {
        String url = "jdbc:mysql://localhost:3306/bakery";
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(url, "root", "root");
        return connection;
    }

    public static List<Order> getOrder() throws SQLException, ClassNotFoundException {
        try {Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT id_order,name_order,id_product,id_provider,nds from bakery.order");
            ResultSet resultSet = ps.executeQuery();

            ArrayList<Order> order = new ArrayList<>();
            while (resultSet.next()) {
                int id_order = resultSet.getInt(1);
                String name_order = resultSet.getString(2);
                int id_product = resultSet.getInt(3);
                int id_provider = resultSet.getInt(4);
                int nds = resultSet.getInt(5);
                order.add(new Order(id_order, name_order, id_product, id_provider, nds));
                System.out.println(order.size());
            }
            return order;
        }
        catch (NamingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void deleteOrder(int id_order) throws SQLException, ClassNotFoundException, NamingException {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("DELETE FROM bakery.order WHERE id_order=?");
            {
                ps.setInt(1, id_order);
                ps.executeUpdate();
            }
        }
            catch(NamingException e){
            e.printStackTrace();
        } }
        //return null;

    public static void addOrder(String name_order, String id_product, String id_provider, String nds) throws SQLException, ClassNotFoundException {
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement("INSERT INTO bakery.order (name_order,id_product,id_provider,nds) VALUES (?,?,?,?)");
            {
                ps.setString(1, name_order);
                ps.setInt(2, Integer.parseInt(id_product));
                ps.setInt(3, Integer.parseInt(id_provider));
                ps.setInt(4, Integer.parseInt(nds));
                ps.executeUpdate();
            }
        }
        catch(NamingException e){
            e.printStackTrace();
        }

    }

}
