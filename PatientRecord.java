public class PatientRecord {
    private final String visitDate;
    private final String diagnosis;
    private final String treatmentNotes;
    
    PatientRecord next;
    PatientRecord prev;

    public PatientRecord(String visitDate, String diagnosis, String treatmentNotes) {
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.treatmentNotes = treatmentNotes;
        this.next = null;
        this.prev = null;
    }

    public String getVisitDate() { return visitDate; }
    public String getDiagnosis() { return diagnosis; }
    public String getTreatmentNotes() { return treatmentNotes; }

    @Override
    public String toString() {
        return "Visit Date: " + visitDate + "\nDiagnosis: " + diagnosis + "\nNotes: " + treatmentNotes;
    }
}
