package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String correct_option;
	private String explanation;
	
	//getter
	
	public Long getId()
	{
		return id;
	}
	
	public String getQuestion()
	{
		return question;
	}
	
	public String getOption1()
	{
		return option1;
	}
	
	public String getOption2()
	{
		return option2;
	}
	
	public String getOption3()
	{
		return option3;
	}
	
	public String getCorrect_option()
	{
		return correct_option;
	}
	
	public String getExplanation()
	{
		return explanation;
	}
	
	
	// setter
	
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public void setQuestion(String question)
	{
		this.question = question;
	}
	
	public void setOption1(String option1)
	{
		this.option1 = option1;
	}
	
	public void setOption2(String option2)
	{
		this.option2 = option2;
	}
	
	public void setOption3(String option3)
	{
		this.option3 = option3;
	}
	
	public void setCorrect_option(String correct_option)
	{
		this.correct_option = correct_option;
	}
	
	public void setExplanation(String explanation)
	{
		this.explanation = explanation;
	}

}
