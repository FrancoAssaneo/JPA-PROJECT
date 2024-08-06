# JPA Project POC

Este proyecto es una prueba de concepto para demostrar el uso de JPA (Java Persistence API) con Spring Boot. El proyecto incluye entidades relacionadas, DTOs (Data Transfer Objects), servicios y controladores para manejar usuarios, departamentos y edificios.

## Estructura del Proyecto

- **Entities**: User, Department, Building
- **DTOs**: UserDTO, DepartmentDTO, BuildingDTO
- **Repositories**: UserRepository, DepartmentRepository, BuildingRepository
- **Services**: UserService, DepartmentService, BuildingService
- **Controllers**: UserController, DepartmentController, BuildingController

## Requisitos

- Java 14
- Spring Boot 2.6.6
- MySQL
- Maven o Gradle

## Endpoints

### User Endpoints

1. **Crear un nuevo usuario**
    - **Endpoint**: `POST /users`
    - **Request Body**:
      ```json
      {
          "name": "John Doe",
          "email": "john.doe@example.com",
          "departmentId": 1
      }
      ```
    - **Response**:
      ```json
      {
          "id": 1,
          "name": "John Doe",
          "email": "john.doe@example.com",
          "departmentId": 1
      }
      ```

2. **Obtener todos los usuarios**
    - **Endpoint**: `GET /users`
    - **Response**:
      ```json
      [
          {
              "id": 1,
              "name": "John Doe",
              "email": "john.doe@example.com",
              "departmentId": 1
          }
      ]
      ```

3. **Obtener un usuario por ID**
    - **Endpoint**: `GET /users/{id}`
    - **Response**:
      ```json
      {
          "id": 1,
          "name": "John Doe",
          "email": "john.doe@example.com",
          "departmentId": 1
      }
      ```

4. **Actualizar un usuario**
    - **Endpoint**: `PUT /users/{id}`
    - **Request Body**:
      ```json
      {
          "name": "Jane Doe",
          "email": "jane.doe@example.com",
          "departmentId": 2
      }
      ```
    - **Response**:
      ```json
      {
          "id": 1,
          "name": "Jane Doe",
          "email": "jane.doe@example.com",
          "departmentId": 2
      }
      ```

5. **Eliminar un usuario**
    - **Endpoint**: `DELETE /users/{id}`

### Department Endpoints

1. **Crear un nuevo departamento**
    - **Endpoint**: `POST /departments`
    - **Request Body**:
      ```json
      {
          "doorNumber": "101A",
          "floor": "1",
          "buildingId": 1
      }
      ```
    - **Response**:
      ```json
      {
          "id": 1,
          "doorNumber": "101A",
          "floor": "1",
          "buildingId": 1
      }
      ```

2. **Obtener todos los departamentos**
    - **Endpoint**: `GET /departments`
    - **Response**:
      ```json
      [
          {
              "id": 1,
              "doorNumber": "101A",
              "floor": "1",
              "buildingId": 1 
          }
      ]
      ```

3. **Obtener un departamento por ID**
    - **Endpoint**: `GET /departments/{id}`
    - **Response**:
      ```json
      {
          "id": 1,
          "doorNumber": "101A",
          "floor": "1",
          "buildingId": 1
      }
      ```

4. **Actualizar un departamento**
    - **Endpoint**: `PUT /departments/{id}`
    - **Request Body**:
      ```json
      {
          "doorNumber": "202B",
          "floor": "2",
          "buildingId": 2
      }
      ```
    - **Response**:
      ```json
      {
          "id": 1,
          "doorNumber": "202B",
          "floor": "2",
          "buildingId": 2 
      }
      ```

5. **Eliminar un departamento**
    - **Endpoint**: `DELETE /departments/{id}`

6. **Buscar departamentos por piso**
    - **Endpoint**: `GET /departments/floor/{floor}`
    - **Response**:
      ```json
      [
          {
              "id": 1,
              "doorNumber": "101A",
              "floor": "1",
              "buildingId": 1 
          }
      ]
      ```


### Building Endpoints

1. **Crear un nuevo edificio**
    - **Endpoint**: `POST /buildings`
    - **Request Body**:
      ```json
      {
          "name": "Building 1",
          "address": "123 Main St",
          "departmentIds": [1, 2]
      }
      ```
    - **Response**:
      ```json
      {
          "id": 1,
          "name": "Building 1",
          "address": "123 Main St",
          "departmentsIds": [
              1,
              2,
              3   
          ]
      }
      ```

2. **Obtener todos los edificios**
    - **Endpoint**: `GET /buildings`
    - **Response**:
      ```json
      [
          {
              "id": 1,
              "name": "Building 1",
              "address": "123 Main St",
              "departments": [
                  {
                      "id": 1,
                      "doorNumber": "101A",
                      "floor": "1"
                  },
                  {
                      "id": 2,
                      "doorNumber": "202B",
                      "floor": "2"
                  }
              ]
          }
      ]
      ```

3. **Obtener un edificio por ID**
    - **Endpoint**: `GET /buildings/{id}`
    - **Response**:
      ```json
      {
          "id": 1,
          "name": "Building 1",
          "address": "123 Main St",
          "departments": [
              {
                  "id": 1,
                  "doorNumber": "101A",
                  "floor": "1"
              },
              {
                  "id": 2,
                  "doorNumber": "202B",
                  "floor": "2"
              }
          ]
      }
      ```

4. **Actualizar un edificio**
    - **Endpoint**: `PUT /buildings/{id}`
    - **Request Body**:
      ```json
      {
          "name": "Building 2",
          "address": "456 Main St",
          "departmentIds": [3, 4]
      }
      ```
    - **Response**:
      ```json
      {
          "id": 1,
          "name": "Building 2",
          "address": "456 Main St",
          "departments": [
              {
                  "id": 3,
                  "doorNumber": "303C",
                  "floor": "3"
              },
              {
                  "id": 4,
                  "doorNumber": "404D",
                  "floor": "4"
              }
          ]
      }
      ```

5. **Eliminar un edificio**
    - **Endpoint**: `DELETE /buildings/{id}`

## Funcionalidades de JPA Implementadas

- Relaciones @OneToMany y @ManyToOne
- Uso de DTOs para transferencia de datos
- Consultas personalizadas utilizando métodos de repositorio
- Mapeo automático de entidades a DTOs y viceversa

## Cómo Ejecutar el Proyecto

1. Clonar el repositorio:
    ```sh
    git clone https://github.com/FrancoAssaneo/jpaproject.git
    cd jpaproject
    ```

2. Configurar la base de datos en el archivo `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/jpa_project
    spring.datasource.username=root
    spring.datasource.password=password
    spring.jpa.hibernate.ddl-auto=update
    ```

3. Ejecutar la aplicación:
    ```sh
    ./mvnw spring-boot:run
    ```

4. Acceder a los endpoints a través de Postman o cualquier cliente REST.
