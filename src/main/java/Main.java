import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

// Написати код який змінить fist_name другому(якщо 1 юзер, то першому) юзеру

    public static void main(String[] args) {

        try (var connection = DriverManager.getConnection(JDBCConstants.URL, JDBCConstants.USERNAME, JDBCConstants.PASSWORD)) {

            var statement = connection.prepareStatement(SqlQueries.UPDATE_USER_AGE);
            var prepareStatement = connection.prepareStatement(SqlQueries.UPDATE_USER_AGE);

            statement.execute(SqlQueries.CREATE_TABLE);
//          statement.execute(SqlQueries.INSERT_USERS);

//            prepareStatement.setInt(1, 100);
//            prepareStatement.setInt(2, 1);
//
//            prepareStatement.executeUpdate();

            var resultSet = statement.executeQuery(SqlQueries.SELECT_ALL_USERS);

            var users = new ArrayList<>();

            while (resultSet.next()) {

                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setFirstName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getInt(4));

                users.add(user);
            }

            users.forEach(System.out::println);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
