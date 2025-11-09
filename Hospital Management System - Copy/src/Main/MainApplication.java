package Main;

import java.time.LocalDate;
import java.util.Scanner;

import Entity.*;
import Service.*;

public class MainApplication {
    public static Scanner scanner = new Scanner(System.in);
    public static Integer mainMenuOption = 0;
    public static Integer serviceOption = 0;
    public static DoctorService doctorService = new DoctorService();

    public static void main(String[] args) {
        while (mainMenuOption != 8) {
            showMainMenu();
            mainMenuOption = scanner.nextInt();
            switch (mainMenuOption) {
                case 1 -> {
                    PatientMenu();
                }
                case 2 -> {
                    showDoctorManagementMenu();
                }
                case 3 -> {
                    showNurseManagementMenu();
                }
                case 4 -> {
                    showAppointmentManagementMenu();
                }
                case 5 -> {
                    showMedicalRecordsManagementMenu();
                }
                case 6 -> {
                    showDepartmentManagementMenu();
                }
                case 7 -> {
                    showReportsAndStatisticsMenu();
                }
                case 8 -> System.out.println("Exiting program...");
                default -> System.out.println("please enter a number from the menu");
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("Hospital Management App");
        System.out.println("""
                1-Patient Management
                2-Doctor Management
                3-Nurse Management
                4-Appointment Management
                5-Medical Records Management
                6-Department Management
                7-Reports and Statistics
                8- Exit
                """);

    }

    private static void showPatientManagementMenu() {
        System.out.println("Patient Management");
        System.out.println("""
                1-Register New Patient
                2-Register InPatient
                3-Register OutPatient
                4-Register Emergency Patient
                5-View All Patients
                6-Search Patient
                7-Update Patient Information
                8-Remove Patient
                9-View Patient Medical History
                10-Exit
                """);
    }

    public static void PatientMenu() {
        PatientService patientService = new PatientService();
        int option = 0;
        while (option != 10) {
            showPatientManagementMenu();
            System.out.println("Enter the your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> {
                    System.out.println("Registering new patient...");
                   PatientService.save(patientService.add());
                }
                case 2 -> {
                    System.out.println("Registering inpatient...");
                    PatientService.save(patientService.addInPatient());

                }
                case 3 -> {
                    System.out.println("Registering outpatient...");
                    PatientService.save(patientService.addOutPatient());
                }
                case 4 -> {
                    System.out.println("Registering emergency patient...");
                    patientService.save(patientService.addEmergencyPatient());
                }
                case 5 -> {
                    System.out.println("Viewing all patients...");
                    patientService.getAll();
                }
                case 6 -> {
                    System.out.println("Searching patient...");
                    System.out.println("Search by: 1-ID  2-Full Name");
                    String input = scanner.nextLine();
                    int searchChoice;
                    try {
                        searchChoice = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter 1 or 2.");
                        return;
                    }

                    if (searchChoice == 1) {
                        patientService.searchById();
                    } else if (searchChoice == 2) {
                        patientService.searchByName();
                    } else {
                        System.out.println("Invalid option");
                    }
                }
                case 7 -> {
                    System.out.println("Updating patient information...");
                    patientService.updatePatient(patientService.editPatient());
                }
                case 8 -> {
                    System.out.println("Removing patient...");
                    patientService.remove(patientService.getPatientToRemove());
                }
                case 9 -> {
                    System.out.println("Viewing patient medical history...");
                    MedicalRecordService.generatePatientHistoryReport();
                }
                case 10 -> System.out.println("Exiting patient management...");

                default -> System.out.println("please enter a number from the menu");

            }
        }
    }


    private static void showDoctorManagementMenu() {
        DoctorService doctorService = new DoctorService();

        while (true) {
            System.out.println("Doctor Management");
            System.out.println("""
                    1-Add Doctor
                    2-Add Surgeon
                    3-Add Consultant
                    4-Add General Practitioner
                    5-View All Doctors
                    6-Search Doctor by Specialization
                    7-View Available Doctors
                    8-Assign Patient to Doctor
                    9-Update Doctor Information
                    10-Remove Doctor
                    11-Exit
                    """);
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("Adding doctor...");
                    DoctorService.save(doctorService.add());
                }
                case 2 -> {
                    System.out.println("Adding surgeon...");
                        DoctorService.save(doctorService.addSurgeon());

                }
                case 3 -> {
                    System.out.println("Adding consultant...");
                  DoctorService.save(doctorService.addConsultant());
                }
                case 4 -> {
                    System.out.println("Adding general practitioner...");
                    DoctorService.save(doctorService.addGeneralPractitioner());
                }
                case 5 -> {
                    System.out.println("Viewing all doctors...");
                    doctorService.getAll();
                }
                case 6 -> {
                    System.out.println("Searching doctor by specialization...");
                    DoctorService.searchDoctorBySpecialization();
                }
                case 7 -> {
                    System.out.println("Viewing available doctors...");
                    DoctorService.viewAvailableDoctors();
                }
                case 8 -> {
                    System.out.println("Assigning patient to doctor...");
                    DoctorService.assignPatientToDoctor();
                }
                case 9 -> {
                    System.out.println("Updating doctor information...");
                    DoctorService.updateDoctor(DoctorService.editDoctor());
                }
                case 10 -> {
                    System.out.println("Removing doctor...");
                    System.out.println("Removing doctor...");
                    String id = DoctorService.getDoctorToRemove();
                    doctorService.remove(id);

                }
                case 11 -> {
                    System.out.println("Exiting doctor management...");
                    return;
                }
                default -> {
                    System.out.println("please enter a number from the menu");
                }
            }
        }
    }

    private static void showNurseManagementMenu() {
        NurseService nurseService = new NurseService();

        while (true) {
            System.out.println("Nurse Management");
            System.out.println("""
                    1-Add Nurse
                    2-View All Nurses
                    3-View Nurses by Department
                    4-View Nurses by Shift
                    5-Assign Nurse to Patient
                    6-Update Nurse Information
                    7-Remove Nurse
                    8-Exit
                    """);
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("Adding Nurse...");
                    nurseService.save(nurseService.add());
                }
                case 2 -> {
                    System.out.println("View All Nurses...");
                    nurseService.getAll();
                }
                case 3 -> {
                    System.out.println("View Nurses by Department...");
                     NurseService.viewNursesByDepartment();
                }
                case 4 -> {
                    System.out.println("View Nurses by Shift...");
                    NurseService.viewNursesByShift();
                }
                case 5 -> {
                    System.out.println("Assign Nurse to Patient...");
                    nurseService.assignNurseToPatient();
                }
                case 6 -> {
                    System.out.println("Update Nurse Information...");
                    nurseService.updateNurse(NurseService.editNurse());
                }
                case 7 -> {
                    System.out.println("Remove Nurse...");
                    nurseService.removeNurse(NurseService.getNurseToRemove());
                }
                case 8 -> {
                    System.out.println("Exiting nurse management...");
                    return;
                }
                default -> {
                    System.out.println("please enter a number from the menu");
                }
            }
        }
    }

    private static void showAppointmentManagementMenu() {
        AppointmentService appointmentService = new AppointmentService();

        while (true) {

            System.out.println("Appointment Management");
            System.out.println("""
                    1-Schedule New Appointment
                    2-View All Appointments
                    3-View Appointments by Patient
                    4-View Appointments by Doctor
                    5-Reschedule Appointment
                    6-Cancel Appointment
                    7-View Available Doctors
                    8-Complete Appointment
                    9-View Upcoming Appointments
                    10-Exit
                    """);
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("Scheduling new appointment...");
                    AppointmentService.save(appointmentService.add());

                }
                case 2 -> {
                    System.out.println("Viewing all appointments...");
                    appointmentService.getAll();
                }
                case 3 -> {
                    System.out.println("Viewing appointments by patient...");
                    appointmentService.searchByName();
                }
                case 4 -> {
                    System.out.println("Viewing appointments by doctor...");
                    appointmentService.searchById();
                }
                case 5 -> {
                    System.out.println("Rescheduling appointment...");
                    System.out.print("Enter appointment ID to reschedule: ");
                    String appointmentId = scanner.nextLine().trim();

                    System.out.print("Enter new date (yyyy-MM-dd): ");
                    String dateInput = scanner.nextLine().trim();
                    LocalDate newDate = LocalDate.parse(dateInput);

                    appointmentService.rescheduleAppointment(appointmentId, newDate);
                }
                case 6 -> {
                    System.out.println("Canceling appointment...");
                    System.out.print("Enter appointment ID to cancel: ");
                    String appointmentId = scanner.nextLine().trim();
                    appointmentService.cancelAppointment(appointmentId);
                }
                case 7 -> {
                    System.out.println("Viewing available doctors...");
                    DoctorService.viewAvailableDoctors();
                }
                case 8 -> {
                    System.out.println("Completing appointment...");
                   AppointmentService.save(appointmentService.add());
                }
                case 9 -> {
                    System.out.println("Viewing upcoming appointments...");
                        AppointmentService.viewUpcomingAppointments();

                }
                case 10 -> {
                    System.out.println("Exiting appointment management...");
                    return;
                }
                default -> {
                    System.out.println("please enter a number from the menu");
                }
            }
        }
    }

    private static void showMedicalRecordsManagementMenu() {
        MedicalRecordService recordService = new MedicalRecordService();
        while (true) {
            System.out.println("Medical Records Management");
            System.out.println("""
                    1-Create Medical Record
                    2-View All Records
                    3-View Records by Patient
                    4-View Records by Doctor
                    5-Update Medical Record
                    6-Delete Medical Record
                    7-Generate Patient History Report
                    8-Exit
                    """);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("Creating medical record...");
                    MedicalRecord record = recordService.add();
                    MedicalRecordService.save(record);
                }
                case 2 -> {

                    System.out.println("Viewing all records...");
                    recordService.getAll();
                }
                case 3 -> {
                    System.out.println("Viewing records by patient...");
                    recordService.searchByName();
                }
                case 4 -> {
                    System.out.println("Viewing records by doctor...");
                    recordService.searchByDoctorId();
                }
                case 5 -> {
                    System.out.println("Updating medical record...");
                    MedicalRecord updatedRecord = MedicalRecordService.editRecord();
                    MedicalRecordService.updateRecord(updatedRecord);
                }
                case 6 -> {
                    System.out.println("Deleting medical record...");
                    System.out.print("Enter medical record ID to remove: ");
                    String recordId = scanner.nextLine().trim();
                    recordService.remove(recordId);
                }
                case 7 -> {
                    System.out.println("Generating patient history report...");
                    MedicalRecordService.generatePatientHistoryReport();
                }
                case 8 -> {
                    System.out.println("Exiting medical records management...");
                       return;
                }
                default -> System.out.println("please enter a number from the menu");
            }
        }
    }

    private static void showDepartmentManagementMenu() {
        DepartmentService departmentService = new DepartmentService();
        while (true) {
            System.out.println("Department Management ");
            System.out.println("""
                    1-Add Department
                    2-View All Departments
                    3-View Department Details
                    4-Assign Doctor to Department
                    5-Assign Nurse to Department
                    6-Update Department Information
                    7-View Department Statistics
                    8-Exit
                    """);
            System.out.print("Choose an option: ");
            serviceOption = scanner.nextInt();
            scanner.nextLine();
            switch (serviceOption) {
                case 1 -> {
                    System.out.println("Adding department...");
                    Department department = departmentService.add();
                    if (department != null) {
                        DepartmentService.save(department);
                        System.out.println("Department has been added successfully.");
                    }

                }
                case 2 -> {
                    System.out.println("Viewing all departments...");
                    departmentService.getAll();
                }
                case 3 -> {
                    System.out.println("Viewing department details...");
                    departmentService.searchById();
                }
                case 4 -> {
                    System.out.println("Assigning doctor to department...");
                    departmentService.assignDoctor();
                }
                case 5 -> {
                    System.out.println("Assigning nurse to department...");
                    System.out.print("Enter department ID: ");
                    String departmentId = scanner.nextLine();
                    System.out.println("enter nurse ID to assign");
                    String nurseId = scanner.nextLine();
                    Nurse nurse = new Nurse();
                    nurse.setNurseId(nurseId);
                    departmentService.assignNurse(departmentId, nurse);
                }
                case 6 -> {
                    System.out.println("Updating department information...");
                   departmentService.updateDepartmentInfo();
                }
                case 7 -> {
                    System.out.println("Viewing department statistics...");
                    departmentService.viewDepartmentStatistics();

                }
                case 8 -> {
                    System.out.println("Exiting department management...");
                    return;
                }

                default -> {
                    System.out.println("please enter a number from the menu");
                }
            }
        }
    }

    private static void showReportsAndStatisticsMenu() {
        ReportsAndStatisticsService reportsService = new ReportsAndStatisticsService();

        while (true) {
            System.out.println("Reports and Statistics");
            System.out.println("""
                    1-Daily Appointments Report
                    2-Doctor Performance Report
                    3-Department Occupancy Report
                    4-Patient Statistics
                    5-Emergency Cases Report
                    6-Exit
                    """);
            System.out.print("Choose an option: ");
            serviceOption = scanner.nextInt();
            scanner.nextLine();

            switch (serviceOption) {
                case 1 -> {
                    ReportsAndStatisticsService.generateDailyAppointmentsReport();
                }
                case 2 -> {
                    ReportsAndStatisticsService.generateDoctorPerformanceReport();
                }
                case 3 -> {
                    ReportsAndStatisticsService.generateDepartmentOccupancyReport();
                }
                case 4 -> {
                    ReportsAndStatisticsService.generatePatientStatistics();
                }
                case 5 -> {
                    ReportsAndStatisticsService.generateEmergencyCasesReport();
                }
                case 6 -> {
                    System.out.println("Exiting reports and statistics...");
                    return;
                }
                default -> System.out.println("Please enter a valid option (1–6)");
            }

            System.out.println();
        }
    }
}