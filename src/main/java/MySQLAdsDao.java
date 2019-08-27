import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection;

    public  Connection connect() throws SQLException {
        DriverManager.registerDriver(new Driver());
        this.connection = DriverManager.getConnection(
                Config.getUrl(),
                Config.getUsername(),
                Config.getPassword()
        );
        return connection;
    }
    public MySQLAdsDao() {
        try {
            this.connection = connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Ad> all() {
        try {
        Statement statement = connection.createStatement();
        String queryString = "SELECT * FROM ads;";
        ResultSet results = statement.executeQuery(queryString);
        return generateAds(results);
        }
        catch (SQLException e) {
            e.printStackTrace();
           return all();
        }
    }
    private List<Ad> generateAds(ResultSet rs) throws SQLException{
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extracted(rs));
        }
        return ads;
    }
    private Ad extracted(ResultSet rs) throws SQLException {
        return new Ad (
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }
    @Override
    public Long insert(Ad ad) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement
                ("INSERT INTO ads (user_id, title, description) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        stmt.setLong(1,ad.getUserId());
        stmt.setString(2, ad.getTitle());
        stmt.setString(3, ad.getDescription());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        return rs.getLong(1);
    }
}