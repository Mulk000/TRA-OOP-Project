package Service;

import Entity.*;
import Interface.Manageable;
import Interface.Searchable;
import Utils.HelperUtils;
import Utils.InputHandler;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static Service.PatientService.patientList;


public class DoctorService implements Manageable<Doctor>, Searchable {
    public static List<Doctor> doctorList = new ArrayList<>();

    @Override
    public Doctor add() {
        Doctor doctor = new Doctor();

        String id = Utils.HelperUtils.generateId("PER");
        System.out.println("Generate person id :" + id);
        doctor.setId(id);

        doctor.setFirstName(InputHandler.getStringInput("Enter doctor first name "));
        doctor.setLastName(InputHandler.getStringInput("Enter doctor last name "));
        doctor.setDateOfBirth(InputHandler.getDateInput("Enter doctor Date of Birth "));
        doctor.setGender(InputHandler.getStringInput("Enter doctor Gender(Male,Female) "));
        doctor.setPhoneNumber(InputHandler.getStringInput("Enter doctor phone number "));
        doctor.setEmail(InputHandler.getStringInput("Enter doctor email "));
        doctor.setAddress(InputHandler.getStringInput("Enter doctor address "));

        String doctorId = Utils.HelperUtils.generateId("DR");
        System.out.println("Generate doctor id :" + doctorId);
        doctor.setDoctorId(doctorId);


        doctor.setSpecialization(InputHandler.getStringInput("Enter doctor specialization: "));
        doctor.setQualification(InputHandler.getStringInput("Enter doctor qualification: "));
        doctor.setExperienceYears(InputHandler.getIntInput("Enter doctor experience Years: "));
        doctor.setConsultationFee(InputHandler.getDoubleInput("Enter doctor consultation fee: "));
        String slots = InputHandler.getStringInput("Enter available slots (comma separated, e.g., 10:00,11:00,12:00): ");
        doctor.setAvailableSlots(Arrays.asList(slots.split(",")));

        return doctor;
    }

    public Surgeon addSurgeon() {
        System.out.println("Adding Surgeon...");
        Surgeon surgeon = new Surgeon();

        String personId = HelperUtils.generateId("PER");
        System.out.println("Generated person ID: " + personId);
        surgeon.setId(personId);

        surgeon.setFirstName(InputHandler.getStringInput("Enter doctor's first name: "));
        surgeon.setLastName(InputHandler.getStringInput("Enter doctor's last name: "));
        surgeon.setDateOfBirth(InputHandler.getDateInput("Enter doctor's date of birth: "));
        surgeon.setGender(InputHandler.getStringInput("Enter doctor's gender(Male,Female): "));
        surgeon.setPhoneNumber(InputHandler.getStringInput("Enter doctor's phone number: "));
        surgeon.setEmail(InputHandler.getStringInput("Enter doctor's email: "));
        surgeon.setAddress(InputHandler.getStringInput("Enter doctor's address: "));

        String doctorId = HelperUtils.generateId("SR");
        System.out.println("Generated doctor ID: " + doctorId);
        surgeon.setDoctorId(doctorId);

        surgeon.setSpecialization("Surgeon");
        surgeon.setQualification(InputHandler.getStringInput("Enter doctor's qualification: "));
        surgeon.setExperienceYears(InputHandler.getIntInput("Enter doctor's experience years: "));
        surgeon.setConsultationFee(InputHandler.getDoubleInput("Enter doctor's consultation fee: "));

        surgeon.setSurgeriesPerformed(InputHandler.getIntInput("Enter number of surgeries performed: "));
        surgeon.setOperationTheatreAccess(InputHandler.getConfirmation("Does the surgeon have operation theatre access? (true/false): "));
        String types = InputHandler.getStringInput("Enter surgery types (comma separated): ");
        surgeon.setSurgeryTypes(Arrays.asList(types.split(",")));

        System.out.println("Surgeon added successfully with ID: " + surgeon.getDoctorId());
        String slots = InputHandler.getStringInput("Enter available slots (comma separated, e.g., 10:00,11:00,12:00): ");
        surgeon.setAvailableSlots(Arrays.asList(slots.split(",")));
        return surgeon;
    }

