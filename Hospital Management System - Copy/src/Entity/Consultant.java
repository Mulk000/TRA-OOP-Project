package Entity;

import Interface.Displayable;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Consultant extends Doctor  implements Displayable {
    private List<String> consultationTypes;
    private boolean onlineConsultationAvailable;
    private int consultationDuration;

    public Consultant(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, Double consultationFee, List<String> availableSlots, List<String> assignedPatients, List<String> consultationTypes, boolean onlineConsultationAvailable, int consultationDuration) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee, availableSlots, assignedPatients);
        this.consultationTypes = consultationTypes;
        this.onlineConsultationAvailable = onlineConsultationAvailable;
        this.consultationDuration = consultationDuration;
    }

    public Consultant() {

    }

    public List<String> getConsultationTypes() {
        return consultationTypes;
    }

    public void setConsultationTypes(List<String> consultationTypes) {
        List<String> validTypes = List.of("In-person", "Online", "Phone", "Home Visit");

        while (consultationTypes == null || consultationTypes.isEmpty() ||
                !validTypes.containsAll(consultationTypes)) {
            System.out.println("Invalid consultation types. Must be one of: " + validTypes);
            String input = InputHandler.getStringInput("Enter consultation types (comma separated): ");
            consultationTypes = Arrays.asList(input.split(","));
        }

        this.consultationTypes = consultationTypes;
    }

    public boolean isOnlineConsultationAvailable() {
        return onlineConsultationAvailable;
    }

    public void setOnlineConsultationAvailable(boolean onlineConsultationAvailable) {
        this.onlineConsultationAvailable = onlineConsultationAvailable;
    }

    public int getConsultationDuration() {
        return consultationDuration;
    }

    public void setConsultationDuration(int consultationDuration) {
        this.consultationDuration = consultationDuration;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(" consultationTypes: " + consultationTypes);
        System.out.println("onlineConsultationAvailable: " + onlineConsultationAvailable);
        System.out.println("consultationDuration: " + consultationDuration);

    }

    public void scheduleConsultation(String type) {
        if (type != null) {
            consultationTypes.add(type);
            System.out.println("Consultation type '" + type + "' scheduled successfully.");
        } else {
            System.out.println("Invalid consultation type.");
        }
    }

    public void provideSecondOpinion(Patient patient) {
        System.out.println("Providing second opinion for patient: " + patient.getPatientId());
    }
}