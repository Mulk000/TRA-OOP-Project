package Service;

import Entity.Appointment;
import Entity.Patient;
import Interface.Appointable;
import Interface.Manageable;
import Interface.Searchable;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService implements Manageable<Appointment>, Searchable, Appointable {

    public static List<Appointment> appointmentList = new ArrayList<>();

    @Override
    public Appointment add() {
        Appointment appointment = new Appointment();
        String appointmentId = HelperUtils.generateId("AP");
        System.out.println("Generated appointment ID: " + appointmentId);
        appointment.setAppointmentId(appointmentId);

        String patientId;
        while (true) {
            patientId = InputHandler.getStringInput("Enter patient ID: ");
            if (PatientService.checkId(patientId)) {
                break;
            } else {
                System.out.println("Patient ID not found. Please enter a valid patient ID.");
            }
        }
        appointment.setPatientId(patientId);
        String doctorId;
        while (true) {
            doctorId = InputHandler.getStringInput("Enter doctor ID: ");
            if (DoctorService.checkId(doctorId)) {
                break;
            } else {
                System.out.println("Doctor ID not found. Please enter a valid doctor ID.");
            }
        }
        appointment.setDoctorId(doctorId);

        appointment.setAppointmentDate(InputHandler.getDateInput("Enter appointment date (yyyy-MM-dd): "));
        appointment.setAppointmentTime(InputHandler.getStringInput("Enter appointment time (e.g., 10:30 AM): "));
        appointment.setReason(InputHandler.getStringInput("Enter reason for appointment: "));
        appointment.setNotes(InputHandler.getStringInput("Enter additional notes: "));
        appointment.setStatus("Scheduled");

        return appointment;
    }

    public static void save(Appointment appointment) {
        appointmentList.add(appointment);
        System.out.println("Appointment has been added successfully.");

        for (Patient patient : PatientService.patientList) {
            if (patient.getPatientId().equalsIgnoreCase(appointment.getPatientId())) {
                if (patient.getAppointments() == null) {
                    patient.setAppointments(new ArrayList<>());
                }
                patient.getAppointments().add(appointment);
                break;
            }
        }
    }
    @Override
    public void remove(String id) {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments available.");
            return;
        }

        boolean removed = appointmentList.removeIf(a -> a.getAppointmentId().equals(id));

        if (removed) {
            System.out.println("Appointment removed successfully.");
        } else {
            System.out.println("Appointment not found.");
        }
    }

    @Override
    public List<Appointment> getAll() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments found.");
        }
        for (Appointment a : appointmentList) {
            System.out.println("----------------------------");
            a.displayInfo();
        }
        return appointmentList;
    }

    @Override
    public void searchByName() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments available.");
            return;
        }

        String patientId = InputHandler.getStringInput("Enter patient ID to search appointments: ");
        boolean found = false;

        for (Appointment a : appointmentList) {
            if (a.getPatientId().equalsIgnoreCase(patientId)) {
                System.out.println("Appointment found:");
                a.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointments found for this patient.");
        }
    }

    @Override
    public void searchById() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments available.");
            return;
        }

        String doctorId = InputHandler.getStringInput("Enter Doctor ID to search: ");
        boolean found = false;

        for (Appointment a : appointmentList) {
            if (a.getDoctorId().equalsIgnoreCase(doctorId)) {
                if (!found) {
                    System.out.println("Appointments for Doctor " + doctorId + ":");
                }
                a.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointments found for Doctor ID: " + doctorId);
        }
    }

    @Override
    public void scheduleAppointment(Appointment appointment) {
        appointmentList.add(appointment);
        System.out.println("Appointment scheduled successfully.");
    }

    @Override
    public void cancelAppointment(String appointmentId) {
        for (Appointment a : appointmentList) {
            if (a.getAppointmentId().equals(appointmentId)) {
                a.setStatus("Cancelled");
                System.out.println("Appointment cancelled successfully.");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }

    @Override
    public void rescheduleAppointment(String appointmentId, LocalDate newDate) {
        for (Appointment a : appointmentList) {
            if (a.getAppointmentId().equals(appointmentId)) {
                a.setAppointmentDate(newDate);
                a.setStatus("Rescheduled");
                System.out.println("Appointment rescheduled successfully.");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }
    public static Appointment createAppointment(String patientId, String doctorId, LocalDate date) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(HelperUtils.generateId("AP"));
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDate(date);
        appointment.setStatus("Scheduled");
        appointmentList.add(appointment);

        System.out.println("Appointment created successfully (Basic).");
        return appointment;
    }
    public static Appointment createAppointment(String patientId, String doctorId, LocalDate date, String time) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(HelperUtils.generateId("AP"));
        appointment.setPatientId(patientId);
        appointment.setDoctorId(doctorId);
        appointment.setAppointmentDate(date);
        appointment.setAppointmentTime(time);
        appointment.setStatus("Scheduled");
        appointmentList.add(appointment);

        System.out.println("Appointment created successfully with time.");
        return appointment;
    }
    public static void createAppointment(Appointment appointment) {
        if (appointment == null) {
            System.out.println("Invalid appointment data.");
            return;
        }
        appointmentList.add(appointment);
        System.out.println("Appointment created successfully.");
    }
    public static void rescheduleAppointment(String appointmentId, LocalDate newDate, String newTime) {
        for (Appointment a : appointmentList) {
            if (a.getAppointmentId().equalsIgnoreCase(appointmentId)) {
                a.setAppointmentDate(newDate);
                a.setAppointmentTime(newTime);
                a.setStatus("Rescheduled");
                System.out.println("Appointment rescheduled successfully with new date and time.");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }
    public static void rescheduleAppointment(Appointment appointment, LocalDate newDate, String newTime, String reason) {
        if (appointment == null) {
            System.out.println("Invalid appointment.");
            return;
        }

        appointment.setAppointmentDate(newDate);
        appointment.setAppointmentTime(newTime);
        appointment.setReason(reason);
        appointment.setStatus("Rescheduled");

        System.out.println("Appointment rescheduled successfully (with reason).");
    }
    public static void displayAppointments(LocalDate date) {
        boolean found = false;
        for (Appointment a : appointmentList) {
            if (a.getAppointmentDate().isEqual(date)) {
                if (!found) {
                    System.out.println("Appointments on " + date + ":");
                }
                a.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointments found on " + date + ".");
        }
    }
    public static void displayAppointments(String doctorId, LocalDate startDate, LocalDate endDate) {
        boolean found = false;
        for (Appointment a : appointmentList) {
            if (a.getDoctorId().equalsIgnoreCase(doctorId)
                    && (a.getAppointmentDate().isEqual(startDate) || a.getAppointmentDate().isAfter(startDate))
                    && (a.getAppointmentDate().isEqual(endDate) || a.getAppointmentDate().isBefore(endDate))) {

                if (!found) {
                    System.out.println("Appointments for Doctor " + doctorId + " from " + startDate + " to " + endDate + ":");
                }
                a.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointments found for Doctor " + doctorId + " in this date range.");
        }
    }

    public static boolean checkId(String idCheck) {
        for (Appointment a : appointmentList) {
            if (a.getAppointmentId().equals(idCheck)) {
                return true;
            }
        }
        return false;
    }

    public static void viewUpcomingAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments available.");
            return;
        }
        LocalDate today = LocalDate.now();
        boolean found = false;
        for (Appointment a : appointmentList) {
            if (a.getAppointmentDate().isAfter(today) || a.getAppointmentDate().isEqual(today)) {
                if (!found) {
                    System.out.println("Upcoming appointments:");
                }
                a.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No upcoming appointments.");
        }
    }

    public static void completeAppointment(String appointmentId) {
        for (Appointment a : appointmentList) {
            if (a.getAppointmentId().equalsIgnoreCase(appointmentId)) {
                a.setStatus("Completed");
                System.out.println("Appointment marked as completed.");
                return;
            }
        }
        System.out.println("Appointment not found.");
    }
    public static void SampleDateAppointment() {
        for (int i = 1; i <= 15; i++) {
            Appointment appointment = new Appointment();
            appointment.setAppointmentId("AP-" + i);
            Patient patient = PatientService.patientList.get(i % PatientService.patientList.size());
            appointment.setPatientId(patient.getPatientId());
            appointment.setDoctorId(DoctorService.doctorList.get(i % DoctorService.doctorList.size()).getDoctorId());
            appointment.setPatientId("PT-" + ((i % 10) + 1));
            appointment.setDoctorId("DOC-" + ((i % 5) + 1));
            appointment.setAppointmentDate(LocalDate.now().plusDays(i));
            appointment.setAppointmentTime((9 + (i % 8)) + ":00 AM");
            appointment.setReason("Checkup " + i);
            appointment.setNotes("Follow-up required " + i);
            appointment.setStatus("Scheduled");
            appointmentList.add(appointment);
            if (patient.getAppointments() == null) {
                patient.setAppointments(new ArrayList<>());
            }
            patient.getAppointments().add(appointment);
        }
        System.out.println("15 sample appointments added successfully.");
    }


    }
