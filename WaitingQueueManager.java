import java.util.LinkedList;

public class WaitingQueueManager {
    private final LinkedList<Patient> queue = new LinkedList<>();

    public void addPatient(Patient patient) {
        queue.addLast(patient);
        System.out.println("Patient added to waiting room: " + patient.getName());
    }

    public Patient servePatient() {
        if (queue.isEmpty()) {
            System.out.println("Error: Waiting room is empty. No patients to serve.");
            return null;
        }
        Patient served = queue.removeFirst();
        System.out.println("Serving patient: " + served.getName());
        return served;
    }

    public void insertEmergencyPatient(int position, Patient patient) {
        if (position < 0 || position > queue.size()) {
            System.out.println("Invalid position! Adding patient to the front instead.");
            queue.addFirst(patient);
        } else {
            queue.add(position, patient);
            System.out.println("Emergency patient inserted at position " + position + ": " + patient.getName());
        }
    }
    
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("The waiting room is currently empty.");
            return;
        }
        System.out.println("\n--- Current Waiting Room Queue ---");
        int index = 0;
        for (Patient p : queue) {
            System.out.println(index++ + ". " + p);
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public int size() {
        return queue.size();
    }
}
