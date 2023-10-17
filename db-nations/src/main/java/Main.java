import java.sql.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_nations";
        String user = "root";
        String password = "cacopocomacaco";

        String sql = "SELECT c2.country_id, c2.name, r.name, c.name FROM regions r JOIN continents c  ON r.continent_id = c.continent_id JOIN countries c2 ON r.region_id = c2.region_id ORDER BY c2.name;";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println("-----------------------------------------------------------");
                System.out.printf("%-10s %-30s %-20s %-20s\n", "Country ID", "Country Name", "Region Name", "Continent Name");
                System.out.println("-----------------------------------------------------------");

                while (rs.next()) {
                    String countryId = rs.getString("c2.country_id");
                    String countryName = rs.getString("c2.name");
                    String regionName = rs.getString("r.name");
                    String continentName = rs.getString("c.name");

                    System.out.printf("%-10s %-30s %-20s %-20s\n", countryId, countryName, regionName, continentName);
                }

                System.out.println("-----------------------------------------------------------");
            }

        } catch (SQLException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
