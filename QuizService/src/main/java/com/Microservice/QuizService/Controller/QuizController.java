package com.Microservice.QuizService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Microservice.QuizService.Entity.QuestionWrapper;
import com.Microservice.QuizService.Entity.QuizDto;
import com.Microservice.QuizService.Entity.Response_Entity;
import com.Microservice.QuizService.Services.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	
	
	
	// http://localhost:8080/quiz/create?categoryName=python&numQuestions=4&title=PythonQuiz
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quiz_dto){
	    return quizService.createQuiz(quiz_dto.getCategoryName(), quiz_dto.getNumQuestions(), quiz_dto.getTitle());
	}

	
	
	// http://localhost:8080/quiz/get/2
	@GetMapping("get/{id}") 
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions (@PathVariable Integer id){
		return quizService.getQuizQuestions(id);
	}
	
	
	// http://localhost:8080/quiz/submit/1
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response_Entity> responses){
		return quizService.calculateResult(id, responses);
	}
/*
 Note: Always provide input in the same order in which the quiz was randomly generated.
 
 Input: 
 
 [
  {
    "id": 3,
    "response": "false"
  },
  {
    "id": 8,
    "response": "To terminate a loop or switch statement and transfer control to the next statement."
  },
  {
    "id": 2,
    "response": "5"
  },
  {
    "id": 10,
    "response": "ArrayList"
  },
  {
    "id": 5,
    "response": "It indicates that a method can be accessed without creating an instance of the class."
  }
]

 */		

}
