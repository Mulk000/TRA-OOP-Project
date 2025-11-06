package Entity;

import Interface.Displayable;

import java.time.LocalDate;
import java.util.List;

public class GeneralPractitioner extends Doctor implements Displayable {
    private boolean walkinAvailable;
    private boolean homeVisitAvailable;
    private boolean vaccinationCertified;

    public GeneralPractitioner() {

    }

    public boolean isHomeVisitAvailable() {
        return homeVisitAvailable;
    }

    public void setHomeVisitAvailable(boolean homeVisitAvailable) {
        this.homeVisitAvailable = homeVisitAvailable;
    }

    public boolean isWalkinAvailable() {
        return walkinAvailable;
    }

    public void setWalkinAvailable(boolean walkinAvailable) {
        this.walkinAvailable = walkinAvailable;
    }

    public boolean isVaccinationCertified() {
        return vaccinationCertified;
    }

    public void setVaccinationCertified(boolean vaccinationCertified) {
        this.vaccinationCertified = vaccinationCertified;
    }

    public GeneralPractitioner(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, Double consultationFee, List<String> availableSlots, List<String> assignedPatients, boolean walkinAvailable, boolean homeVisitAvailable, boolean vaccinationCertified) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.walkinAvailable = walkinAvailable;
        this.homeVisitAvailable = homeVisitAvailable;
        this.vaccinationCertified = vaccinationCertified;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("walkinAvailable: " + walkinAvailable);
        System.out.println("homeVisitAvailable: " + homeVisitAvailable);
        System.out.println("vaccinationCertified: " + vaccinationCertified);
    }

    public void scheduleHomeVisit(Patient patient) {
        if (homeVisitAvailable) {
            System.out.println("Scheduled home visit for patient: " + patient.getPatientId());
        } else {
            System.out.println("Home visit not available.");
        }
    }

    public void administerVaccine(Patient patient) {
        if (vaccinationCertified) {
            System.out.println("Administered vaccine to patient: " + patient.getPatientId());
        } else {
            System.out.println("Not certified to administer vaccines.");
        }
    }
}