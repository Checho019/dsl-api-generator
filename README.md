# Easy API

A Domain-Specific Language for creating a Spring Boot application using a high-level approach.
General Approach:
```
define UserClass as ENTITY {
    name as STRING
    age as INTEGER
}

validations {
    UserClass.name is not null
    UserClass.age is greater than 15
}

define UserRepository as REPOSITORY {
    base-path: /users
    methods: [GET, POST, PUT, DELETE]
}

define UserDTO as DTO with UserClass {
    exclude: [age]
}

define OrderClass as ENTITY {
    orderId as LONG
    user as UserClass
}
```

Some observations: 
- Use standardized data types
- Add a section for entity validations
- Add a section for data source specifications
- Include HTTP verbs in the controller section
- Define DTOs using _exclude_ clause
- Define entity relations
