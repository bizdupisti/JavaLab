package Lab3.controller;

import Lab3.model.*;
public class FacultyCreator implements Creator<Faculty> {
    @Override
    public Faculty create(String name, Human header) {
        return new Faculty(name, header);
    }
}
