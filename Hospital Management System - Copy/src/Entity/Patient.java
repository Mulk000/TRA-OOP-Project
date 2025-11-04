package Entity;

import Interface.Displayable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person implements Displayable {
    private String patientId;
    private String bloodGroup;
    private List<String> allergies =new ArrayList<>();
    private String emergencyContact;
    private LocalDate registrationDate;
    private String insuranceId;
    private List<MedicalRecord> medicalRecords=new ArrayList<>();
    private List<Appointment> appointments=new ArrayList<>();

    public Patient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId, List<MedicalRecord> medicalRecords, List<Appointment> appointments) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
        this.emergencyContact = emergencyContact;
        this.registrationDate = registrationDate;
        this.insuranceId = insuranceId;
        this.medicalRecords = medicalRecords;
        this.appointments = appointments;
    }

    public Patient() {
        super();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public void displayInfo() {
        System.out.println("------------------------------------------");
        super.displayInfo();
        System.out.println("patientId: "+patientId);
        System.out.println("bloodGroup: "+bloodGroup);
        System.out.println("allergies: "+String.join(",",allergies));
        System.out.println("emergencyContact: "+emergencyContact);
        System.out.println("registrationDate: "+registrationDate);
        System.out.println("insuranceId: "+insuranceId);
        System.out.println("medicalRecords: "+medicalRecords);
        System.out.println("appointments: "+appointments);
        System.out.println("------------------------------------------");
    }

    @Override
    public void displaySummary() {

    }

    public void addMedicalRecord(MedicalRecord record){
     medicalRecords.add(record);
     System.out.println("Medical record has been added successfully");
    }
    public void addAppointment(Appointment appointment){
        appointments.add(appointment);
        System.out.println("appointment has been added successfully");
    }
    public void updateInsurance(String newInsurance){
       this.insuranceId = newInsurance;
       System.out.println("Insurance updated successfully");
    }
    public void updateContact(String phone) {
        this.setPhoneNumber(phone);
        System.out.println("Phone number updated successfully.");
    }
    public void updateContact(String phone, String email) {
        this.setPhoneNumber(phone);
        this.setEmail(email);
        System.out.println("Phone and email updated successfully.");
    }
    public void updateContact(String phone, String email, String address) {
        this.setPhoneNumber(phone);
        this.setEmail(email);
        this.setAddress(address);
        System.out.println("Phone, email, and address updated successfully.");
    }
}



