import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static final String CREATE_TABLE = """
         CREATE TABLE IF NOT EXISTS user (
         id int PRIMARY KEY AUTO_INCREMENT,
         first_name varchar(50),
         last_name varchar(50),
         age int)
          """;


    public static void main(String[] args) {

        try (var connection = DriverManager.getConnection(JDBCConstants.URL, JDBCConstants.USERNAME, JDBCConstants.PASSWORD)) {
            var statement = connection.createStatement();

            statement.execute(CREATE_TABLE);


        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
