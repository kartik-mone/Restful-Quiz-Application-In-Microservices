
#  Quiz Application (Spring Boot + JPA + REST API)

This project is a **Quiz Management System** built using **Spring Boot**, **Spring Data JPA**, and **RESTful APIs**. It allows for managing categories, quizzes, and questions in a modular and scalable backend application. The application is layered into services, controllers, and repositories, adhering to best practices in RESTful service design.

---

##  Features

-  Manage Quiz Categories
-  Add/Update/Delete Questions
-  Create and Manage Quizzes
-  Auto-evaluation and Result Tracking
-  Randomized question selection for quiz attempts
-  RESTful APIs for integration with frontend

---

##  Tech Stack

- **Backend Framework**: Spring Boot
- **ORM**: Spring Data JPA (Hibernate)
- **Database**: MySQL
- **API Architecture**: REST
- **Build Tool**: Maven
- **Language**: Java

---

##  Project Structure

### QuizApp: 

```
QuizApp/
└── src/
└── main/
├── java/
│ └── com.Microservice.QuizApp/
│ ├── Controller/
│ │ ├── QuestionController.java
│ │ └── QuizController.java
│ ├── Entity/
│ │ ├── QuestionEntity.java
│ │ ├── QuestionWrapper.java
│ │ ├── QuizEntity.java
│ │ └── Response_Entity.java
│ ├── Repositories/
│ │ ├── QuestionRepository.java
│ │ └── QuizRepository.java
│ ├── Services/
│ │ ├── QuestionServices.java
│ │ └── QuizService.java
│ └── QuizAppApplication.java
└── resources/
├── application.properties

````
### QuizService: 

```
QuizService/
└── src/
└── main/
├── java/
│ └── com.Microservice.QuizService/
│ ├── Controller/
│ │ └── QuizController.java
│ ├── Entity/
│ │ ├── QuestionEntity.java
│ │ ├── QuestionWrapper.java
│ │ ├── QuizDto.java
│ │ ├── QuizEntity.java
│ │ └── Response_Entity.java
│ ├── Feign/
│ │ └── QuizInterface.java # Feign client to question service
│ ├── Repositories/
│ │ └── QuizRepository.java
│ ├── Services/
│ │ └── QuizService.java
│ └── QuizServiceApplication.java
└── resources/
└── application.properties
```
### QuestionService:

```
QuestionService/
└── src/
└── main/
├── java/
│ └── com.Microservice.QuestionService/
│ ├── Controller/
│ │ └── QuestionController.java
│ ├── Entity/
│ │ ├── QuestionEntity.java
│ │ ├── QuestionWrapper.java
│ │ └── Response_Entity.java
│ ├── Repositories/
│ │ └── QuestionRepository.java
│ └── QuestionServiceApplication.java
└── resources/
└── application.properties
```
---

## Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/kartik-mone/quiz-application.git
   cd quiz-application 
  

2. **Configure MySQL**
   Create a database named `quizdb` and update the following in `application.properties`:

   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/quizdb
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build and Run the Project**

   ```bash
   mvn spring-boot:run
   ```
---

## API Overview

### QuizApp: 

| Endpoint                 | Method | Description                |
| ------------------------ | ------ | -------------------------- |
| `/questions/all`         | GET    | Fetch all questions        |
| `/questions/add`         | POST   | Add a new question         |
| `/questions/update/{id}` | PUT    | Update existing question   |
| `/questions/delete/{id}` | DELETE | Delete question by ID      |
| `/quiz/add`              | POST   | Create new quiz            |
| `/quiz/submit`           | POST   | Submit quiz and get result |
| `/quiz/get/{id}`         | GET    | Get quiz by ID             |
| `/category/add`          | POST   | Add a new category         |
| `/category/all`          | GET    | Fetch all categories       |


###  Quiz

| Endpoint | Method | Description |
|---------|--------|-------------|
| `/quiz/create` | POST | Create quiz with question count and category |
| `/quiz/get/{id}` | GET | Get quiz questions (wrapped) |
| `/quiz/submit` | POST | Submit quiz and get score |

###  Questions

| Endpoint | Method | Description |
|---------|--------|-------------|
| `/question/allQuestions` | GET | Fetch all questions |
| `/question/add` | POST | Add a new question |
| `/question/update/{id}` | PUT | Update question |
| `/question/delete/{id}` | DELETE | Delete question |

---

## Author

**Kartik Mone**


---
