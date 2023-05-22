package Lab3.controller;

import Lab3.model.*;
public interface Creator<T> {
    T create(String name, Human header);
}
