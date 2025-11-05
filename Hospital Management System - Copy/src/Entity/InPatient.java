package Entity;

import Interface.Billable;
import Interface.Displayable;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.List;

public class InPatient extends Patient implements Displayable,Billable  {
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String roomNumber;
    private String bedNumber;
    private String admittingDoctorId;
    private Double dailyCharges;

    public InPatient() {

    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        while ((getRegistrationDate() !=null) && (admissionDate.isBefore(getRegistrationDate())||admissionDate.isAfter(LocalDate.now()))) {
            System.out.println("Admission Date is null or before admission date.Please try again");
            admissionDate = InputHandler.getDateInput("Enter Admission Date: ");
        }
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        while (admissionDate!=null && dischargeDate.isBefore(admissionDate)) {
            System.out.println("Invalid Date Please try again");
            dischargeDate = InputHandler.getDateInput("Enter Discharge Date: ");
        }
        this.dischargeDate = dischargeDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getAdmittingDoctorId() {
        return admittingDoctorId;
    }

    public void setAdmittingDoctorId(String admittingDoctorId) {
        this.admittingDoctorId = admittingDoctorId;
    }

    public Double getDailyCharges() {
        return dailyCharges;
    }

    public void setDailyCharges(Double dailyCharges) {
        this.dailyCharges = dailyCharges;
    }

    public InPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId, List<MedicalRecord> medicalRecords, List<Appointment> appointments, LocalDate admissionDate, LocalDate dischargeDate, String roomNumber, String bedNumber, String admittingDoctorId, Double dailyCharges) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, patientId, bloodGroup, allergies, emergencyContact, registrationDate, insuranceId, medicalRecords, appointments);
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.admittingDoctorId = admittingDoctorId;
        this.dailyCharges = dailyCharges;
    }

    public InPatient(LocalDate admissionDate, LocalDate dischargeDate, String roomNumber, String bedNumber, String admittingDoctorId, Double dailyCharges) {
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.admittingDoctorId = admittingDoctorId;
        this.dailyCharges = dailyCharges;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("admissionDate: "+admissionDate);
        System.out.println("dischargeDate: "+dischargeDate);
        System.out.println("roomNumber: "+roomNumber);
        System.out.println("bedNumber: "+bedNumber);
        System.out.println("admittingDoctorId: "+admittingDoctorId);
        System.out.println("dailyCharges: "+dailyCharges);
    }

    @Override
    public void displaySummary() {

    }

    public static void calculateStayDuration(){

    }
    public static void  calculateTotalCharges(){

    }

    @Override
    public double calculateCharges() {
        return 0;
    }

    @Override
    public String generateBill() {
        return "";
    }

    @Override
    public void processPayment(double amount) {

    }
}
