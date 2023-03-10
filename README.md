# EY Excercise

## Requested Requirements.

Desarrolle una aplicación que exponga una API RESTful de creación de usuarios.
Todos los endpoints deben aceptar y retornar solamente JSON, inclusive al para los mensajes de error.
Todos los mensajes deben seguir el formato:
{"mensaje": "mensaje de error"}

## Registro

- Ese endpoint deberá recibir un usuario con los campos "nombre", "correo", "contraseña", más
un listado de objetos "teléfono", respetando el siguiente formato:

        {
        "name": "Juan Rodriguez",
        "email": "juan@rodriguez.org",
        "password": "hunter2",
        "phones": [
        {
        "number": "1234567",
        "citycode": "1",
        "contrycode": "57"
        }
        ]
        }

- Responder el código de status HTTP adecuado
- En caso de éxito, retorne el usuario y los siguientes campos:
- id: id del usuario (puede ser lo que se genera por el banco de datos, pero sería más
deseable un UUID)
- created: fecha de creación del usuario
- modified: fecha de la última actualización de usuario
- last_login: del último ingreso (en caso de nuevo usuario, va a coincidir con la fecha
de creación)
- token: token de acceso de la API (puede ser UUID o JWT)
- isactive: Indica si el usuario sigue habilitado dentro del sistema.
- Si caso el correo conste en la base de datos, deberá retornar un error "El correo ya
registrado".
- El correo debe seguir una expresión regular para validar que formato sea el correcto.
(aaaaaaa@dominio.cl)
- La clave debe seguir una expresión regular para validar que formato sea el correcto. (Una
Mayuscula, letras minúsculas, y dos números)
- Se debe hacer traza de logs dentro del aplicativo.
- El token deberá ser persistido junto con el usuario


## Mandatory:

- Banco de datos en memoria.
- Gradle como herramienta de construcción.
- Pruebas unitarias (Deseable: Spock Framework).
- Persistencia con Hibernate.
- Framework Spring Boot.
- Java 8 o superior. (Usar más de dos características propias de la versión)
- Entrega en un repositorio público (github, gitlab o bitbucket) con el código fuente.
- Entregar diagrama de componentes de la solución y al menos un diagrama de secuencia
(ambos diagramas son de carácter obligatorio y deben seguir estándares UML).
- README.md debe contener las instrucciones para levantar y usar el proyecto.

## Desirable
- JWT cómo token

# What does the repository contain?

  - h2 memory database.
  - Test Unit with Junit.
  - Java version 8.
  - Api Rest findUserByEmail response the requeriment.
  - Token JWT and user persistence during the session.
  - All project have diversity of syntax for old and new java code.
  

# Extra :

  - Bcrypt for password and token.
  - JWT.
  - Handler Exception with Controller Advice.
  - 4 Api Rest to formalice requirement with standards.
  - Rename field contrycode to country_code , for typing error.
  - Rename field citycode to city_code , for typing error.
  - Collection, Enviroment for Postman with all api rest and persistent token in directory repository-exercise-one-globallogic-cl\src\main\resources\postman.
  - Banner Console.

### Before starting

### Dependencies

Considerate use this versión.

| Dependency | Version |
| ------ | ------ |
| IntelliJ IDEA | 1.8.0_152 |
| Gradle | 4.10.3|
| H2 | 2.4.1 |
| Java JDK  | 1.8 |
| Postman  | 7.18.0 |
| Windows | 10 |

### Api Rest 

### Common Validations
-   Empty
-   Null

| Api Rest | Method | Protected | Validations | Request | Response |
| ------ | ------ | ------ | ------ | ------ | ------ |
| /v1/unprotected/doSignIn | POST| false | format email,format password,check user exist email, email and password coincidence|{"name":"FirstNameExample LastNameExample","email":"email@example.com","password":"Passwordexampler12","phones":[{"number":"946644558","city_code":"1","country_code":"57"}]} | {"id":1,"created":"16-02-2020 22:34:26","modified":"16-02-2020 22:35:07","last_login":"16-02-2020 22:35:07","token":"eyJhbGciOiJIUzI1NiJ9","active":true}
| /v1/protected/doSignOut | POST | false |  token experiration in seconds and token destroy logout | none |{"message":"Success logout, have a great day."}
| /v1/protected/getUsers | GET | true |  token experiration in seconds, token destroy logout, user roles| none | {"id":1,"name":"FirstNameExample LastNameExample","email":"email@example.com","password":"$2a$16$gSv/X20v2iC39eVKrkVfSeM3Ky4PFY3Ww/pOMd7nlYsS8/OnUVsJ6","phones":[{"number":"946644558","city_code":"1","country_code":"57"}],"created":"16-02-2020 22:34:26","modified":"16-02-2020 22:35:07","last_login":"16-02-2020 22:35:07","token":"eyJhbGciOiJIUzI1NiJ9","roles":["ROLE_ADMIN","ROLE_USER"],"active":true}
| /v1/protected/findUserByEmail |GET | true | token experiration in seconds, token destroy logout, user roles , format email, check email exist |{"email":"email@example.com"} | {"id":1,"created":"16-02-2020 22:34:26","modified":"16-02-2020 22:35:07","last_login":"16-02-2020 22:35:07","token":"eyJhbGciOiJIUzI1NiJ9","active":true}


### Installation

- Install the dependencies.
- Import project into your IDE.
- Run test and bootrun gradle to the project.
- Import collection and enviroment to your postman locate in directory repository-exercise-one-globallogic-cl\src\main\resources\postman
- Now test all endpoint.

### Authors

 - Luciano Pantillon

License
----

MIT
