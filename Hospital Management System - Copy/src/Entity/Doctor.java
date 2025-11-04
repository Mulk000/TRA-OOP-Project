package Entity;

import Interface.Displayable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person implements Displayable {
  private String doctorId;
  private String specialization;
  private String qualification;
  private  int experienceYears;
  private String departmentId;
  private Double consultationFee;
  private List<String> availableSlots=new ArrayList<>();
  private List<String>  assignedPatients=new ArrayList<>();

    public Doctor(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification, int experienceYears, String departmentId, Double consultationFee, List<String> availableSlots, List<String> assignedPatients) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.doctorId = doctorId;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.departmentId = departmentId;
        this.consultationFee = consultationFee;
        this.availableSlots = availableSlots;
        this.assignedPatients = assignedPatients;
    }

    public Doctor() {

    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(Double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<String> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public List<String> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<String> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("doctorId: "+doctorId);
        System.out.println("specialization: "+specialization);
        System.out.println("qualification: "+qualification);
        System.out.println("experienceYears: "+experienceYears);
        System.out.println("departmentId: "+departmentId);
        System.out.println("consultationFee: "+consultationFee);
        System.out.println("availableSlots: "+String.join(",",availableSlots));
        System.out.println("assignedPatients: "+String.join(",",assignedPatients));

    }

    @Override
    public void displaySummary() {

    }

    public static void assignPatient(List<Patient>patientList,Patient newPatient ){
      patientList.add(newPatient);
      System.out.println("patient has been assigned successfully");
}
    public static void removePatient(List<Patient>patientList, String PatientId) {

    }
    public static void  updateAvailability() {

    }
    public void updateFee(double fee) {
        this.consultationFee = fee;
        System.out.println("Consultation fee updated to: " + fee);
    }
    public void updateFee(double fee, String reason) {
        this.consultationFee = fee;
        System.out.println("Consultation fee updated to: " + fee + ". Reason: " + reason);
    }
    public void addAvailability(String slot) {
        availableSlots.add(slot);
        System.out.println("Added availability slot: " + slot);
    }
    public void addAvailability(List<String> slots) {
        availableSlots.addAll(slots);
        System.out.println("Added multiple availability slots: " + String.join(",", slots));
    }
}
