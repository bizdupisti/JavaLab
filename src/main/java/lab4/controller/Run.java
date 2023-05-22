package lab4.controller;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import lab4.model.*;
public class Run {
    private static final String UNIVERSITY_FILE_PATH = "university.json";

    public static void main(String[] args) {
        Run run = new Run();
        run.createTypicalUniversity();

        // Write university object to JSON file
        run.writeUniversityToJsonFile();

        // Read university object from JSON file
        University university = run.readUniversityFromJsonFile();
        if (university != null) {
            System.out.println("\nUniversity (from JSON file): " + university.getUniversityName());
            System.out.println("Rector: " + university.getRector().getFirstName() + " " + university.getRector().getLastName());
        }

        // Convert university object to JSON text
        String universityJson = run.convertUniversityToJsonText();
        System.out.println("\nUniversity (JSON text):\n" + universityJson);

        // Create university object from JSON text
        University universityFromJson = run.createUniversityFromJsonText(universityJson);
        if (universityFromJson != null) {
            System.out.println("\nUniversity (from JSON text): " + universityFromJson.getUniversityName());
            System.out.println("Rector: " + universityFromJson.getRector().getFirstName() + " " + universityFromJson.getRector().getLastName());
        }
    }


    public Object createTypicalUniversity() {

        Human rector = new Human("John", "Doe", "", Sex.Male);
        University university = new University("NTU Dp", rector);


        Creator<Faculty> createFaculty = new FacultyCreator();
        Creator<Department> createDepartment = new DepartmentCreator();
        Creator<Group> createGroup = new GroupCreator();

        Human dean = new Human("Trent", "Alexander-Arnold", "Genadiyovich", Sex.Female);
        Faculty faculty = createFaculty.create("Programming Engineering", dean);

        Human head = new Human("Mohamed", "Salah", "Olygovich", Sex.Male);
        Department department = createDepartment.create("Software Engineering", head);

        Human groupLeader = new Human("Virgil", "van Dijk", "Vladyslavovich", Sex.Female);
        Group group = createGroup.create("121-20-1", groupLeader);

        System.out.println("University: " + university.getUniversityName());
        System.out.println("Rector: " + university.getRector().getFirstName() + " " + university.getRector().getLastName());
        System.out.println("Faculty: " + faculty.getName());
        System.out.println("Dean: " + faculty.getDean().getFirstName() + " " + faculty.getDean().getLastName());
        System.out.println("Department: " + department.getName());
        System.out.println("Head: " + department.getLeader().getFirstName() + " " + department.getLeader().getLastName());
        System.out.println("Group: " + group.getName());
        System.out.println("Group Leader: " + group.getGroupLeader().getFirstName() + " " + group.getGroupLeader().getLastName());
        return university;
    }
    private void writeUniversityToJsonFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(UNIVERSITY_FILE_PATH))) {
            String json = gson.toJson(createTypicalUniversity());
            writer.write(json);
            System.out.println("\nUniversity written to JSON file: " + UNIVERSITY_FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error writing university to JSON file: " + e.getMessage());
        }
    }

    private University readUniversityFromJsonFile() {
        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new FileReader(UNIVERSITY_FILE_PATH))) {
            University university = gson.fromJson(reader, University.class);
            System.out.println("\nUniversity read from JSON file: " + UNIVERSITY_FILE_PATH);
            return university;
        } catch (IOException e) {
            System.out.println("Error reading university from JSON file: " + e.getMessage());
            return null;
        }
    }

    private String convertUniversityToJsonText() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(createTypicalUniversity());
    }

    private University createUniversityFromJsonText(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, University.class);
    }
}
