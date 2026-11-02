import java.util.Scanner;

public class PatientManagementSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            WaitingQueueManager waitingRoom = new WaitingQueueManager();
            PatientHistoryManager historyManager = new PatientHistoryManager();
            
            boolean running = true;
            while (running) {
                System.out.println("\n=== HOSPITAL PATIENT MANAGEMENT SYSTEM ===");
                System.out.println("1. Waiting Room Menu");
                System.out.println("2. Patient History Menu");
                System.out.println("3. Exit");
                System.out.print("Select an option: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                switch (choice) {
                    case 1 -> {
                        runWaitingRoomMenu(scanner, waitingRoom);
                    }
                    case 2 -> {
                        runHistoryMenu(scanner, historyManager);
                    }
                    case 3 -> {
                        running = false;
                        System.out.println("Exiting system. Goodbye!");
                    }
                    default -> {
                        System.out.println("Invalid choice. Please try again.");
                    }
                }
            }
        }
    }

    private static void runWaitingRoomMenu(Scanner scanner, WaitingQueueManager waitingRoom) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Patient Waiting Room Menu ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Serve Next Patient");
            System.out.println("3. Insert Emergency Patient (Specific Position)");
            System.out.println("4. Print Waiting Queue");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Patient ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Patient Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Reason for Visit: ");
                    String reason = scanner.nextLine();
                    waitingRoom.addPatient(new Patient(id, name, reason));
                }
                case 2 -> {
                    waitingRoom.servePatient();
                }
                case 3 -> {
                    System.out.print("Enter position index (0 for front): ");
                    int pos = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Patient ID: ");
                    String eId = scanner.nextLine();
                    System.out.print("Enter Patient Name: ");
                    String eName = scanner.nextLine();
                    System.out.print("Enter Reason for Visit: ");
                    String eReason = scanner.nextLine();
                    waitingRoom.insertEmergencyPatient(pos, new Patient(eId, eName, eReason));
                }
                case 4 -> {
                    waitingRoom.printQueue();
                }
                case 5 -> {
                    back = true;
                }
                default -> {
                    System.out.println("Invalid option.");
                }
            }
        }
    }

    private static void runHistoryMenu(Scanner scanner, PatientHistoryManager historyManager) {
        boolean back = false;
        while (!back) {
            historyManager.displayCurrent();
            System.out.println("\n--- Patient History Navigation ---");
            System.out.println("1. Next Record (Forward)");
            System.out.println("2. Previous Record (Backward)");
            System.out.println("3. Jump to Newest Record");
            System.out.println("4. Jump to Oldest Record");
            System.out.println("5. Add New Record");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    historyManager.nextRecord();
                }
                case 2 -> {
                    historyManager.previousRecord();
                }
                case 3 -> {
                    historyManager.displayNewest();
                }
                case 4 -> {
                    historyManager.displayOldest();
                }
                case 5 -> {
                    System.out.print("Enter Visit Date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter Diagnosis: ");
                    String diag = scanner.nextLine();
                    System.out.print("Enter Treatment Notes: ");
                    String notes = scanner.nextLine();
                    historyManager.addRecord(new PatientRecord(date, diag, notes));
                    System.out.println("New record added successfully!");
                }
                case 6 -> {
                    back = true;
                }
                default -> {
                    System.out.println("Invalid option.");
                }
            }
        }
    }
}
