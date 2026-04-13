# Mini Trello Task API

A simple Trello-like task management backend built with Spring Boot.  
This project provides a REST API for creating, listing, updating, and deleting tasks, along with a simple static HTML interface.

## Features

- Create new tasks
- List tasks by status
- Update task status
- Delete tasks
- Simple Swagger/OpenAPI documentation
- Basic static Trello-style HTML page
- Docker support
- Kubernetes deployment file included

## Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Swagger / OpenAPI
- Docker
- Kubernetes / Minikube

## API Endpoints

### Task Controller
- `GET /api/tasks` → List tasks
- `POST /api/tasks` → Create a new task
- `PATCH /api/tasks/{id}/status` → Update task status
- `DELETE /api/tasks/{id}` → Delete a task

### Other Endpoints
- `GET /health` → Health check
- `GET /` → Home endpoint
- `GET /trello.html` → Simple static frontend page

## Running the Project Locally

### 1. Clone the repository

```bash
git clone https://github.com/FurkanCan26/mini-trello-task-api.git
cd mini-trello-task-api
```

### 2. Run the application

On Windows:

```bash
mvnw.cmd spring-boot:run
```

Or with a custom port:

```bash
mvnw.cmd spring-boot:run "-Dspring-boot.run.arguments=--server.port=8081 --server.address=127.0.0.1"
```

## Swagger UI

After starting the application, open:

```text
http://127.0.0.1:8081/swagger-ui/index.html
```

If running on default port:

```text
http://localhost:8080/swagger-ui/index.html
```

## Trello HTML Page

```text
http://127.0.0.1:8081/trello.html
```

## Example Request

### Create a Task

```json
{
  "title": "First task",
  "description": "Mini Trello is running",
  "status": "TODO"
}
```

## Project Structure

- `src/main/java/...` → backend source code
- `src/main/resources/static/trello.html` → static frontend page
- `Dockerfile` → Docker image definition
- `taskapi-deployment.yaml` → Kubernetes deployment file

## Notes

- This project was developed as a small intern-level practice project.
- It focuses on learning backend development, REST APIs, Swagger, Docker, and Kubernetes basics.
- The current version is intended as a functional demo and learning project.

## Future Improvements

- Persistent database support
- Improved frontend UI
- Better validation and error handling
- Full Trello-style drag-and-drop board
- Authentication and user support

## Author

**Furkan Can**
