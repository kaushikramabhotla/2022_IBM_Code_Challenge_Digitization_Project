import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqlConnection {

        public static Connection connection() throws SQLException{
            Connection connection = null;
            try {
                Class.forName("org.sqlite.JDBC");

                connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\223053315\\IdeaProjects\\IBM\\src\\usersDB.db");

                System.out.println("connected to : " + connection.getMetaData());

            } catch (ClassNotFoundException e) {
                System.out.println(e + " ");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return connection;


        }
}
