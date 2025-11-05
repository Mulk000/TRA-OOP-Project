package Entity;

import Interface.Displayable;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.List;

public class OutPatient extends Patient implements Displayable {
    private int visitCount;
    private LocalDate lastVisitDate;
    private String preferredDoctorId;

    public OutPatient() {

    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public LocalDate getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(LocalDate lastVisitDate) {
        while (lastVisitDate.isAfter(LocalDate.now()) || lastVisitDate.isBefore(getRegistrationDate())) {
            System.out.println("Invalid date.Please try again");
            lastVisitDate = InputHandler.getDateInput("Enter last visit date: ");
        }
        this.lastVisitDate = lastVisitDate;
    }

    public String getPreferredDoctorId() {
        return preferredDoctorId;
    }

    public void setPreferredDoctorId(String preferredDoctorId) {
        this.preferredDoctorId = preferredDoctorId;
    }

    public OutPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId, List<MedicalRecord> medicalRecords, List<Appointment> appointments, int visitCount, LocalDate lastVisitDate, String preferredDoctorId) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, patientId, bloodGroup, allergies, emergencyContact, registrationDate, insuranceId, medicalRecords, appointments);
        this.visitCount = visitCount;
        this.lastVisitDate = lastVisitDate;
        this.preferredDoctorId = preferredDoctorId;
    }

    public OutPatient(int visitCount, LocalDate lastVisitDate, String preferredDoctorId) {
        this.visitCount = visitCount;
        this.lastVisitDate = lastVisitDate;
        this.preferredDoctorId = preferredDoctorId;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("visitCount: " + visitCount);
        System.out.println("lastVisitDate: " + lastVisitDate);
        System.out.println("preferredDoctorId: " + preferredDoctorId);

    }

    public void scheduleFollowUp(LocalDate visitDate) {
        setLastVisitDate(visitDate);
        setVisitCount(getVisitCount() + 1);
        System.out.println("Follow-up scheduled successfully. Visit count updated to " + visitCount);
    }

    public void updateVisitCount(int visits) {
        setVisitCount(visits);
        System.out.println("Visit count updated successfully to " + visitCount);
    }
}
