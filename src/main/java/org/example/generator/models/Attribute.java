package org.example.generator.models;

public class Attribute {
    private String attName;
    private String attType;

    public Attribute(String attName, String attType) {
        this.attName = attName;
        this.attType = attType;
    }

    public String getName() { return attName; }
    public String getType() { return attType; }
}