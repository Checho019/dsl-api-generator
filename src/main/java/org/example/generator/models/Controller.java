package org.example.generator.models;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public String entityName;
    public List<String> actions;

    public Controller(String entityName, List<String> actions) {
        this.entityName = entityName;
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "{entity='" + entityName + "', actions=" + actions + "}";
    }
}