    public Consultant addConsultant() {
        System.out.println("Adding Consultant...");
        Consultant consultant = new Consultant();

        String personId = HelperUtils.generateId("CON");
        System.out.println("Generated person ID: " + personId);
        consultant.setId(personId);

        consultant.setFirstName(InputHandler.getStringInput("Enter doctor's first name: "));
        consultant.setLastName(InputHandler.getStringInput("Enter doctor's last name: "));
        consultant.setDateOfBirth(InputHandler.getDateInput("Enter doctor's date of birth: "));
        consultant.setGender(InputHandler.getStringInput("Enter doctor's gender(Male,Female): "));
        consultant.setPhoneNumber(InputHandler.getStringInput("Enter doctor's phone number: "));
        consultant.setEmail(InputHandler.getStringInput("Enter doctor's email: "));
        consultant.setAddress(InputHandler.getStringInput("Enter doctor's address: "));

        String doctorId = HelperUtils.generateId("CO");
        System.out.println("Generated doctor ID: " + doctorId);
        consultant.setDoctorId(doctorId);

        consultant.setSpecialization("Consultant");
        consultant.setQualification(InputHandler.getStringInput("Enter doctor's qualification: "));
        consultant.setExperienceYears(InputHandler.getIntInput("Enter doctor's experience years: "));
        consultant.setConsultationFee(InputHandler.getDoubleInput("Enter doctor's consultation fee: "));

        String types = InputHandler.getStringInput("Enter consultation types (comma separated): ");
        consultant.setConsultationTypes(Arrays.asList(types.split(",")));
        consultant.setOnlineConsultationAvailable(InputHandler.getConfirmation("Is online consultation available? (true/false): "));
        consultant.setConsultationDuration(InputHandler.getIntInput("Enter consultation duration (in minutes): "));

        save(consultant);
        System.out.println("Consultant added successfully with ID: " + consultant.getDoctorId());
        String slots = InputHandler.getStringInput("Enter available slots (comma separated, e.g., 10:00,11:00,12:00): ");
        consultant.setAvailableSlots(Arrays.asList(slots.split(",")));
        return consultant;
    }

    public GeneralPractitioner addGeneralPractitioner() {
        System.out.println("Adding General Practitioner...");
        GeneralPractitioner generalPractitioner = new GeneralPractitioner();

        String personId = HelperUtils.generateId("GEN");
        System.out.println("Generated person ID: " + personId);
        generalPractitioner.setId(personId);

        generalPractitioner.setFirstName(InputHandler.getStringInput("Enter doctor's first name: "));
        generalPractitioner.setLastName(InputHandler.getStringInput("Enter doctor's last name: "));
        generalPractitioner.setDateOfBirth(InputHandler.getDateInput("Enter doctor's date of birth: "));
        generalPractitioner.setGender(InputHandler.getStringInput("Enter doctor's gender(Male,Female): "));
        generalPractitioner.setPhoneNumber(InputHandler.getStringInput("Enter doctor's phone number: "));
        generalPractitioner.setEmail(InputHandler.getStringInput("Enter doctor's email: "));
        generalPractitioner.setAddress(InputHandler.getStringInput("Enter doctor's address: "));

        String doctorId = HelperUtils.generateId("GP");
        System.out.println("Generated doctor ID: " + doctorId);
        generalPractitioner.setDoctorId(doctorId);

        generalPractitioner.setSpecialization("General Practitioner");
        generalPractitioner.setQualification(InputHandler.getStringInput("Enter doctor's qualification: "));
        generalPractitioner.setExperienceYears(InputHandler.getIntInput("Enter doctor's experience years: "));
        generalPractitioner.setConsultationFee(InputHandler.getDoubleInput("Enter doctor's consultation fee: "));

        generalPractitioner.setWalkinAvailable(InputHandler.getConfirmation("Is walk-in consultation available? (true/false): "));
        generalPractitioner.setHomeVisitAvailable(InputHandler.getConfirmation("Are home visits available? (true/false): "));
        generalPractitioner.setVaccinationCertified(InputHandler.getConfirmation("Is the doctor certified for vaccinations? (true/false): "));

        save(generalPractitioner);
        System.out.println("General Practitioner added successfully with ID: " + generalPractitioner.getDoctorId());
        String slots = InputHandler.getStringInput("Enter available slots (comma separated, e.g., 10:00,11:00,12:00): ");
        generalPractitioner.setAvailableSlots(Arrays.asList(slots.split(",")));
        return generalPractitioner;
    }

    public static void save(Doctor doctor) {
        doctorList.add(doctor);
        System.out.println("Doctor has been added successfully");
    }

