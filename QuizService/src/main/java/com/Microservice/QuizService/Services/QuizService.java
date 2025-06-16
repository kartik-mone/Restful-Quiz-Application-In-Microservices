package com.Microservice.QuizService.Services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Microservice.QuizService.Entity.QuestionWrapper;
import com.Microservice.QuizService.Entity.QuizEntity;
import com.Microservice.QuizService.Entity.Response_Entity;
import com.Microservice.QuizService.Feign.QuizInterface;
import com.Microservice.QuizService.Repositories.QuizRepository;


@Service
public class QuizService {
	
	@Autowired
	QuizRepository quizRepository;
	
	@Autowired
	QuizInterface quiz_interface;
	
	
// For Creating a Question's.
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

		// OpenFeign Dependency - Instead of manually handling IP addresses and port numbers, you just specify the service name you want to connect to, and Feign will handle the connection for you.

		
	    // Step 1: Call Question Service (via Feign client) to fetch random question IDs for the given category
	    List<Integer> questions = quiz_interface.getQuestionsForQuiz(category, numQ).getBody(); 

	    // Step 2: Create a new QuizEntity and set its title and list of question IDs
	    QuizEntity quiz = new QuizEntity();
	    quiz.setTitle(title);
	    quiz.setQuestionIds(questions);

	    // Step 3: Save the quiz into the database
	    quizRepository.save(quiz);

	    // Step 4: Return a success response with HTTP 201 (Created) status
	    return new ResponseEntity<String>("Success..!", HttpStatus.CREATED);
	}


// For Extracting the Question's with Options.
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
	    
	    // Step 1: Fetch the QuizEntity object from the database using the quiz ID.
	    QuizEntity quiz = quizRepository.findById(id).get(); // May throw NoSuchElementException if ID not found

	    
	    // Step 2: Extract the list of question IDs associated with this quiz.
	    List<Integer> questionIds = quiz.getQuestionIds();

	    
	    // Step 3: Use Feign client to call the Question Service and get full question details for those IDs.
	    ResponseEntity<List<QuestionWrapper>> questionsFromDB = quiz_interface.getQuestionFromId(questionIds);

	    
	    // Step 4: Return the list of question wrappers (title + options, but no correct answer).
	    return questionsFromDB;
	}



	public ResponseEntity<Integer> calculateResult(int id, List<Response_Entity> responses) {
		
		ResponseEntity<Integer> score = quiz_interface.getScroe(responses);
		
		return score;

	}


}
