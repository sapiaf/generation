import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/db_eventi";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public ArrayList<Evento> getEventiFromDatabase() {
        ArrayList<Evento> eventi = new ArrayList<>();
        String sql = "SELECT * FROM eventi JOIN concerti ON eventi.ID  = concerti.Evento_ID;";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("ID");
                String titolo = rs.getString("titolo");
                LocalDate data = rs.getDate("data").toLocalDate();
                int numeroPostiTotali = rs.getInt("numeroPostiTotali");
                int numeroPostiPrenotati = rs.getInt("numeroPostiPrenotati"); // Aggiungi questo campo
                LocalTime ora = rs.getTime("ora").toLocalTime();
                BigDecimal prezzo = rs.getBigDecimal("prezzo");
                eventi.add(new Concerto(id, titolo, data, numeroPostiTotali,numeroPostiPrenotati, ora, prezzo));
            }
        } catch (SQLException e) {
            System.out.println("Errore nel recuperare eventi: " + e.getMessage());
        }
        return eventi;
    }

    public void aggiornaPostiPrenotati(Evento evento) {
        String sql = "UPDATE eventi SET numeroPostiPrenotati = ? WHERE ID = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, evento.getNumeroPostiPrenotati());
            ps.setInt(2, evento.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Errore nell'aggiornare i posti prenotati: " + e.getMessage());
        }
    }

    public void aggiungiEvento(Concerto concerto) {
        String sqlEvento = "INSERT INTO eventi (titolo, data, numeroPostiTotali, numeroPostiPrenotati, tipo) VALUES (?, ?, ?, ?, ?)";
        String sqlConcerto = "INSERT INTO concerti (Evento_id, ora, prezzo) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement psEvento = connection.prepareStatement(sqlEvento, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement psConcerto = connection.prepareStatement(sqlConcerto)) {

            psEvento.setString(1, concerto.getTitolo());
            psEvento.setDate(2, Date.valueOf(concerto.getData()));
            psEvento.setInt(3, concerto.getNumeroPostiTotali());
            psEvento.setInt(4, concerto.getNumeroPostiPrenotati());
            psEvento.setString(5, "concerto");

            psEvento.executeUpdate();
            ResultSet generatedKeys = psEvento.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                concerto.setId(id);
            }

            psConcerto.setInt(1, concerto.getId());
            psConcerto.setTime(2, Time.valueOf(concerto.getOra()));
            psConcerto.setBigDecimal(3, concerto.getPrezzo());
            psConcerto.executeUpdate();


        } catch (SQLException e) {
            System.out.println("Errore nell'aggiungere l'evento al database: " + e.getMessage());
        }
    }

}
