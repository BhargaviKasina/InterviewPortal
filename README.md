# Interview Portal

## Project Description
Interview Portal is a Spring Boot application that allows users to register, log in, manage questions, create quizzes, submit quizzes, and calculate scores automatically.

## Technologies Used
- Java
- Spring Boot
- MySQL
- Spring Data JPA
- Maven
- Postman

## Features
- User Registration
- User Login
- Add Question
- View Questions
- Update Question
- Delete Question
- Create Quiz
- Add Questions to Quiz
- Submit Quiz
- Automatic Score Calculation

## API Endpoints

### User APIs
POST /register
POST /login

### Question APIs
POST /questions/add
GET /questions/all
PUT /questions/{id}
DELETE /questions/{id}

### Quiz APIs
POST /quiz/create
GET /quiz/all
GET /quiz/{id}
POST /quiz/{quizId}/question/{questionId}
POST /quiz/{quizId}/submit
DELETE /quiz/{id}

## Author
Bhargavi Kasina
