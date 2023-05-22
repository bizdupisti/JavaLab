package Lab3.controller;

import Lab3.model.*;
public class GroupCreator implements Creator<Group> {
    @Override
    public Group create(String name, Human header) {
        return new Group(name, header);
    }
}
