package com.Microservice.QuizApp.Services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Microservice.QuizApp.Entity.QuestionEntity;
import com.Microservice.QuizApp.Entity.QuestionWrapper;
import com.Microservice.QuizApp.Entity.QuizEntity;
import com.Microservice.QuizApp.Entity.Response_Entity;
import com.Microservice.QuizApp.Repositories.QuestionRepository;
import com.Microservice.QuizApp.Repositories.QuizRepository;


@Service
public class QuizService {
	
	@Autowired
	QuizRepository quizRepository;
	
	@Autowired
    QuestionRepository questionRepository;
	
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
			List<QuestionEntity> questions = questionRepository.findRandomQuestionsByCategory(category, numQ);

			QuizEntity quiz =new QuizEntity();
			quiz.setTitle(title);
			quiz.setQuestions(questions);
			quizRepository.save(quiz);
			
			return new ResponseEntity<String>("Success..!",HttpStatus.CREATED);
		
	}


	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		
		Optional<QuizEntity> quiz = quizRepository.findById(id);
	
		List<QuestionEntity> questionsFromDB = quiz.get().getQuestions();
		List<QuestionWrapper> questionsForUser = new ArrayList<>();
		
		for(QuestionEntity q : questionsFromDB) {
			QuestionWrapper qz = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionsForUser.add(qz);
		}
		
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}


	public ResponseEntity<Integer> calculateResult(int id, List<Response_Entity> responses) {

	    
	    Optional<QuizEntity> quiz = quizRepository.findById(id);  // Fetch the quiz by ID from the repository

	    
	    List<QuestionEntity> questionsFromDB = quiz.get().getQuestions();  // Get the list of questions associated with the quiz

	    int rightanswer = 0;   // Counter for correct answers
	    int i = 0;             // Index to iterate through the list of questions

	    // Loop through each user response
	    for (Response_Entity response : responses) {

	        
	        if (response.getResponse().equals(questionsFromDB.get(i).getRightAnswer())) // Compare the user's response with the correct answer from the DB
	            rightanswer++;  // Increment if correct
	        
	        i++;  // Move to the next question
	    }

	    // Return the total number of correct answers as the result
	    return new ResponseEntity<>(rightanswer, HttpStatus.OK);
	}


}
