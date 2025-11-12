package Service;

import Entity.*;
import Interface.Manageable;
import Interface.Searchable;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PatientService implements Manageable, Searchable {
    public static List<Patient> patientList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);


    @Override
    public Patient add() {
        Patient patient = new Patient();

        String id = Utils.HelperUtils.generateId("PER");
        System.out.println("Generated person id: " + id);
        patient.setId(id);

        String patientId = Utils.HelperUtils.generateId("PT");
        System.out.println("Generated patient id: " + patientId);
        patient.setPatientId(patientId);

        patient.setFirstName(InputHandler.getStringInput("Enter doctor's first name: "));
        patient.setLastName(InputHandler.getStringInput("Enter doctor's last name: "));
        patient.setDateOfBirth(InputHandler.getDateInput("Enter doctor's date of birth (yyyy-MM-dd): "));
        patient.setGender(InputHandler.getStringInput("Enter Patient gender(Male,Female): "));
        patient.setPhoneNumber(InputHandler.getStringInput("Enter Patient phone number: "));
        patient.setEmail(InputHandler.getStringInput("Enter Patient email: "));
        patient.setAddress(InputHandler.getStringInput("Enter Patient address: "));
        patient.setBloodGroup(InputHandler.getStringInput("Enter Patient blood group(A+,A-,B+,B-,O+,O-,AB): "));
        List<String> allergies = new ArrayList<>();
        System.out.println("Enter The Allergies(type 'q' to finish):");
        while (true) {
            String allergy = InputHandler.getStringInput("- ");
            if (allergy.equalsIgnoreCase("q")) {
                break;
            }
            allergies.add(allergy);
        }
        patient.setAllergies(allergies);
        String emergencyContact = InputHandler.getStringInput("Enter patient emergencyContact: ");
        patient.setEmergencyContact(emergencyContact);
        LocalDate registrationDate = InputHandler.getDateInput("Enter patient registrationDate (yyyy-MM-dd): ");
        patient.setRegistrationDate(registrationDate);
        String insuranceId = InputHandler.getStringInput("Enter patient insurance ID: ");
        patient.setInsuranceId(insuranceId);

        return patient;
    }

    public InPatient addInPatient() {
        InPatient inPatient = new InPatient();

        String id = Utils.HelperUtils.generateId("PER");
        System.out.println("Generated person id: " + id);
        inPatient.setId(id);

        String patientId = Utils.HelperUtils.generateId("INP");
        System.out.println("Generated inpatient id: " + patientId);
        inPatient.setPatientId(patientId);

        inPatient.setFirstName(InputHandler.getStringInput("Enter patient first name: "));
        inPatient.setLastName(InputHandler.getStringInput("Enter patient last name: "));
        inPatient.setDateOfBirth(InputHandler.getDateInput("Enter patient date of birth (yyyy-MM-dd): "));
        inPatient.setGender(InputHandler.getStringInput("Enter patient gender(Male,Female): "));
        inPatient.setPhoneNumber(InputHandler.getStringInput("Enter patient phone number: "));
        inPatient.setEmail(InputHandler.getStringInput("Enter patient email: "));
        inPatient.setAddress(InputHandler.getStringInput("Enter patient address: "));
        inPatient.setBloodGroup(InputHandler.getStringInput("Enter patient blood group(A+,A-,B+,B-,O+,O-,AB): "));

        System.out.println("Enter patient allergies (type 'q' to finish):");
        List<String> allergies = new ArrayList<>();
        while (true) {
            String allergy = InputHandler.getStringInput("");
            if (allergy.equalsIgnoreCase("q")) break;
            allergies.add(allergy);
        }
        inPatient.setAllergies(allergies);

        inPatient.setEmergencyContact(InputHandler.getStringInput("Enter patient emergency contact: "));
        inPatient.setRegistrationDate(InputHandler.getDateInput("Enter patient registration date (yyyy-MM-dd): "));
        inPatient.setInsuranceId(InputHandler.getStringInput("Enter patient insurance ID: "));
        inPatient.setAdmissionDate(InputHandler.getDateInput("Enter admission date (yyyy-MM-dd): "));
        inPatient.setDischargeDate(InputHandler.getDateInput("Enter discharge date (yyyy-MM-dd): "));
        inPatient.setRoomNumber(InputHandler.getStringInput("Enter room number: "));
        inPatient.setBedNumber(InputHandler.getStringInput("Enter bed number: "));
        String AdmittingDoctorId;
        while (true) {
            AdmittingDoctorId = (InputHandler.getStringInput("Enter the Admitting Doctor Id: "));
            if (DoctorService.checkId(AdmittingDoctorId)) {
                inPatient.setAdmittingDoctorId(AdmittingDoctorId);
                break;
            } else {
                System.out.println("Doctor not found. Please enter a valid Doctor ID.");
            }
        }

        inPatient.setDailyCharges(Double.parseDouble(InputHandler.getStringInput("Enter daily charges: ")));

        return inPatient;
    }

    public OutPatient addOutPatient() {
        OutPatient patient = new OutPatient();

        String id = Utils.HelperUtils.generateId("PER");
        System.out.println("Generated person id: " + id);
        patient.setId(id);

        String patientId = Utils.HelperUtils.generateId("OUT");
        System.out.println("Generated outpatient id: " + patientId);
        patient.setPatientId(patientId);

        patient.setFirstName(InputHandler.getStringInput("Enter patient first name: "));
        patient.setLastName(InputHandler.getStringInput("Enter patient last name: "));
        patient.setDateOfBirth(InputHandler.getDateInput("Enter patient date of birth (yyyy-MM-dd): "));
        patient.setGender(InputHandler.getStringInput("Enter patient gender(Male,Female): "));
        patient.setPhoneNumber(InputHandler.getStringInput("Enter patient phone number: "));
        patient.setEmail(InputHandler.getStringInput("Enter patient email: "));
        patient.setAddress(InputHandler.getStringInput("Enter patient address: "));
        patient.setBloodGroup(InputHandler.getStringInput("Enter patient bloodGroup(A+,A-,B+,B-,O+,O-,AB): "));

        System.out.println("Enter patient allergies (type 'q' to finish):");
        List<String> allergies = new ArrayList<>();
        while (true) {
            String allergy = InputHandler.getStringInput("");
            if (allergy.equalsIgnoreCase("q")) break;
            allergies.add(allergy);
        }
        patient.setAllergies(allergies);

        patient.setEmergencyContact(InputHandler.getStringInput("Enter patient emergencyContact: "));
        patient.setRegistrationDate(InputHandler.getDateInput("Enter patient registrationDate (yyyy-MM-dd): "));
        patient.setInsuranceId(InputHandler.getStringInput("Enter patient insurance ID: "));
        patient.setVisitCount(InputHandler.getIntInput("Enter visit count: "));
        patient.setLastVisitDate(InputHandler.getDateInput("Enter last visit date (yyyy-MM-dd): "));
        String PreferredDoctorId;
        while (true) {
            PreferredDoctorId = (InputHandler.getStringInput("Enter the Preferred Doctor Id: "));
            if (DoctorService.checkId(PreferredDoctorId)) {
                patient.setPreferredDoctorId(PreferredDoctorId);
                break;
            } else {
                System.out.println("Doctor not found. Please enter a valid Doctor ID.");
            }
        }

        return patient;
    }


    public EmergencyPatient addEmergencyPatient() {
        EmergencyPatient patient = new EmergencyPatient();

        String id = Utils.HelperUtils.generateId("PER");
        System.out.println("Generated person id: " + id);
        patient.setId(id);

        String patientId = Utils.HelperUtils.generateId("EMP");
        System.out.println("Generated emergency patient id: " + patientId);
        patient.setPatientId(patientId);

        patient.setFirstName(InputHandler.getStringInput("Enter patient first name: "));
        patient.setLastName(InputHandler.getStringInput("Enter patient last name: "));
        patient.setDateOfBirth(InputHandler.getDateInput("Enter patient date of birth (yyyy-MM-dd): "));
        patient.setGender(InputHandler.getStringInput("Enter patient gender(Male,Female): "));
        patient.setPhoneNumber(InputHandler.getStringInput("Enter patient phone number: "));
        patient.setEmail(InputHandler.getStringInput("Enter patient email: "));
        patient.setAddress(InputHandler.getStringInput("Enter patient address: "));
        patient.setBloodGroup(InputHandler.getStringInput("Enter patient blood group: "));

        System.out.println("Enter patient allergies (type 'q' to finish):");
        List<String> allergies = new ArrayList<>();
        while (true) {
            String allergy = InputHandler.getStringInput("");
            if (allergy.equalsIgnoreCase("q")) break;
            allergies.add(allergy);
        }
        patient.setAllergies(allergies);

        patient.setEmergencyContact(InputHandler.getStringInput("Enter patient emergency contact: "));
        patient.setRegistrationDate(InputHandler.getDateInput("Enter patient registration date (yyyy-MM-dd): "));
        patient.setInsuranceId(InputHandler.getStringInput("Enter patient insurance ID: "));

        patient.setAdmissionDate(InputHandler.getDateInput("Enter the Admission Date: "));
        patient.setDischargeDate(InputHandler.getDateInput("Enter the Discharge Date: "));
        patient.setRoomNumber(InputHandler.getStringInput("Enter the Room Number: "));
        patient.setBedNumber(InputHandler.getStringInput("Enter the Bed Number: "));
        String AdmittingDoctorId;
        while (true) {
            AdmittingDoctorId = (InputHandler.getStringInput("Enter the Admitting Doctor Id: "));
            if (DoctorService.checkId(AdmittingDoctorId)) {
                patient.setAdmittingDoctorId(AdmittingDoctorId);
                break;
            } else {
                System.out.println("Doctor not found. Please enter a valid Doctor ID.");
            }
        }
        patient.setDailyCharges(InputHandler.getDoubleInput("Enter the Daily Charges: "));

        patient.setEmergencyType(InputHandler.getStringInput("Enter emergency type: "));
        patient.setArrivalMode(InputHandler.getStringInput("Enter arrival mode (e.g., ambulance, walk-in): "));
        patient.setTriageLevel(Integer.parseInt(InputHandler.getStringInput("Enter triage level (integer): ")));
        patient.setAdmittedViaER(Boolean.parseBoolean(InputHandler.getStringInput("Was the patient admitted via ER? (true/false): ")));

        return patient;
    }

    public static void save(Patient patient) {
        patientList.add(patient);
        System.out.println("patient has been added successfully");
    }

    public static Patient editPatient() {
        if (patientList.isEmpty()) {
            System.out.println("no patient to edit");
            return null;
        }
        System.out.println("Enter patient Id");
        String id = scanner.nextLine();
        while (!checkId(id)) {
            System.out.println("Please enter valid id");
            id = scanner.nextLine();
        }

        Patient selectedPatient = null;
        for (Patient patient : patientList) {
            if (patient.getPatientId().equals(id)) {
                selectedPatient = patient;
                break;
            }
        }
        System.out.println("Enter your object");
        System.out.println("""
                1-bloodGroup
                2-allergies
                3-emergencyContact
                4-registrationDate
                5-insuranceId
                6-medicalRecords
                7-appointments
                8-Exit
                """);
        System.out.println("Enter your choice");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1 -> {
                System.out.println("patient info to be edited is :" + selectedPatient.getFirstName());
                System.out.println("enter new bloodGroup");
                String newBloodGroup = scanner.nextLine();
                selectedPatient.setBloodGroup(newBloodGroup);
            }
            case 2 -> {
                System.out.println("enter new allergies");
                List<String> allergies = new ArrayList<>();
                System.out.println("Enter new allergies (type 'q' to finish):");
                while (true) {
                    String allergy = scanner.nextLine();
                    if (allergy.equalsIgnoreCase("q")) {
                        break;
                    }
                    allergies.add(allergy);
                }
                selectedPatient.setAllergies(allergies);
            }
            case 3 -> {
                System.out.println("enter new emergencyContact ");
                String newEmergencyContact = scanner.nextLine();
                selectedPatient.setEmergencyContact(newEmergencyContact);
            }
            case 4 -> {
                System.out.println("enter new registrationDate ");
                LocalDate newRegistrationDate = LocalDate.parse(scanner.next());
                selectedPatient.setRegistrationDate(newRegistrationDate);
            }
            case 5 -> {
                System.out.println("enter new insuranceId ");
                String newInsuranceId = scanner.nextLine();
                selectedPatient.setInsuranceId(newInsuranceId);
            }
            case 6 -> {
                System.out.println("Exit edit menu");
                return selectedPatient;
            }
            default -> System.out.println("invalid number enter another one");
        }
        return selectedPatient;
    }

