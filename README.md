# Easy API

A Domain-Specific Language for creating a Spring Boot application using a high-level approach.
General Approach:
```
DEFINE User AS ENTITY {
    name AS STRING,
    age AS INTEGER,
}

DEFINE VALIDATIONS FOR User {
    name IS NOT NULL,
    age IS GREATER_THAN 15
}

DEFINE CONTROLLER FOR User {
    PATH: "/users",
    METHODS: [GET, POST, PUT, DELETE]
}

DEFINE UserDTO AS DTO WITH User {
    EXCLUDE: [age]
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
- Define DTOs using _exclude_ clause
- Define entity relations
