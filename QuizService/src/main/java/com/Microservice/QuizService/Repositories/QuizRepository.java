package com.Microservice.QuizService.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Microservice.QuizService.Entity.QuizEntity;

public interface QuizRepository extends JpaRepository<QuizEntity, Integer> {
	
	Optional<QuizEntity> findById(int id);

}
