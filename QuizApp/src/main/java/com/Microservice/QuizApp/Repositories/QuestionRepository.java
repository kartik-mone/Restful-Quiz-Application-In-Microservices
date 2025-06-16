package com.Microservice.QuizApp.Repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Microservice.QuizApp.Entity.QuestionEntity;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Integer> {
	
	List<QuestionEntity> findBycategory(String category);

	@Query(value = "SELECT * FROM quiz_questions q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
	List<QuestionEntity> findRandomQuestionsByCategory(String category, int numQ);
}