//    public static void updatePatient(Patient updatedPatient) {
//        if (updatedPatient == null) {
//            System.out.println("no updates to save");
//            return;
//        }
//        for (int i = 0; i < patientList.size(); i++) {
//            if (patientList.get(i).getPatientId().equals(updatedPatient.getPatientId())) {
//                patientList.set(i, updatedPatient);
//                System.out.println("patient updated successfully.");
//                return;
//            }
//        }
//        System.out.println("Updated patient not found in list");
//    }

    public static String getPatientToRemove() {
        if (patientList.isEmpty()) {
            System.out.println("No patient available to remove.");
            return null;
        }
        System.out.println("Choose an ID of a patient to Remove: ");
        String id = scanner.nextLine();
        while (id == null || !checkId(id)) {
            System.out.println("Invalid ID, Please Enter Another ID");
            id = scanner.nextLine();
        }
        return id;
    }


    public void remove(String removePatient) {
        if (removePatient == null) {
            System.out.println("Invalid input No patient removed.");
            return;
        }
        if (checkId(removePatient)) {
            patientList.removeIf(patient -> patient.getPatientId().equals(removePatient));
            System.out.println("patient removed successfully.");
        } else {
            System.out.println("patient not found.");
        }

    }

    @Override
    public List<Patient> getAll() {
        if (patientList.isEmpty()) {
            System.out.println("No patient available: ");
        }
        System.out.println("display all the patient");
        for (Patient patient : patientList) {
            patient.displayInfo();

        }
        return patientList;
    }

    public Patient addPatient(String firstName, String lastName, String phone) {
        Patient patient = new Patient();
        patient.setId(HelperUtils.generateId("PER"));
        patient.setPatientId(HelperUtils.generateId("PAT"));
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);
        patient.setRegistrationDate(LocalDate.now());
        return patient;
    }

    public Patient addPatient(String firstName, String lastName, String phone, String bloodGroup, String email) {
        Patient patient = new Patient();
        patient.setId(HelperUtils.generateId("PER"));
        patient.setPatientId(HelperUtils.generateId("PAT"));
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);
        patient.setBloodGroup(bloodGroup);
        patient.setEmail(email);
        patient.setRegistrationDate(LocalDate.now());
        return patient;
    }

    public Patient addPatient(Patient patient) {
        return patient;
    }

    public void searchPatients(String keyword) {
        if (patientList.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }

        boolean found = false;
        for (Patient patient : patientList) {
            if (patient.getFirstName().toLowerCase().contains(keyword.toLowerCase()) ||
                    patient.getLastName().toLowerCase().contains(keyword.toLowerCase()) ||
                    patient.getPhoneNumber().toLowerCase().contains(keyword.toLowerCase()) ||
                    (patient.getEmail() != null && patient.getEmail().toLowerCase().contains(keyword.toLowerCase())) ||
                    (patient.getBloodGroup() != null && patient.getBloodGroup().equalsIgnoreCase(keyword))) {

                patient.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No patients found for keyword: " + keyword);
        }
    }

    public void searchPatients(String firstName, String lastName) {
        if (patientList.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }

        boolean found = false;
        for (Patient patient : patientList) {
            if (patient.getFirstName().equalsIgnoreCase(firstName) &&
                    patient.getLastName().equalsIgnoreCase(lastName)) {
                patient.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No patients found with name: " + firstName + " " + lastName);
        }
    }

    public void displayPatients() {
        if (patientList.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }

        System.out.println("All Registered Patients:");
        for (Patient patient : patientList) {
            patient.displayInfo();
        }
    }

    public void displayPatients(String filter) {
        if (patientList.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }

        boolean found = false;
        for (Patient patient : patientList) {
            if ((patient.getGender() != null && patient.getGender().equalsIgnoreCase(filter)) ||
                    (patient.getBloodGroup() != null && patient.getBloodGroup().equalsIgnoreCase(filter))) {
                patient.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No patients found for filter: " + filter);
        }
    }

    public void displayPatients(int limit) {
        if (patientList.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }

        System.out.println("Displaying up to " + limit + " patients:");
        for (int i = 0; i < Math.min(limit, patientList.size()); i++) {
            patientList.get(i).displayInfo();
        }
    }

    public static Boolean checkId(String IdCheck) {
        for (Patient patient : patientList) {
            if (patient.getPatientId().equals(IdCheck)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void searchByName() {
        if (patientList.isEmpty()) {
            System.out.println("No patients available");
        }

        System.out.println("Enter patient first name:");
        String firstName = scanner.nextLine().trim();
        System.out.println("Enter patient last name:");
        String lastName = scanner.nextLine().trim();

        for (Patient patient : patientList) {
            if (patient.getFirstName() != null && patient.getLastName() != null &&
                    patient.getFirstName().trim().equalsIgnoreCase(firstName) &&
                    patient.getLastName().trim().equalsIgnoreCase(lastName)) {
                System.out.println("Entity.Patient found:");
                patient.displayInfo();
                return;
            }
        }
            System.out.println("No patient found with this name");


    }

    public void searchById() {
        if (patientList.isEmpty()) {
            System.out.println("No patients available");
            return;
        }
        System.out.println("Enter patient Id to search:");
        String id = scanner.nextLine().trim();

        for (Patient patient : patientList) {
            if (patient.getPatientId() != null && patient.getPatientId().trim().equalsIgnoreCase(id)) {
                System.out.println("Patient found:");
                patient.displayInfo();
                return;
            }
        }
            System.out.println("Patient not found");
        }

    public static void sampleDatePatient() {
        System.out.println("Adding sample patients...");


        for (int i = 0; i < 3; i++) {
            Patient patient = new Patient();
            patient.setId(HelperUtils.generateId("PER"));
            patient.setPatientId(HelperUtils.generateId("PAT"));
            patient.setFirstName("Sample" + i);
            patient.setLastName("Al Harthy" + i);
            patient.setEmail("sample" + i + "@mail.com");
            patient.setPhoneNumber("9000000" + i);
            patient.setGender(i % 2 == 0 ? "Male" : "Female");
            patient.setBloodGroup("A+");
            patient.setDateOfBirth(LocalDate.of(1990, 1, 1).plusDays(i));
            patient.setInsuranceId("INS" + i);
            patient.setAddress("Muscat, Oman");
            patient.setEmergencyContact("9900000" + i);
            patient.setAllergies(List.of("Pollen"));
            patient.setRegistrationDate(LocalDate.now().minusDays(i));
            patient.setMedicalRecords(new ArrayList<>());
            patient.setAppointments(new ArrayList<>());
            patientList.add(patient);
        }


        for (int i = 0; i < 3; i++) {
            InPatient patient = new InPatient();
            patient.setId(HelperUtils.generateId("PER"));
            patient.setPatientId(HelperUtils.generateId("INP"));
            patient.setFirstName("InPatient" + i);
            patient.setLastName("Al Balushi" + i);
            patient.setEmail("inpatient" + i + "@mail.com");
            patient.setPhoneNumber("9111111" + i);
            patient.setGender(i % 2 == 0 ? "Male" : "Female");
            patient.setRoomNumber("R" + (100 + i));
            patient.setBedNumber("B" + (10 + i));
            patient.setAdmissionDate(LocalDate.now().minusDays(i + 1));
            patient.setDischargeDate(LocalDate.now().plusDays(3));
            patient.setAdmittingDoctorId("DOC" + i);
            patient.setDailyCharges(100.00 + (i * 20));
            patient.setRegistrationDate(LocalDate.now().minusDays(i));
            patient.setAddress("Muscat, Oman");
            patient.setBloodGroup("B+");
            patient.setDateOfBirth(LocalDate.of(1990, 5, 10).plusDays(i));
            patient.setInsuranceId("INSP" + i);
            patient.setEmergencyContact("9933333" + i);
            patient.setAllergies(List.of(i%2==0?"Non":"Cat"));
            patient.setMedicalRecords(new ArrayList<>());
            patient.setAppointments(new ArrayList<>());
            patientList.add(patient);
        }


        for (int i = 0; i < 4; i++) {
            EmergencyPatient patient = new EmergencyPatient();
            patient.setId(HelperUtils.generateId("PER"));
            patient.setPatientId(HelperUtils.generateId("EMP"));
            patient.setFirstName("Emergency" + i);
            patient.setLastName("Al Lawati" + i);
            patient.setEmail("emergency" + i + "@mail.com");
            patient.setPhoneNumber("9222222" + i);
            patient.setGender(i % 2 == 0 ? "Male" : "Female");
            patient.setAdmissionDate(LocalDate.now());
            patient.setDischargeDate(LocalDate.now().plusDays(1));
            patient.setRoomNumber("ER" + i);
            patient.setBedNumber("EB" + i);
            patient.setAdmittingDoctorId("DOC" + (i + 3));
            patient.setDailyCharges(200.0);
            patient.setEmergencyType("Accident");
            patient.setArrivalMode("Ambulance");
            patient.setTriageLevel(3);
            patient.setAdmittedViaER(true);
            patient.setRegistrationDate(LocalDate.now().minusDays(i));
            patient.setAddress("Muscat, Oman");
            patient.setBloodGroup("O+");
            patient.setDateOfBirth(LocalDate.of(1992, 2, 15).plusDays(i));
            patient.setInsuranceId("INS-E" + i);
            patient.setEmergencyContact("9944444" + i);
            patient.setAllergies(List.of(i%2==0?"Non":"Dust"));
            patient.setMedicalRecords(new ArrayList<>());
            patient.setAppointments(new ArrayList<>());
            patientList.add(patient);
        }

        System.out.println("Sample patients successfully added: " + patientList.size());
    }
}
