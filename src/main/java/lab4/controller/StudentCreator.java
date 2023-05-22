package lab4.controller;

import lab4.model.*;
public class StudentCreator implements Creator<Student> {
    @Override
    public Student create(String name, Human header) {
        return new Student(name, header.getFirstName(), header.getLastName(), header.getSurname(), header.getGender());
    }
}
