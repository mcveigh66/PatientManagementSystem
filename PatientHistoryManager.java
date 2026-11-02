public class PatientHistoryManager {
    private PatientRecord head; // oldest record
    private PatientRecord tail; // newest record
    private PatientRecord current; // currently viewed record

    public PatientHistoryManager() {
        this.head = null;
        this.tail = null;
        this.current = null;
        loadDefaultRecords();
    }

    private void loadDefaultRecords() {
        String[] dates = {
            "2024-01-10", "2024-02-15", "2024-03-20", "2024-04-05", "2024-05-12",
            "2024-06-18", "2024-07-22", "2024-08-30", "2024-09-14", "2024-10-01"
        };
        String[] diagnoses = {
            "Common Cold", "Sprained Ankle", "Migraine", "Hypertension", "Bronchitis",
            "Allergic Reaction", "Gastroenteritis", "Minor Laceration", "Strep Throat", "Routine Checkup"
        };
        String[] notes = {
            "Rest and fluids prescribed.", "RICE method and bandage.", "Pain relievers given.",
            "Monitor blood pressure daily.", "Inhaler and cough syrup.", "Antihistamine administered.",
            "Hydration and bland diet.", "Cleaned and stitches applied.", "Antibiotics prescribed.",
            "All vitals normal."
        };

        for (int i = 0; i < 10; i++) {
            addRecord(new PatientRecord(dates[i], diagnoses[i], notes[i]));
        }
    }

    public void addRecord(PatientRecord newRecord) {
        if (head == null) {
            head = newRecord;
            tail = newRecord;
            current = newRecord;
        } else {
            tail.next = newRecord;
            newRecord.prev = tail;
            tail = newRecord;
            current = tail; // Point current to the newest by default
        }
    }

    public void nextRecord() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Moved to next record.");
        } else {
            System.out.println("Prevented: You are already at the newest record (Tail).");
        }
    }

    public void previousRecord() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Moved to previous record.");
        } else {
            System.out.println("Prevented: You are already at the oldest record (Head).");
        }
    }

    public void displayNewest() {
        if (tail != null) {
            current = tail;
            System.out.println("\n--- Newest Record ---");
            System.out.println(current);
        }
    }

    public void displayOldest() {
        if (head != null) {
            current = head;
            System.out.println("\n--- Oldest Record ---");
            System.out.println(current);
        }
    }

    public void displayCurrent() {
        if (current != null) {
            System.out.println("\n--- Current Record ---");
            System.out.println(current);
        } else {
            System.out.println("No records available.");
        }
    }
}
