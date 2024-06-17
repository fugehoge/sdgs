package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Quiz;
import com.example.demo.repository.QuizRepository;

@Service
public class QuizService {
	
	@Autowired
	private QuizRepository quizRepository;
	
	
	public List<Quiz> findAll()
	{
		return quizRepository.findAll();
	}

	public Quiz save(Quiz quiz)
	{
		return quizRepository.save(quiz);
	}
	
	public Quiz findById(Long id)
	{
		return quizRepository.findById(id).orElse(null);
	}
}
