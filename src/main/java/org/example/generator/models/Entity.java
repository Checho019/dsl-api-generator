package org.example.generator.models;

import java.util.List;

public class Entity {
    private String className;
    private List<Attribute> attributeList;

    public Entity(String className, List<Attribute> attributeList) {
        this.className = className;
        this.attributeList = attributeList;
    }

    public String getClassName() { return className; }
    public List<Attribute> getAttributeList() { return attributeList; }
}
