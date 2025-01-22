# Easy API

A Domain-Specific Language for creating a Spring Boot application using a high-level approach.
General Approach:
```
DEFINE User AS ENTITY {
    user_id AS INTEGER,
    name AS STRING,
    age AS INTEGER
}

DEFINE Pet AS ENTITY {
    pet_id AS INTEGER,
    name AS STRING,
    animal AS STRING
}

DEFINE RELATIONSHIP User TO Pet IS ONE_TO_MANY

DEFINE VALIDATIONS FOR User {
    user_id IS ID,
    name IS NOT NULL,
    age IS GREATER_THAN 15
}

DEFINE VALIDATIONS FOR Pet {
    pet_id IS ID,
    name IS NOT NULL,
    animal IS NOT NULL
}

DEFINE CONTROLLER FOR User {
    PATH: "/users",
    METHODS: [GET, POST, PUT, DELETE]
}

DEFINE CONTROLLER FOR Pet {
    PATH: "/pets",
    METHODS: [GET, POST, DELETE]
}

CONFIGURE DATASOURCE {
    URL: "jdbc:mysql://localhost:3306/mydb",
    USERNAME: "root",
    PASSWORD: "password",
    DRIVER: "com.mysql.cj.jdbc.Driver"
}
```

Some observations: 
- Use standardized data types
- Add a section for entity validations
- Add a section for data source specifications
- Include HTTP verbs in the controller section
- Define entity relations

Libraries:
- JFlex v1.9.1
- JCup v11b-20160615

Change Variable Regex "\b"
