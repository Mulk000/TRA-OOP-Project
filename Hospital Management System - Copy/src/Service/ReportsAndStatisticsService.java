package Service;

import Entity.Appointment;
import Entity.Doctor;
import Entity.Department;
import Entity.Patient;
import java.util.List;

public class ReportsAndStatisticsService {

    public static void generateDailyAppointmentsReport() {
        System.out.println("----- Daily Appointments Report -----");
        AppointmentService appointmentService = new AppointmentService();
        List<Appointment> appointments = appointmentService.getAll();

        System.out.println("Total Appointments: " + appointments.size());
        for (Appointment appointment : appointments) {
            System.out.println("Appointment ID: " + appointment.getAppointmentId()
                    + " | Doctor ID: " + appointment.getDoctorId()
                    + " | Patient ID: " + appointment.getPatientId()
                    + " | Status: " + appointment.getStatus());
        }
    }

    public static void generateDoctorPerformanceReport() {
        System.out.println("----- Doctor Performance Report -----");
        DoctorService doctorService = new DoctorService();
        List<Doctor> doctors = doctorService.getAll();

        System.out.println("Total Doctors: " + doctors.size());
        for (Doctor doctor : doctors) {
            System.out.println("Doctor ID: " + doctor.getDoctorId()
                    + " | Name: " + doctor.getFirstName() + " " + doctor.getLastName()
                    + " | Specialization: " + doctor.getSpecialization());
        }
    }

    public static void generateDepartmentOccupancyReport() {
        System.out.println("----- Department Occupancy Report -----");
        DepartmentService departmentService = new DepartmentService();
        List<Department> departments = departmentService.getAll();

        System.out.println("Total Departments: " + departments.size());
        for (Department department : departments) {
            System.out.println("Department ID: " + department.getDepartmentId()
                    + " | Name: " + department.getDepartmentName());
        }
    }

    public static void generatePatientStatistics() {
        System.out.println("----- Patient Statistics -----");
        PatientService patientService = new PatientService();
        List<Patient> patients = patientService.getAll();

        System.out.println("Total Patients: " + patients.size());
        for (Patient patient : patients) {
            System.out.println("Patient ID: " + patient.getPatientId()
                    + " | Name: " + patient.getFirstName() + " " + patient.getLastName()
                    + " | Gender: " + patient.getGender());
        }
    }

    public static void generateEmergencyCasesReport() {
        System.out.println("----- Emergency Cases Report -----");
        PatientService patientService = new PatientService();
        List<Patient> patients = patientService.getAll();

        System.out.println("Total Emergency Cases: ");
        for (Patient patient : patients) {
            if (Boolean.parseBoolean(patient.getEmergencyContact())) {
                System.out.println("Emergency Patient ID: " + patient.getPatientId()
                        + " | Name: " + patient.getFirstName() + " " + patient.getLastName());
            }
        }
    }
}




