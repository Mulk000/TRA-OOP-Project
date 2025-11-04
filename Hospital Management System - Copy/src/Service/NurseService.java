package Service;

import Entity.Department;
import Entity.Nurse;
import Entity.Patient;
import Interface.Manageable;
import Interface.Searchable;
import Utils.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class NurseService implements Manageable<Nurse>, Searchable {
    public static List<Nurse> nurseList = new ArrayList<>();

    @Override
    public Nurse add() {
        Nurse nurse = new Nurse();
        String id = Utils.HelperUtils.generateId("PER");
        System.out.println("Generate person id :" + id);
        nurse.setId(id);
        nurse.setFirstName(InputHandler.getStringInput("Enter nurse first name: "));
        nurse.setLastName(InputHandler.getStringInput("Enter nurse last name: "));
        nurse.setDateOfBirth(InputHandler.getDateInput("Enter nurse Date of Birth: "));
        nurse.setGender(InputHandler.getStringInput("Enter nurse Gender: "));
        nurse.setPhoneNumber(InputHandler.getStringInput("Enter nurse phone number: "));
        nurse.setEmail(InputHandler.getStringInput("Enter nurse email: "));
        nurse.setAddress(InputHandler.getStringInput("Enter nurse address: "));

        String nurseId = Utils.HelperUtils.generateId("NUR");
        System.out.println("Generate nurse id :" + nurseId);
        nurse.setNurseId(nurseId);
        nurse.setShift(InputHandler.getStringInput("Enter nurse shift(Morning/Night/Evening): "));
        nurse.setQualification(InputHandler.getStringInput("Enter nurse qualification: "));

        return nurse;
    }

    public static void save(Nurse nurse) {
        nurseList.add(nurse);
        System.out.println("Nurse has been added successfully");
    }

    public static Nurse editNurse() {
        if (nurseList.isEmpty()) {
            System.out.println("No nurse to edit");
            return null;
        }

        String id = InputHandler.getStringInput("Enter nurse id:");
        while (!checkId(id)) {
            id = InputHandler.getStringInput("Please enter a valid id:");
        }

        Nurse selectedNurse = null;
        for (Nurse nurse : nurseList) {
            if (nurse.getNurseId().equals(id)) {
                selectedNurse = nurse;
                break;
            }
        }

        if (selectedNurse == null) {
            System.out.println("Nurse not found");
            return null;
        }

        System.out.println("Select field to edit:");
        System.out.println("""
                1 - Department ID
                2 - Shift
                3 - Qualification
                4 - Exit
                """);
        int choice = InputHandler.getIntInput("Enter your choice:");

        switch (choice) {
            case 1 -> {
                String newDeptId = InputHandler.getStringInput("Enter new department ID: ");
                while (!DepartmentService.checkid(newDeptId)) {
                    newDeptId = InputHandler.getStringInput("Department not found. Enter a valid department ID: ");
                }
                selectedNurse.setDepartmentId(newDeptId);
                System.out.println("Nurse department updated successfully.");
            }
            case 2 ->{
                selectedNurse.setShift(InputHandler.getStringInput("Enter new shift: "));
            }
            case 3 ->{
                selectedNurse.setQualification(InputHandler.getStringInput("Enter new qualification: "));
            }
            case 4 -> {
                System.out.println("Exiting edit menu");
                return selectedNurse;
            }
            default -> System.out.println("Invalid choice");
        }

        return selectedNurse;
    }

    public static void updateNurse(Nurse updatedNurse) {
        if (updatedNurse == null || updatedNurse.getNurseId() == null || updatedNurse.getNurseId().trim().isEmpty()) {
            System.out.println("No updates to save");
            return;
        }

        for (int i = 0; i < nurseList.size(); i++) {
            if (nurseList.get(i).getNurseId().equalsIgnoreCase(updatedNurse.getNurseId())) {
                nurseList.set(i, updatedNurse);
                System.out.println("Nurse updated successfully.");
                return;
            }
        }

        System.out.println("Updated nurse not found in list");
    }

    @Override
    public void remove(String id) {
        if (id == null) {
            System.out.println("Invalid input. No nurse removed.");
            return;
        }
        if (checkId(id)) {
            nurseList.removeIf(nurse -> nurse.getNurseId().equals(id));
            System.out.println("Nurse removed successfully.");
        } else {
            System.out.println("Nurse not found.");
        }
    }

    public static String getNurseToRemove() {
        if (nurseList.isEmpty()) {
            System.out.println("No nurse available to remove.");
            return null;
        }
        String id = InputHandler.getStringInput("Choose an ID of a nurse to remove: ");
        while (id == null || !checkId(id)) {
            id = InputHandler.getStringInput("Invalid ID, Please Enter Another ID ");
        }
        return id;
    }

    public static void removeNurse(String nurseId) {
        nurseList.removeIf(n -> n.getNurseId().equalsIgnoreCase(nurseId));
        System.out.println("Nurse removed successfully.");
    }

    @Override
    public List<Nurse> getAll() {
        if (nurseList.isEmpty()) {
            System.out.println("No nurses found.");
        }
        for (Nurse nurse : nurseList) {
            System.out.println("----------------------------");
            nurse.displayInfo();
        }
        return nurseList;
    }

    @Override
    public void searchByName() {
        if (nurseList.isEmpty()) {
            System.out.println("No nurses available");
            return;
        }
        String name = InputHandler.getStringInput("Enter nurse name to search:");

        boolean found = false;
        for (Nurse nurse : nurseList) {
            if (nurse.getFirstName().equalsIgnoreCase(name) || nurse.getLastName().equalsIgnoreCase(name)) {
                System.out.println("Nurse found:");
                nurse.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No nurse found with this name.");
        }
    }

    @Override
    public void searchById() {
        if (nurseList.isEmpty()) {
            System.out.println("No nurses available");
            return;
        }

        String id = InputHandler.getStringInput("Enter nurse ID to search:");
        boolean found = false;

        for (Nurse nurse : nurseList) {
            if (nurse.getId().equalsIgnoreCase(id)) {
                System.out.println("Nurse found:");
                nurse.displayInfo();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Nurse not found by ID.");
        }
    }
    public static void viewNursesByDepartment() {
        if (nurseList.isEmpty()) {
            System.out.println("No nurses available.");
            return;
        }
        String departmentId = InputHandler.getStringInput("Enter Department ID: ");
        List<Nurse> nursesByDepartment = new ArrayList<>();
        for (Nurse nurse : nurseList) {
            if (nurse.getDepartmentId() != null && nurse.getDepartmentId().equalsIgnoreCase(departmentId)) {
                nursesByDepartment.add(nurse);
            }
        }
        if (nursesByDepartment.isEmpty()) {
            System.out.println("No nurses found for department: " + departmentId);
        } else {
            System.out.println("Nurses in Department " + departmentId + ":");
            for (Nurse nurse : nursesByDepartment) {
                nurse.displayInfo();
            }
        }
    }
    public static void viewNursesByShift() {
        if (nurseList.isEmpty()) {
            System.out.println("No nurses available.");
            return;
        }

        String shift = InputHandler.getStringInput("Enter shift to filter (e.g., Morning, Evening, Night): ");
        boolean found = false;

        for (Nurse nurse : nurseList) {
            if (nurse.getShift() != null && nurse.getShift().equalsIgnoreCase(shift)) {
                nurse.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No nurses found for this shift.");
        }
    }
    public static void assignNurseToPatient() {
        System.out.println("Assign Nurse to Patient...");
        String patientId = InputHandler.getStringInput("Enter Patient ID: ");
        if (!PatientService.checkId(patientId)) {
            System.out.println("Patient not found.");
            return;
        }

        String nurseId = InputHandler.getStringInput("Enter Nurse ID: ");
        Nurse nurse = null;
        for (Nurse n : NurseService.nurseList) {
            if (n.getNurseId().equalsIgnoreCase(nurseId)) {
                nurse = n;
                break;
            }
        }

        if (nurse == null) {
            System.out.println("Nurse not found.");
            return;
        }

        if (nurse.getAssignedPatients() == null) {
            nurse.setAssignedPatients(new ArrayList<>());
        }

        if (!nurse.getAssignedPatients().contains(patientId)) {
            nurse.getAssignedPatients().add(patientId);
        }

        System.out.println("Patient assigned to nurse successfully!");
        System.out.println("----------------------------");
    }
    public static Boolean checkId(String idCheck) {
        for (Nurse nurse : nurseList) {
            if (nurse.getNurseId().equalsIgnoreCase(idCheck)) {
                return true;
            }
        }
        return false;
    }
}