    public static Doctor editDoctor() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctor to edit");
            return null;
        }

        String id = InputHandler.getStringInput("Enter doctor id:");
        while (!checkId(id)) {
            id = InputHandler.getStringInput("Please enter a valid id:");
        }

        Doctor selectedDoctor = null;
        for (Doctor doctor : doctorList) {
            if (doctor.getDoctorId().equalsIgnoreCase(id)) {
                selectedDoctor = doctor;
                break;
            }
        }

        if (selectedDoctor == null) {
            System.out.println("Doctor not found");
            return null;
        }

        System.out.println("Select field to edit:");
        System.out.println("""
                1 - Specialization
                2 - Qualification
                3 - Experience Years
                4 - Department ID
                5 - Consultation Fee
                6 - Exit
                """);
        int choice = InputHandler.getIntInput("Enter your choice:");

        switch (choice) {
            case 1 -> {
                selectedDoctor.setSpecialization(InputHandler.getStringInput("Enter new specialization: "));
            }
            case 2 -> {
                selectedDoctor.setQualification(InputHandler.getStringInput("Enter new qualification: "));

            }
            case 3 -> {
                selectedDoctor.setExperienceYears(InputHandler.getIntInput("Enter new experience years: "));
            }
            case 4 -> {
                selectedDoctor.setDepartmentId(InputHandler.getStringInput("Enter new department ID: "));
            }
            case 5 -> {
                selectedDoctor.setConsultationFee(InputHandler.getDoubleInput("Enter new consultation fee: "));
            }
            case 6 -> {
                System.out.println("Exiting edit menu");
                return selectedDoctor;
            }
            default -> System.out.println("Invalid choice");
        }

        return selectedDoctor;
    }

    public static void updateDoctor(Doctor updatedDoctor) {
        if (updatedDoctor == null) {
            System.out.println("No updates to save");
            return;
        }
        for (int i = 0; i < doctorList.size(); i++) {
            if (doctorList.get(i).getDoctorId().equals(updatedDoctor.getDoctorId())) {
                doctorList.set(i, updatedDoctor);
                System.out.println("Doctor updated successfully.");
                return;
            }
        }
        System.out.println("Updated doctor not found in list");

    }

    @Override
    public void remove(String id) {
        if (id == null) {
            System.out.println("Invalid input. No doctor removed.");
            return;
        }
        if (checkId(id)) {
            doctorList.removeIf(doctor -> doctor.getDoctorId().equals(id));
            System.out.println("Doctor removed successfully.");
        } else {
            System.out.println("Doctor not found.");
        }
    }

    public static String getDoctorToRemove() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctor available to remove.");
            return null;
        }
        String id = InputHandler.getStringInput("Choose an ID of a doctor to remove: ");
        while (id == null || !checkId(id)) {
            id = InputHandler.getStringInput("Invalid ID, Please Enter Another ID ");
        }
        return id;

    }

    @Override
    public List<Doctor> getAll() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors found.");
        }
        for (Doctor doctor : doctorList) {
            System.out.println("----------------------------");
            doctor.displayInfo();
        }
        return doctorList;
    }

    @Override
    public void searchByName() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors available");
            return;
        }
        String name = InputHandler.getStringInput("Enter doctor name to search");

        for (Doctor doctor : doctorList) {
            if (doctor.getFirstName().equalsIgnoreCase(name) || doctor.getLastName().equalsIgnoreCase(name)) {
                System.out.println("Doctor found:");
                doctor.displayInfo();
                return;
            }
        }
        System.out.println("No doctor found with this name.");

    }


    @Override
    public void searchById() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors available");
            return;
        }

        String id = InputHandler.getStringInput("Enter doctor ID to search:");

        for (Doctor doctor : doctorList) {
            if (doctor.getDoctorId().equalsIgnoreCase(id)) {
                System.out.println("Doctor found:");
                doctor.displayInfo();
                return;
            }
        }

        System.out.println("Doctor not found by ID.");

    }

    public static Doctor addDoctor(String name, String specialization, String phone) {
        Doctor doctor = new Doctor();
        doctor.setId(HelperUtils.generateId("PER"));
        doctor.setDoctorId(HelperUtils.generateId("DR"));
        doctor.setFirstName(name);
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);
        doctorList.add(doctor);
        System.out.println("Doctor added: " + doctor.getFirstName() + " (" + specialization + ")");
        return doctor;
    }

    public static Doctor addDoctor(String name, String specialization, String phone, double consultationFee) {
        Doctor doctor = addDoctor(name, specialization, phone);
        doctor.setConsultationFee(consultationFee);
        System.out.println("Consultation fee set to: " + consultationFee);
        return doctor;
    }

    public static void addDoctor(Doctor doctor) {
        if (doctor == null) {
            System.out.println("Invalid doctor data.");
            return;
        }
        doctorList.add(doctor);
        System.out.println("Doctor added successfully: " + doctor.getDoctorId());
    }

    public static void assignPatient(String doctorId, String patientId) {
        Doctor doctor = null;
        for (Doctor d : doctorList) {
            if (d.getDoctorId().equalsIgnoreCase(doctorId)) {
                doctor = d;
                break;
            }
        }

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        if (doctor.getAssignedPatients() == null) {
            doctor.setAssignedPatients(new ArrayList<>());
        }

        doctor.getAssignedPatients().add(patientId);
        System.out.println("Patient " + patientId + " assigned to Doctor " + doctor.getFirstName());
    }

    public static void assignPatient(Doctor doctor, Entity.Patient patient) {
        if (doctor == null || patient == null) {
            System.out.println("Invalid doctor or patient.");
            return;
        }

        if (doctor.getAssignedPatients() == null) {
            doctor.setAssignedPatients(new ArrayList<>());
        }

        doctor.getAssignedPatients().add(patient.getPatientId());
        System.out.println("Patient " + patient.getPatientId() + " assigned to Doctor " + doctor.getFirstName());
    }

    public static void assignPatient(String doctorId, List<String> patientIds) {
        Doctor doctor = null;
        for (Doctor d : doctorList) {
            if (d.getDoctorId().equalsIgnoreCase(doctorId)) {
                doctor = d;
                break;
            }
        }

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        if (doctor.getAssignedPatients() == null) {
            doctor.setAssignedPatients(new ArrayList<>());
        }

        doctor.getAssignedPatients().addAll(patientIds);
        System.out.println("Patients " + patientIds + " assigned to Doctor " + doctor.getFirstName());
    }

    public static void displayDoctors() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }
        for (Doctor doctor : doctorList) {
            doctor.displayInfo();
            System.out.println("----------------------------");
        }
    }

    public static void displayDoctors(String specialization) {
        boolean found = false;
        for (Doctor doctor : doctorList) {
            if (doctor.getSpecialization().equalsIgnoreCase(specialization)) {
                doctor.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No doctors found with specialization: " + specialization);
        }
    }

    public static void displayDoctors(String departmentId, boolean showAvailableOnly) {
        boolean found = false;
        for (Doctor doctor : doctorList) {
            if (doctor.getDepartmentId().equalsIgnoreCase(departmentId)) {
                if (!showAvailableOnly || (doctor.getAvailableSlots() != null && !doctor.getAvailableSlots().isEmpty())) {
                    doctor.displayInfo();
                    System.out.println("Available Slots: " + doctor.getAvailableSlots());
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No doctors found for department: " + departmentId);
        }
    }

    public static Boolean checkId(String idCheck) {
        for (Doctor doctor : doctorList) {
            if (doctor.getDoctorId().equalsIgnoreCase(idCheck)) {
                return true;
            }
        }
        return false;

    }

    public static void searchDoctorBySpecialization() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors available");
            return;
        }

        String specialization = InputHandler.getStringInput("Enter specialization to search:");
        for (Doctor doctor : doctorList) {
            if (doctor.getSpecialization() != null && doctor.getSpecialization().equalsIgnoreCase(specialization)) {
                System.out.println("Doctor found:");
                doctor.displayInfo();
                return;
            }
        }
        System.out.println("No doctor found with this specialization.");

    }

    public static void viewAvailableDoctors() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors available");
            return;
        }
        String slot = InputHandler.getStringInput("enter available slot");

        for (Doctor doctor : doctorList) {
            List<String> availableSlots = doctor.getAvailableSlots();
            if (availableSlots.stream().anyMatch(s -> s.equalsIgnoreCase(slot))) {
                System.out.println("The List of The Available Doctors");
                doctor.displayInfo();
                return;
            }
        }
        System.out.println("No Doctors available at the specified time slot.");
    }

    public static void assignPatientToDoctor() {
        if (doctorList.isEmpty()) {
            System.out.println("No doctors available");
            return;
        }

        String patientId = InputHandler.getStringInput("Enter patient ID:");
        Patient patient = null;
        for (Patient p : patientList) {
            if (p.getPatientId().equalsIgnoreCase(patientId)) {
                patient = p;
                break;
            }
        }

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        String doctorId = InputHandler.getStringInput("Enter doctor ID:");
        Doctor doctor = null;
        for (Doctor d : doctorList) {
            if (d.getDoctorId().equalsIgnoreCase(doctorId)) {
                doctor = d;
                break;
            }
        }

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        doctor.getAssignedPatients().add(patientId);
        System.out.println("Patient " + patientId + " assigned to Doctor " + doctor.getFirstName());
    }
    public static void sampleDataDoctor() {
        System.out.println("Adding sample doctors...");

        for (int i = 0; i < 4; i++) {
            Doctor doctor = null;

            if (i == 0) {
                Surgeon surgeon = new Surgeon();
                surgeon.setId(HelperUtils.generateId("PER"));
                surgeon.setDoctorId(HelperUtils.generateId("SR"));
                surgeon.setFirstName("Ali");
                surgeon.setLastName("Al Harthy");
                surgeon.setGender("Male");
                surgeon.setPhoneNumber("90111111");
                surgeon.setEmail("ali.harthy@mail.com");
                surgeon.setAddress("Muscat, Oman");
                surgeon.setSpecialization("Surgery");
                surgeon.setQualification("MBBS, MS");
                surgeon.setExperienceYears(6);
                surgeon.setConsultationFee(250.0);
                surgeon.setSurgeriesPerformed(40);
                surgeon.setOperationTheatreAccess(true);
                surgeon.setSurgeryTypes(Arrays.asList("Cardiac", "Orthopedic"));
                surgeon.setAvailableSlots(Arrays.asList("09:00", "11:00", "14:00"));
                doctor = surgeon;
            } else if (i == 1) {
                Surgeon surgeon = new Surgeon();
                surgeon.setId(HelperUtils.generateId("PER"));
                surgeon.setDoctorId(HelperUtils.generateId("SR"));
                surgeon.setFirstName("Fatma");
                surgeon.setLastName("Al Hinai");
                surgeon.setGender("Female");
                surgeon.setPhoneNumber("90112222");
                surgeon.setEmail("fatma.hinai@mail.com");
                surgeon.setAddress("Sohar, Oman");
                surgeon.setDateOfBirth(i == 0 ? LocalDate.of(1980, 3, 15) : LocalDate.of(1982, 7, 22));
                surgeon.setSpecialization("Neurosurgery");
                surgeon.setQualification("MBBS, MD");
                surgeon.setExperienceYears(7);
                surgeon.setConsultationFee(300.0);
                surgeon.setSurgeriesPerformed(55);
                surgeon.setOperationTheatreAccess(true);
                surgeon.setSurgeryTypes(Arrays.asList("Neuro", "Spine"));
                surgeon.setAvailableSlots(Arrays.asList("10:00", "13:00", "15:00"));
                doctor = surgeon;
            } else if (i == 2) {
                Consultant consultant = new Consultant();
                consultant.setId(HelperUtils.generateId("PER"));
                consultant.setDoctorId(HelperUtils.generateId("CO"));
                consultant.setFirstName("Hassan");
                consultant.setLastName("Al Balushi");
                consultant.setGender("Male");
                consultant.setPhoneNumber("90223333");
                consultant.setEmail("hassan.balushi@mail.com");
                consultant.setAddress("Muscat, Oman");
                consultant.setDateOfBirth(i == 0 ? LocalDate.of(1978, 11, 5) : LocalDate.of(1981, 4, 10));
                consultant.setSpecialization("Internal Medicine");
                consultant.setQualification("MBBS, MD");
                consultant.setExperienceYears(10);
                consultant.setConsultationFee(180.0);
                consultant.setConsultationTypes(Arrays.asList("In-person", "Online"));
                consultant.setOnlineConsultationAvailable(true);
                consultant.setConsultationDuration(30);
                consultant.setAvailableSlots(Arrays.asList("09:00", "12:00", "16:00"));
                doctor = consultant;
            } else if (i == 3) {
                GeneralPractitioner gp = new GeneralPractitioner();
                gp.setId(HelperUtils.generateId("PER"));
                gp.setDoctorId(HelperUtils.generateId("GP"));
                gp.setFirstName("Salim");
                gp.setLastName("Al Lawati");
                gp.setGender("Male");
                gp.setPhoneNumber("90334444");
                gp.setEmail("salim.lawati@mail.com");
                gp.setAddress("Nizwa, Oman");
                gp.setDateOfBirth(i == 0 ? LocalDate.of(1990, 1, 12) : LocalDate.of(1992, 6, 18));
                gp.setSpecialization("General Practice");
                gp.setQualification("MBBS");
                gp.setExperienceYears(4);
                gp.setConsultationFee(100.0);
                gp.setWalkinAvailable(true);
                gp.setHomeVisitAvailable(true);
                gp.setVaccinationCertified(true);
                gp.setAvailableSlots(Arrays.asList("08:00", "10:00", "13:00"));
                doctor = gp;
            }

            doctorList.add(doctor);
        }

        System.out.println("Sample doctors successfully added: " + doctorList.size());
    }
}