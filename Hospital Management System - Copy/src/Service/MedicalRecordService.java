package Service;

import Entity.MedicalRecord;
import Entity.Patient;
import Interface.Manageable;
import Interface.Searchable;
import Utils.InputHandler;
import Utils.HelperUtils;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordService implements Manageable<MedicalRecord>, Searchable {

    public static List<MedicalRecord> recordList = new ArrayList<>();

    @Override
    public MedicalRecord add() {
        MedicalRecord record = new MedicalRecord();
        String recordId = HelperUtils.generateId("MR");
        System.out.println("Generated medical record ID: " + recordId);
        record.setRecordId(recordId);

        String patientId;
        while (true) {
            patientId = InputHandler.getStringInput("Enter patient ID: ");
            if (PatientService.checkId(patientId)) {
                break;
            } else {
                System.out.println("Patient ID not found. Please enter a valid patient ID.");
            }
        }
        record.setPatientId(patientId);

        String doctorId;
        while (true) {
            doctorId = InputHandler.getStringInput("Enter doctor ID: ");
            if (DoctorService.checkId(doctorId)) {
                break;
            } else {
                System.out.println("Doctor ID not found. Please enter a valid doctor ID.");
            }
        }
        record.setDoctorId(doctorId);
        record.setVisitDate(InputHandler.getDateInput("Enter visit date (yyyy-MM-dd): "));
        record.setDiagnosis(InputHandler.getStringInput("Enter diagnosis: "));
        record.setPrescription(InputHandler.getStringInput("Enter prescription: "));
        record.setTestResults(InputHandler.getStringInput("Enter test results: "));
        record.setNotes(InputHandler.getStringInput("Enter additional notes: "));

        return record;
    }

    public static void save(MedicalRecord record) {
        recordList.add(record);
        System.out.println("Medical record has been added successfully.");
        for (Patient patient : PatientService.patientList) {
            if (patient.getPatientId().equals(record.getPatientId())) {
                patient.getMedicalRecords().add(record);
                break;
            }
        }
    }


    public static MedicalRecord editRecord() {
        if (recordList.isEmpty()) {
            System.out.println("No medical records to edit.");
            return null;
        }

        String id = InputHandler.getStringInput("Enter medical record ID to edit: ");
        while (!checkId(id)) {
            id = InputHandler.getStringInput("Please enter a valid medical record ID: ");
        }

        MedicalRecord selectedRecord = null;
        for (MedicalRecord record : recordList) {
            if (record.getRecordId().equals(id)) {
                selectedRecord = record;
                break;
            }
        }

        if (selectedRecord == null) {
            System.out.println("Medical record not found.");
            return null;
        }

        System.out.println("Select field to edit:");
        System.out.println("""
                1 - Patient ID
                2 - Doctor ID
                3 - Visit Date
                4 - Diagnosis
                5 - Prescription
                6 - Test Results
                7 - Notes
                8 - Exit
                """);
        int choice = InputHandler.getIntInput("Enter your choice: ");

        switch (choice) {
            case 1 -> selectedRecord.setPatientId(InputHandler.getStringInput("Enter new patient ID: "));
            case 2 -> selectedRecord.setDoctorId(InputHandler.getStringInput("Enter new doctor ID: "));
            case 3 -> selectedRecord.setVisitDate(InputHandler.getDateInput("Enter new visit date (yyyy-MM-dd): "));
            case 4 -> selectedRecord.setDiagnosis(InputHandler.getStringInput("Enter new diagnosis: "));
            case 5 -> selectedRecord.setPrescription(InputHandler.getStringInput("Enter new prescription: "));
            case 6 -> selectedRecord.setTestResults(InputHandler.getStringInput("Enter new test results: "));
            case 7 -> selectedRecord.setNotes(InputHandler.getStringInput("Enter new notes: "));
            case 8 -> {
                System.out.println("Exiting edit menu.");
                return selectedRecord;
            }
            default -> System.out.println("Invalid choice");
        }

        return selectedRecord;
    }

    public static void updateRecord(MedicalRecord updatedRecord) {
        if (updatedRecord == null) {
            System.out.println("No updates to save.");
            return;
        }
        for (int i = 0; i < recordList.size(); i++) {
            if (recordList.get(i).getRecordId().equals(updatedRecord.getRecordId())) {
                recordList.set(i, updatedRecord);
                System.out.println("Medical record updated successfully.");
                return;
            }
        }
        System.out.println("Updated medical record not found in list.");
    }

    @Override
    public void remove(String id) {
        if (recordList.isEmpty()) {
            System.out.println("No medical records available.");
            return;
        }

        boolean removed = recordList.removeIf(record -> record.getRecordId().equals(id));

        if (removed) {
            System.out.println("Medical record removed successfully.");
        } else {
            System.out.println("Medical record not found.");
        }
    }

    public static String getRecordToRemove() {
        if (recordList.isEmpty()) {
            System.out.println("No medical records available to remove.");
            return null;
        }
        String id = InputHandler.getStringInput("Enter medical record ID to remove: ");
        while (id == null || !checkId(id)) {
            id = InputHandler.getStringInput("Invalid ID, please enter another ID: ");
        }
        return id;
    }

    @Override
    public List<MedicalRecord> getAll() {
        if (recordList.isEmpty()) {
            System.out.println("No medical records found.");
        }
        for (MedicalRecord record : recordList) {
            System.out.println("----------------------------");
            record.displayInfo();
        }
        return recordList;
    }

    @Override
    public void searchByName() {
        if (recordList.isEmpty()) {
            System.out.println("No medical records available.");
            return;
        }
        String patientId = InputHandler.getStringInput("Enter patient ID to search: ");
        for (MedicalRecord record : recordList) {
            if (record.getPatientId().equalsIgnoreCase(patientId)) {
                System.out.println("Medical record found:");
                record.displayInfo();
                return;
            }
        }
            System.out.println("No medical record found for this patient.");

    }

    @Override
    public void searchById() {
        if (recordList.isEmpty()) {
            System.out.println("No medical records available.");
            return;
        }

        String doctorId = InputHandler.getStringInput("Enter doctor ID to search: ");

        for (MedicalRecord record : recordList) {
            if (record.getDoctorId().equalsIgnoreCase(doctorId)) {
                System.out.println("Medical record found:");
                record.displayInfo();
                return;
            }
        }

            System.out.println("No medical record found for this doctor.");

    }
    public static Boolean checkId(String idCheck) {
        for (MedicalRecord record : recordList) {
            if (record.getRecordId().equals(idCheck)) {
                return true;
            }
        }
        return false;
    }


    public static void generatePatientHistoryReport() {
        if (recordList.isEmpty()) {
            System.out.println("No medical records available.");
            return;
        }

        String patientId = InputHandler.getStringInput("Enter patient ID to generate history: ");

        System.out.println("========================================");
        System.out.println("      Patient Medical History Report     ");
        System.out.println("========================================");

        for (MedicalRecord record : recordList) {
            if (record.getPatientId().equalsIgnoreCase(patientId)) {
                record.displayInfo();
                System.out.println("----------------------------------------");
                return;
            }
        }
            System.out.println("No medical history found for this patient.");
    }
    public static void SampleDataMedicalRecord() {
        for (int i = 1; i <= 12; i++) {
            MedicalRecord record = new MedicalRecord();
            record.setRecordId(HelperUtils.generateId("MR"));
            record.setPatientId(PatientService.patientList.get(i % PatientService.patientList.size()).getPatientId());
            record.setDoctorId(DoctorService.doctorList.get(i % DoctorService.doctorList.size()).getDoctorId());

            record.setVisitDate(java.time.LocalDate.now().minusDays(i));
            record.setDiagnosis("Diagnosis " + i);
            record.setPrescription("Prescription " + i);
            record.setTestResults("Test results " + i);
            record.setNotes("Notes for visit " + i);

            recordList.add(record);
            Patient patient = PatientService.patientList.get(i % PatientService.patientList.size());
            if (patient.getMedicalRecords() == null) {
                patient.setMedicalRecords(new ArrayList<>());
            }
            patient.getMedicalRecords().add(record);

        }
        System.out.println("12 sample medical records added successfully.");
    }
}
