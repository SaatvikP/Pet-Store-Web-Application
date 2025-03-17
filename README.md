# Pet Store - Spring Boot Application
This is a **Spring Boot-based Pet Store application** that provides a web interface and RESTful APIs for managing pet-related data.

## Features
- 🐶 **Manage pet information**
- 🛂 **Browse available pets**
- 🔒 **User authentication with Spring Security**
- 🖥️ **Web UI built with Thymeleaf**
- 💻 **REST API support**
- 🛆 **Gradle-based build system**

## Getting Started

### 1. Prerequisites
Ensure you have the following installed:
- **Java 21** (or latest supported version)
- **Gradle**
- **Spring Boot**
- **An IDE** (IntelliJ IDEA, VS Code, or Eclipse)

### 2. Clone the Repository
If not already cloned, you can clone the project using:
```sh
git clone <repository-url>
cd pet-store
```

### 3. Build the Project
Run the following command to build the application:
```sh
./gradlew build
```

### 4. Run the Application
Start the application using:
```sh
./gradlew bootRun
```
or, if already built:
```sh
java -jar build/libs/*.jar
```

### 5. Access the Application
Once the application is running, open:
```
http://localhost:8080
```
to access the Pet Store UI.

## API Endpoints
Here are some key endpoints (assuming default Spring Boot settings):

| Method | Endpoint | Description |
|---------|------------|-------------|
| `GET`   | `/pets`   | Get list of all pets |
| `POST`  | `/pets`   | Add a new pet |
| `GET`   | `/pets/{id}` | Get details of a specific pet |
| `PUT`   | `/pets/{id}` | Update pet information |
| `DELETE`| `/pets/{id}` | Delete a pet |

## Technologies Used
- **Java 21** - Core programming language
- **Spring Boot 3.2** - Backend framework
- **Thymeleaf** - Frontend templating
- **Spring Security** - Authentication and security
- **Gradle** - Build and dependency management
- **Embedded Tomcat** - Web server

## Notes
- **Spring Security is enabled**: Default login credentials might be auto-generated.
- **Development mode**: LiveReload is enabled (`port 35729`).
- **Customization**: Edit `application.properties` for configuration changes.

---

