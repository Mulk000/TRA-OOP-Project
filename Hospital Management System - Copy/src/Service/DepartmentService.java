package Service;

import Entity.Department;
import Entity.Doctor;
import Entity.Nurse;
import Interface.Manageable;
import Interface.Searchable;
import Utils.HelperUtils;
import Utils.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class DepartmentService implements Manageable<Department>, Searchable {

    public static List<Department> departmentList = new ArrayList<>();

    @Override
    public Department add() {
        Department department = new Department();
        String departmentId = HelperUtils.generateId("DP");
        System.out.println("Generated Department ID : " + departmentId);
        department.setDepartmentId(departmentId);

        department.setDepartmentName(InputHandler.getStringInput("Enter department name "));
        String headDoctorId = InputHandler.getStringInput("Enter head doctor ID ");
        DoctorService doctorService = new DoctorService();
        boolean found = false;
        List<Doctor> doctors = doctorService.getAll();

        for (Doctor d : doctors) {
            if (d.getDoctorId().equals(headDoctorId)) {
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Doctor ID not found. Department not created.");
            return null;
        }

        department.setHeadDoctorId(headDoctorId);

        department.setBedCapacity(InputHandler.getIntInput("Enter bed capacity "));
        department.setAvailableBeds(InputHandler.getIntInput("Enter available beds "));

        return department;
    }

    public static void save(Department department) {
        departmentList.add(department);
        System.out.println("Department has been added successfully.");
    }
    @Override
    public void remove(String id) {
        if (departmentList.isEmpty()) {
            System.out.println("No departments available.");
            return;
        }

        boolean removed = departmentList.removeIf(d -> d.getDepartmentId().equals(id));

        if (removed) {
            System.out.println("Department removed successfully.");
        } else {
            System.out.println("Department not found.");
        }
    }

    @Override
    public List<Department> getAll() {
        if (departmentList.isEmpty()) {
            System.out.println("No departments found.");
        }

        for (Department d : departmentList) {
            System.out.println("----------------------------");
            d.displayInfo();
        }
        return departmentList;
    }
    @Override
    public void searchByName() {
        if (departmentList.isEmpty()) {
            System.out.println("No departments available.");
            return;
        }

        String name = InputHandler.getStringInput("Enter department name to search: ");
        boolean found = false;

        for (Department d : departmentList) {
            if (d.getDepartmentName().equalsIgnoreCase(name)) {
                System.out.println("Department found:");
                d.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No departments found with this name.");
        }
    }
    @Override
    public void searchById() {
        if (departmentList.isEmpty()) {
            System.out.println("No departments available.");
            return;
        }

        String id = InputHandler.getStringInput("Enter department ID to search: ");
        boolean found = false;

        for (Department d : departmentList) {
            if (d.getDepartmentId().equalsIgnoreCase(id)) {
                System.out.println("Department found:");
                d.displayInfo();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Department not found by ID.");
        }
    }
    private Department findById(String id) {
        for (Department d : departmentList) {
            if (d.getDepartmentId().equalsIgnoreCase(id.trim())) {
                return d;
            }
        }
        return null;
    }
    public void assignDoctor() {
        System.out.println("Assigning doctor to department...");
        String doctorId = InputHandler.getStringInput("Enter Doctor ID to assign: ");
        while (!DoctorService.checkId(doctorId)) {
            doctorId = InputHandler.getStringInput("Doctor not found. Enter a valid Doctor ID: ");
        }

        String departmentId = InputHandler.getStringInput("Enter Department ID to assign doctor: ");
        Department dep = null;
        while (dep == null) {
            for (Department d : departmentList) {
                if (d.getDepartmentId().equalsIgnoreCase(departmentId)) {
                    dep = d;
                    break;
                }
            }
            if (dep == null) {
                departmentId = InputHandler.getStringInput("Department not found. Enter a valid Department ID: ");
            }
        }

        if (dep.getDoctors() == null) {
            dep.setDoctors(new ArrayList<>());
        }

        for (Doctor doctor : DoctorService.doctorList) {
            if (doctor.getDoctorId().equalsIgnoreCase(doctorId)) {
                dep.getDoctors().add(doctor);
                doctor.setDepartmentId(departmentId);
                System.out.println("Doctor assigned to department successfully.");
                return;
            }
        }

        System.out.println("Doctor not found in the system.");
    }
    public void assignNurse(String departmentId, Nurse nurse) {
        System.out.println("Assigning nurse to department...");
        String departmentID = InputHandler.getStringInput("Enter department ID: ");
        Department department = null;
        for (Department d : DepartmentService.departmentList) {
            if (d.getDepartmentId().equalsIgnoreCase(departmentID)) {
                department = d;
                break;
            }
        }

        if (department == null) {
            System.out.println("Department not found.");
            return;
        }

        String nurseId = InputHandler.getStringInput("Enter nurse ID to assign: ");
        Nurse nurseToAssign = null;
        for (Nurse n : NurseService.nurseList) {
            if (n.getNurseId().equalsIgnoreCase(nurseId)) {
                nurseToAssign = n;
                break;
            }
        }

        if (nurseToAssign == null) {
            System.out.println("Nurse not found in the system. Cannot assign.");
            return;
        }

        nurseToAssign.setDepartmentId(departmentID);

        if (department.getNurses() == null) {
            department.setNurses(new ArrayList<>());
        }

        if (!department.getNurses().contains(nurseToAssign)) {
            department.getNurses().add(nurseToAssign);
        }

        System.out.println("Nurse assigned successfully!");
    }
    public void updateDepartmentInfo() {
        if (departmentList.isEmpty()) {
            System.out.println("No departments to update.");
            return;
        }

        String id = InputHandler.getStringInput("Enter department ID to update: ");
        Department department = findById(id);
        if (department == null) {
            System.out.println("Department not found.");
            return;
        }

        System.out.println("Updating Department Information...");
        department.setDepartmentName(InputHandler.getStringInput("Enter new department name: "));
        department.setHeadDoctorId(InputHandler.getStringInput("Enter new head doctor ID: "));
        department.setBedCapacity(InputHandler.getIntInput("Enter new bed capacity: "));
        department.setAvailableBeds(InputHandler.getIntInput("Enter new available beds: "));

        System.out.println("Department updated successfully.");
    }
    public void viewDepartmentStatistics() {
        if (departmentList.isEmpty()) {
            System.out.println("No departments found.");
            return;
        }

        System.out.println("Department Statistics:");
        for (Department d : departmentList) {
            System.out.println("----------------------------");
            System.out.println("Department Name: " + d.getDepartmentName());
            System.out.println("Total Beds: " + d.getBedCapacity());
            System.out.println("Available Beds: " + d.getAvailableBeds());
            int usedBeds = d.getBedCapacity() - d.getAvailableBeds();
            System.out.println("Used Beds: " + usedBeds);
            System.out.println("Doctors Assigned: " + (d.getDoctors() != null ? d.getDoctors().size() : 0));
            System.out.println("Nurses Assigned: " + (d.getNurses() != null ? d.getNurses().size() : 0));
        }
    }

    public void updateAvailableBeds(String departmentId, int newBeds) {
        Department department = findById(departmentId);
        if (department != null) {
            department.setAvailableBeds(newBeds);
            System.out.println("Available beds updated successfully.");
        } else {
            System.out.println("Department not found.");
        }
    }


    public static boolean checkid(String idCheck) {
        for (Department d : departmentList) {
            if (d.getDepartmentId().equals(idCheck)) {
                return true;
            }
        }
        return false;
    }
}
