import java.sql.*;
import java.util.ArrayList;

public class GestoreDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/db_treni_test";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public ArrayList<Tratta> getTratteDatabase() {
        ArrayList<Tratta> tratte = new ArrayList<>();
        String sql = "SELECT * FROM tratte;";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while(rs.next()) {
                        int id = rs.getInt("id");
                        String partenza = rs.getString("partenza");
                        String arrivo = rs.getString("arrivo");
                        int km = rs.getInt("km");
                        tratte.add(new Tratta(id, partenza, arrivo, km));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("OOPS an error occurred: " + e.getMessage());
        }
        return tratte;
    }
}
