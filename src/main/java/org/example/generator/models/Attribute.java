package org.example.generator.models;

public class Attribute {
    public String name;
    public String type;

    public Attribute(String name, String type) {
        this.name = name.toLowerCase();
        this.type = type.toLowerCase();
        switch (this.type){
            case "integer":
                this.type = "int";
                break;
            case "string":
                this.type = "String";
                break;
        }
    }

    @Override
    public String toString() {
        return "{ 'nombre': '" + name + "', 'tipo': '" + type + "'}";
    }
}