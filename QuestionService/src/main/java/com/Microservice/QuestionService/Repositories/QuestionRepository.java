package com.Microservice.QuestionService.Repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Microservice.QuestionService.Entity.QuestionEntity;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {
	
	List<QuestionEntity> findBycategory(String category);

	@Query(value = "SELECT q.id FROM quiz_questions q WHERE q.category = :categoryName ORDER BY RAND() LIMIT :numQuestions", nativeQuery = true)
	List<Integer> findRandomQuestionsByCategory(@org.springframework.data.repository.query.Param("categoryName") String categoryName,
	                                            @org.springframework.data.repository.query.Param("numQuestions") Integer numQuestions);

}
