package com.Microservice.QuestionService.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Microservice.QuestionService.Entity.QuestionEntity;
import com.Microservice.QuestionService.Entity.QuestionWrapper;
import com.Microservice.QuestionService.Entity.Response_Entity;
import com.Microservice.QuestionService.Repositories.QuestionRepository;

@Service
public class QueServices {

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




	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
		List<Integer> questions = questionRepository.findRandomQuestionsByCategory(categoryName, numQuestions);
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}




	public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(List<Integer> questionIds) {
		 List<QuestionWrapper> wrapper = new ArrayList<>();
		 List<QuestionEntity> questions = new ArrayList<>();
		 
		 for(Integer id : questionIds) {
			questions.add(questionRepository.findById(id).get());
		 }
		 
		 for(QuestionEntity question: questions) {
			 QuestionWrapper wrapper_obj = new QuestionWrapper();
			 wrapper_obj.setId(question.getId());
			 wrapper_obj.setQuestionTitle(question.getQuestionTitle());
			 wrapper_obj.setOption1(question.getOption1());
			 wrapper_obj.setOption2(question.getOption2());
			 wrapper_obj.setOption3(question.getOption3());
			 wrapper_obj.setOption4(question.getOption4());
			 
			 wrapper.add(wrapper_obj);
		 }
		 
		 return new ResponseEntity<>(wrapper, HttpStatus.OK);
	}


	public ResponseEntity<Integer> getScore(List<Response_Entity> response) {
		
			    int rightanswer = 0;   
		
			    for (Response_Entity response_obj : response) {
		
			        QuestionEntity question = questionRepository.findById(response_obj.getId()).get();
			        if (response_obj.getResponse().equals(question.getRightAnswer())) 
			            rightanswer++; 
			        
			    }
	
			    return new ResponseEntity<>(rightanswer, HttpStatus.OK);
			}
			


}
