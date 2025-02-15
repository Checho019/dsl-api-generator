package org.example.generator.models;

import java.util.List;

public class Entity {
    public String name;
    public List<Attribute> attributes;

    public Entity(String name, List<Attribute> attributes) {
        this.name = name.toLowerCase();
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "{'nombreClase':'" + name.substring(0, 1).toUpperCase() + name.substring(1) + "', 'ncl':'" + name + "' , 'atributos':" + attributes + "}";
    }
}
