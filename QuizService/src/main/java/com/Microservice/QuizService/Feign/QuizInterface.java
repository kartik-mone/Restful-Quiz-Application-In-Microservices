package com.Microservice.QuizService.Feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Microservice.QuizService.Entity.QuestionWrapper;
import com.Microservice.QuizService.Entity.Response_Entity;

@FeignClient("QUESTIONSERVICE") // In brackets write which the service name you want to connect to
public interface QuizInterface {
	
	@GetMapping("question/generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestions);
	
	
	// http://localhost:8082/question/getQuestions 
	// Input: [5,6,7,8]
	@PostMapping("question/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionIds);
	
	
	// http://localhost:8082/question/getScore
	
	@PostMapping("question/getScore")
	public ResponseEntity<Integer> getScroe(@RequestBody List<Response_Entity> response);
	
	
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



