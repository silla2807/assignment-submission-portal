
# Assignment Submission Portal

## Overview
This is a Spring Boot backend application designed for managing assignment submissions. It allows users to submit assignments and admins to review and either accept or reject them. MongoDB is used for data storage, and the system follows the MVC architecture.

## Tech Stack
- **Backend:** Java, Spring Boot
- **Database:** MongoDB
- **Architecture:** MVC
- **Dependency Management:** Maven

## Features
1. **User/Admin Registration & Login**
   - Users and admins can register and log in to the system.
   - Users can upload assignments.
  
2. **Assignment Management by Admin**
   - Admins can view all assignments assigned to them.
   - Admins can accept or reject assignments.

## Project Setup
- Use [Spring Initializr](https://start.spring.io/) to create the project with the following dependencies:
  - Spring Web
  - Spring Data MongoDB
  - Lombok (optional)
  - DevTools

- **MongoDB Connection:**  
  Add the following to `application.properties` to connect to the MongoDB database:
  ```properties
  spring.data.mongodb.uri=mongodb://localhost:27017/assignment_db
  ```
  
- **Monitoring Data:**  
  MongoDB Compass was used to monitor data and connections.
  
- **Collections:** users, assignments
  
## Endpoints
- `GET /api/admins`  
  Retrieve a list of all admins
  
- `POST /api/register`  
  Save a new user or admin
  
- `POST /api/login`  
  Log in as a user or admin
  
- `POST /api/upload`  
  Upload an assignment
  
- `GET /api/assignments/{admin}`  
  View all assignments for a specific admin
  
- `POST /api/assignments/{id}/accept`  
  Accept an assignment by ID
  
- `POST /api/assignments/{id}/reject`  
  Reject an assignment by ID

## Other Details
- Error handling is partially implemented using try-catch blocks.
- API testing was performed using Postman/Insomnia.
- IDE used: IntelliJ IDEA
