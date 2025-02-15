package org.example.generator.models;

public class Datasource {
    public String dbms;
    public String ip;
    public String database;
    public String username;
    public String password;

    public Datasource(String dbms, String ip, String database, String username, String password) {
        this.dbms = dbms;
        this.ip = ip;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "{baseDeDatos='" + dbms + "', host='" + ip + "', nombre='" + database + "', usuario='" + username + "', pass='" + password + "', puerto='5432'}";
    }
}
