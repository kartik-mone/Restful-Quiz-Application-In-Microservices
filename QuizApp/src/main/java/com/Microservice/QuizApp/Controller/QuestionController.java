package com.Microservice.QuizApp.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Microservice.QuizApp.Entity.QuestionEntity;
import com.Microservice.QuizApp.Services.QuestionServices;


@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionServices questionServices;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<QuestionEntity>> getAllquestions() {
		
		return questionServices.getAllQuestions();
	}
	
	@GetMapping("category/{category}")
	public List<QuestionEntity> getQuestionsByCategory(@PathVariable String category) {
		return questionServices.getQuestionsByCategory(category);
	}
	
	@PostMapping("/addQuestion")
	public ResponseEntity<String> addQuestion(@RequestBody QuestionEntity question) {
		return questionServices.addQuestion(question);
	}
}
