# Leave Management System

A secure Leave Management REST API built using Spring Boot.

## Features
- Employee Registration & Login
- JWT Authentication
- Role-Based Authorization
- Apply Leave
- Approve / Reject Leave
- BCrypt Password Encryption
- Swagger API Documentation

## Technologies Used
- Java
- Spring Boot
- Spring Security
- JWT
- MySQL
- Maven
- Postman

## API Endpoints

### Authentication
- POST /api/auth/register
- POST /api/auth/login

### Leave APIs
- POST /api/leaves/apply
- GET /api/leaves/pending
- PUT /api/leaves/approve/{id}
- PUT /api/leaves/reject/{id}

## Security
- JWT Token Authentication
- Role Based Access (MANAGER / EMPLOYEE)


