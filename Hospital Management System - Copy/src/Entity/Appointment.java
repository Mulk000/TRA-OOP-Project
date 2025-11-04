package Entity;

import Interface.Displayable;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointment implements Displayable {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String status;
    private String reason;
    private String notes;

    public Appointment(String appointmentId, String notes, String reason, String status, String appointmentTime, LocalDate appointmentDate, String doctorId, String patientId) {
        this.appointmentId = appointmentId;
        this.notes = notes;
        this.reason = reason;
        this.status = status;
        this.appointmentTime = appointmentTime;
        this.appointmentDate = appointmentDate;
        this.doctorId = doctorId;
        this.patientId = patientId;
    }

    public Appointment() {

    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void displayInfo() {
        System.out.println("appointmentId: " +appointmentId);
        System.out.println("patientId: " +patientId);
        System.out.println("doctorId: " +doctorId);
        System.out.println("appointmentDate: " +appointmentDate);
        System.out.println("appointmentTime: " +appointmentTime);
        System.out.println("status: " +status);
        System.out.println("reason: " +reason);
        System.out.println("notes: " +notes);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", status='" + status + '\'' +
                ", reason='" + reason + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }

    @Override
    public void displaySummary() {
        System.out.println("appointmentId: " +appointmentId);
        System.out.println("patientId: " +patientId);
        System.out.println("doctorId: " +doctorId);
        System.out.println("appointmentDate: " +appointmentDate);
        System.out.println("appointmentTime: " +appointmentTime);
        System.out.println("status: " +status);
    }


    public void reschedule() {
    }

    public void cancel() {

    }

    public void complete() {
    }
    public void addNotes(String notes) {
        this.notes = (this.notes == null ? "" : this.notes + "\n") + notes;
        System.out.println("Notes added: " + notes);
    }
    public void addNotes(String notes, String addedBy) {
        String newNote = notes + " (Added by: " + addedBy + ")";
        this.notes = (this.notes == null ? "" : this.notes + "\n") + newNote;
        System.out.println("Notes added by " + addedBy + ": " + notes);
    }

    public void addNotes(String notes, String addedBy, LocalDateTime timestamp) {
        String newNote = notes + " (Added by: " + addedBy + " at " + timestamp + ")";
        this.notes = (this.notes == null ? "" : this.notes + "\n") + newNote;
        System.out.println("Notes added by " + addedBy + " at " + timestamp + ": " + notes);
    }
}

