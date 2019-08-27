import com.mysql.cj.jdbc.Driver;
import java.sql.*;


public class MySQLJDBCTest {

    public static Connection connect() throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(
                Config.getUrl(),
                Config.getUsername(),
                Config.getPassword()
        );
        return connection;
    }

    public static void main(String[] args) {
        try {
            Connection connection = connect();
            System.out.println("Connection Successful");
            Statement statement = connection.createStatement();
            String queryString = "SELECT * FROM users;";
            ResultSet results = statement.executeQuery(queryString);
            if (results != null) {
                System.out.println("query executed!");
                while (results.next()) {
                    System.out.print(results.getString("artist") + ": ");
                    System.out.print(" " + results.getString("name") + "\n");
                }
            } else {
                System.out.println("EXPLOSION");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

