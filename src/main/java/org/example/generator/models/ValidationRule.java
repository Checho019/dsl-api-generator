package org.example.generator.models;

public class ValidationRule {
    public String attribute;
    public String rule;

    public ValidationRule(String attribute, String rule) {
        this.attribute = attribute;
        this.rule = rule;
    }

    @Override
    public String toString() {
        return attribute + " -> " + rule;
    }
}