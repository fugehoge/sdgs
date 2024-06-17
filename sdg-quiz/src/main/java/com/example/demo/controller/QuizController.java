package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Quiz;
import com.example.demo.service.QuizService;

@Controller
public class QuizController {
	@Autowired
	private QuizService quizService;
	
	private Long currentQuizId=1L;
	
	@GetMapping("/quiz")
	public String showQuiz(Model model)
	{
		Quiz quiz = quizService.findById(currentQuizId);
		if(quiz != null)
		{
		    model.addAttribute("quiz",quiz);
		}
		else
		{
			model.addAttribute("message","クイズがありません。");
		}
		return "quiz";
	}
	
	@PostMapping("/quiz")
	public String submitQuiz(@RequestParam Long quizId, @RequestParam String selectedChoice,Model model)
	{
		Quiz quiz = quizService.findById(quizId);
		if(quiz != null)
		{
			if(quiz.getCorrect_option().equals(selectedChoice))
			{
				model.addAttribute("result","correct");
			}
			else
			{
				model.addAttribute("result","incorrect");
			}
		model.addAttribute("quiz",quiz);
		model.addAttribute("explanation",quiz.getExplanation());
		}
		else
		{
			model.addAttribute("message","クイズが見つかりません");
		}
		
		currentQuizId++;
		if(quizService.findById(currentQuizId)==null)
		{
			currentQuizId=1L;
		}
		return "result";
	}
	
		
		

}
