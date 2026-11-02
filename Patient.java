public class Patient {
    private final String patientId;
    private final String name;
    private final String reasonForVisit;

    public Patient(String patientId, String name, String reasonForVisit) {
        this.patientId = patientId;
        this.name = name;
        this.reasonForVisit = reasonForVisit;
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public String getReasonForVisit() { return reasonForVisit; }

    @Override
    public String toString() {
        return "Patient ID: " + patientId + " | Name: " + name + " | Reason: " + reasonForVisit;
    }
}