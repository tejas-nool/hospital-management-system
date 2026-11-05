
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.Scanner;

public class AppointmentDAO {
    private static final Scanner sc = new Scanner(System.in);

    public static void bookAppointment() {
        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();

        System.out.print("Enter Doctor ID: ");
        int doctorId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        String sql = "INSERT INTO appointments " +
                "(patient_id, doctor_id, appointment_date, status) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);
            ps.setInt(2, doctorId);
            ps.setDate(3, Date.valueOf(date));
            ps.setString(4, "Scheduled");

            ps.executeUpdate();

            System.out.println("Appointment Booked Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewAppointments() {

        String sql = "SELECT a.appointment_id, p.name AS patient, " +
                "d.name AS doctor, a.appointment_date, a.status " +
                "FROM appointments a " +
                "JOIN patients p ON a.patient_id = p.patient_id " +
                "JOIN doctors d ON a.doctor_id = d.doctor_id";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n===== APPOINTMENTS =====");

            while (rs.next()) {
                System.out.println("Appointment ID: " +
                        rs.getInt("appointment_id"));
                System.out.println("Patient: " +
                        rs.getString("patient"));
                System.out.println("Doctor: " +
                        rs.getString("doctor"));
                System.out.println("Date: " +
                        rs.getDate("appointment_date"));
                System.out.println("Status: " +
                        rs.getString("status"));
                System.out.println("----------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

