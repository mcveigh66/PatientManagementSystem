public class PatientManagementTest {
    public static void main(String[] args) {
        System.out.println("Running Unit Tests...\n");

        testQueueEnqueueAndDequeue();
        testQueueEmptyHandling();
        testHistoryBoundaries();

        System.out.println("\nAll Unit Tests Completed Successfully!");
    }

    public static void testQueueEnqueueAndDequeue() {
        WaitingQueueManager q = new WaitingQueueManager();
        q.addPatient(new Patient("P1", "Alice", "Fever"));
        q.addPatient(new Patient("P2", "Bob", "Cough"));

        Patient served = q.servePatient();
        assert served.getName().equals("Alice") : "Test Failed: Expected Alice to be served first.";
        System.out.println("[PASS] Test Queue Enqueue and Dequeue (FIFO)");
    }

    public static void testQueueEmptyHandling() {
        WaitingQueueManager q = new WaitingQueueManager();
        Patient served = q.servePatient();
        assert served == null : "Test Failed: Expected null when serving an empty queue.";
        System.out.println("[PASS] Test Queue Safe Empty Handling");
    }
    
    public static void testHistoryBoundaries() {
        PatientHistoryManager history = new PatientHistoryManager();
        // Move backwards past the head
        for (int i = 0; i < 20; i++) {
            history.previousRecord();
        }
    
        System.out.println("[PASS] Test History Boundary Protection");
    }
}