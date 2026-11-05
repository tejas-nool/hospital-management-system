
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== HOSPITAL MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Add Doctor");
            System.out.println("5. View Doctors");
            System.out.println("6. Book Appointment");
            System.out.println("7. View Appointments");
            System.out.println("8. Generate Bill");
            System.out.println("9. View Bills");
            System.out.println("10. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    PatientDAO.addPatient();
                    break;

                case 2:
                    PatientDAO.viewPatients();
                    break;

                case 3:
                    PatientDAO.searchPatient();
                    break;

                case 4:
                    DoctorDAO.addDoctor();
                    break;

                case 5:
                    DoctorDAO.viewDoctors();
                    break;

                case 6:
                    AppointmentDAO.bookAppointment();
                    break;

                case 7:
                    AppointmentDAO.viewAppointments();
                    break;

                case 8:
                    BillingDAO.addBill();
                    break;

                case 9:
                    BillingDAO.viewBills();
                    break;

                case 10:
                    System.out.println("Thank you for using Hospital Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 10);

        sc.close();
    }
}




