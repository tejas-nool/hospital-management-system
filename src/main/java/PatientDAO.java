
import java.sql.*;
import java.util.Scanner;

    public class PatientDAO {
        private static final Scanner sc = new Scanner(System.in);

        public static void addPatient() {
            System.out.print("Enter patient name: ");
            String name = sc.nextLine();

            System.out.print("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter gender: ");
            String gender = sc.nextLine();

            System.out.print("Enter phone: ");
            String phone = sc.nextLine();

            System.out.print("Enter address: ");
            String address = sc.nextLine();

            String sql = "INSERT INTO patients(name, age, gender, phone, address) VALUES(?,?,?,?,?)";

            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, name);
                ps.setInt(2, age);
                ps.setString(3, gender);
                ps.setString(4, phone);
                ps.setString(5, address);

                ps.executeUpdate();

                System.out.println("Patient Registered Successfully!");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static void viewPatients() {

            String sql = "SELECT * FROM patients";

            try {
                Connection con = DBConnection.getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                System.out.println("\n===== PATIENT DETAILS =====");

                while (rs.next()) {

                    System.out.println("Patient ID: " + rs.getInt("patient_id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Age: " + rs.getInt("age"));
                    System.out.println("Gender: " + rs.getString("gender"));
                    System.out.println("Phone: " + rs.getString("phone"));
                    System.out.println("Address: " + rs.getString("address"));

                    System.out.println("--------------------------");
                }

                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public static void searchPatient() {
            System.out.print("Enter Patient ID: ");
            int id = sc.nextInt();

            String sql = "SELECT * FROM patients WHERE patient_id = ?";

            try {
                Connection con = DBConnection.getConnection();

                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    System.out.println("\nPATIENT FOUND!");
                    System.out.println("ID: " + rs.getInt("patient_id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Age: " + rs.getInt("age"));
                    System.out.println("Gender: " + rs.getString("gender"));
                    System.out.println("Phone: " + rs.getString("phone"));
                    System.out.println("Address: " + rs.getString("address"));
                } else {
                    System.out.println("Patient not found!");
                }

                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

