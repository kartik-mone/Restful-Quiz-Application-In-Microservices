package com.Microservice.QuizApp.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Microservice.QuizApp.Entity.QuizEntity;

public interface QuizRepository extends JpaRepository<QuizEntity, Integer> {
	
	Optional<QuizEntity> findById(int id);

}
