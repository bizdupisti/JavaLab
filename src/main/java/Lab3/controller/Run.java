package Lab3.controller;

import Lab3.model.*;
public class Run {
    public static void main(String[] args) {
        Run run = new Run();
        run.createTypicalUniversity();
    }

    public void createTypicalUniversity() {

        Human rector = new Human("Michle", "Owen", "Maksimovich", Sex.Male);
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
    }
}
