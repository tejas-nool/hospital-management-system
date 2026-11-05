
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DoctorDAO {
    private static final Scanner sc = new Scanner(System.in);

    public static void addDoctor() {
        System.out.print("Enter doctor name: ");
        String name = sc.nextLine();

        System.out.print("Enter specialization: ");
        String specialization = sc.nextLine();

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        String sql = "INSERT INTO doctors(name, specialization, phone) VALUES(?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, specialization);
            ps.setString(3, phone);

            ps.executeUpdate();

            System.out.println("Doctor Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewDoctors() {

        String sql = "SELECT * FROM doctors";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n===== DOCTOR DETAILS =====");

            while (rs.next()) {
                System.out.println("Doctor ID: " + rs.getInt("doctor_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Specialization: " + rs.getString("specialization"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("-------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

