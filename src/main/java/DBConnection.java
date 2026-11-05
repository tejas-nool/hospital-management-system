import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DBConnection {

        private static final String URL =
                "jdbc:mysql://localhost:3306/hospital_db";

        private static final String USER = "root";

        private static final String PASSWORD =
                System.getenv("DB_PASSWORD");

        public static Connection getConnection() {

            try {
                Connection con = DriverManager.getConnection(
                        URL, USER, PASSWORD
                );

                System.out.println("Connected Successfully!");
                return con;

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
