import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.math.BigDecimal;
import java.util.Scanner;

public class BillingDAO {
    private static final Scanner sc = new Scanner(System.in);

    public static void addBill() {
        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();

        System.out.print("Enter Bill Amount: ");
        BigDecimal amount = sc.nextBigDecimal();
        sc.nextLine();

        System.out.print("Enter Payment Status (Paid/Unpaid): ");
        String status = sc.nextLine();

        String sql = "INSERT INTO bills (patient_id, amount, payment_status) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);
            ps.setBigDecimal(2, amount);
            ps.setString(3, status);

            ps.executeUpdate();

            System.out.println("Bill Generated Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewBills() {

        String sql = "SELECT b.bill_id, p.name AS patient, " +
                "b.amount, b.payment_status " +
                "FROM bills b " +
                "JOIN patients p ON b.patient_id = p.patient_id";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n===== BILL DETAILS =====");

            while (rs.next()) {
                System.out.println("Bill ID: " + rs.getInt("bill_id"));
                System.out.println("Patient: " + rs.getString("patient"));
                System.out.println("Amount: " + rs.getBigDecimal("amount"));
                System.out.println("Payment Status: " + rs.getString("payment_status"));
                System.out.println("----------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
