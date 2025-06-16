package com.Microservice.QuestionService.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Microservice.QuestionService.Entity.QuestionEntity;
import com.Microservice.QuestionService.Entity.QuestionWrapper;
import com.Microservice.QuestionService.Entity.Response_Entity;
import com.Microservice.QuestionService.Services.QueServices;


@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QueServices questionServices;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<QuestionEntity>> getAllquestions() {
		
		return questionServices.getAllQuestions();
	}
	
	@GetMapping("category/{category}")
	public List<QuestionEntity> getQuestionsByCategory(@PathVariable String category) {
		return questionServices.getQuestionsByCategory(category);
	}
	
	@PostMapping("addQuestion")
	public ResponseEntity<String> addQuestion(@RequestBody QuestionEntity question) {
		return questionServices.addQuestion(question);
	}
	
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestions){
		return questionServices.getQuestionsForQuiz(categoryName, numQuestions);
	}
	
	
	// http://localhost:8082/question/getQuestions 
	// Input: [5,6,7,8]
	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionIds){
		return questionServices.getQuestionFromId(questionIds);
	}
	
	
	// http://localhost:8082/question/getScore
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScroe(@RequestBody List<Response_Entity> response){
		return questionServices.getScore(response);
	}
	// Input: 
/*	 [
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
	    "id": 12,
	    "response": "[1, 2, 3]"
	  },
	  {
	    "id": 5,
	    "response": "It indicates that a method can be accessed without creating an instance of the class."
	  }
	] 
*/
}
