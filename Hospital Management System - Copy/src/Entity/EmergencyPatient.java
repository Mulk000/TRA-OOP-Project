package Entity;

import Interface.Displayable;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.List;

public class EmergencyPatient extends Patient implements Displayable {
    private String emergencyType;
    private String arrivalMode;
    private int triageLevel;
    private boolean admittedViaER;

    public EmergencyPatient() {

    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        this.emergencyType = emergencyType;
    }

    public String getArrivalMode() {
        return arrivalMode;
    }

    public void setArrivalMode(String arrivalMode) {
        this.arrivalMode = arrivalMode;
    }

    public int getTriageLevel() {
        return triageLevel;
    }

    public void setTriageLevel(int triageLevel) {
        while (triageLevel < 1 || triageLevel > 5) {
            System.out.println("Invalid triage level. Please enter a value between 1 and 5.");
            triageLevel = InputHandler.getIntInput("Enter triage level (1-5): ");
        }
        this.triageLevel = triageLevel;
    }


    public boolean isAdmittedViaER() {
        return admittedViaER;
    }

    public void setAdmittedViaER(boolean admittedViaER) {
        this.admittedViaER = admittedViaER;
    }

    public EmergencyPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId, List<MedicalRecord> medicalRecords, List<Appointment> appointments, String emergencyType, String arrivalMode, boolean admittedViaER, int triageLevel) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, patientId, bloodGroup, allergies, emergencyContact, registrationDate, insuranceId, medicalRecords, appointments);
        this.emergencyType = emergencyType;
        this.arrivalMode = arrivalMode;
        this.admittedViaER = admittedViaER;
        this.triageLevel = triageLevel;
    }

    public EmergencyPatient(String emergencyType, String arrivalMode, boolean admittedViaER, int triageLevel) {
        this.emergencyType = emergencyType;
        this.arrivalMode = arrivalMode;
        this.admittedViaER = admittedViaER;
        this.triageLevel = triageLevel;

}

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("emergencyType: "+emergencyType);
        System.out.println("arrivalMode: "+arrivalMode);
        System.out.println("triageLevel: "+triageLevel);
        System.out.println("admittedViaER: "+admittedViaER);
    }

    @Override
    public void displaySummary() {

    }
}




