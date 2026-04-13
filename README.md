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
