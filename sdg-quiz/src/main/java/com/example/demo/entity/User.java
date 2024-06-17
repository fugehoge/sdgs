package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String password;
	private String email;
	
	// getter
	public Long getId()
	{
		return id;
	}
	
    public String getUsername() 
    {
        return username;
    }

    public String getPassword() 
    {
        return password;
    }
    
    public String getEmail()
    {
    	return email;
    }
    
    // setter
    
    public void setId(Long id)
    {
    	this.id=id;
    }
    
    public void setUsername(String username)
    {
    	this.username = username;
    }
    
    public void setPassword(String password)
    {
    	this.password = password;
    }
    
    public void setEmail(String email)
    {
    	this.email = email; 
    }

}
