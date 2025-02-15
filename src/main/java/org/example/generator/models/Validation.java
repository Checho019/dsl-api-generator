package org.example.generator.models;

import java.util.List;

public class Validation {
    public String entityName;
    public List<ValidationRule> rules;

    public Validation(String entityName, List<ValidationRule> rules) {
        this.entityName = entityName;
        this.rules = rules;
    }

    @Override
    public String toString() {
        return "{entity='" + entityName + "', rules=" + rules + "}";
    }
}
