package com.Microservice.QuizApp.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Microservice.QuizApp.Entity.QuestionEntity;
import com.Microservice.QuizApp.Repositories.QuestionRepository;

@Service
public class QuestionServices {

    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<List<QuestionEntity>> getAllQuestions() {
    	
    	// Using ResponseEntity and HttpStatus to handle HTTP responses and server-side exceptions
    	
    	try {
    		return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);  // Return all questions with 200 OK
    	}
    	catch(Exception e) {
    		e.printStackTrace(); // Handle Exception
    	}
    	return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST); // Return empty list with 400 Bad Request
    }

    
    
    
	public List<QuestionEntity> getQuestionsByCategory(String category) {
		return questionRepository.findBycategory(category);                // category wise finding a Questions
	}

	
	
	
	public ResponseEntity<String> addQuestion(QuestionEntity question) {
		questionRepository.save(question);                 // Inserting a Question
		return new ResponseEntity<>("Successfully add Question..!", HttpStatus.CREATED);
	}
}
