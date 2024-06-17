package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) 
	{
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	public User fidByUsername(String username)
	{
		return userRepository.findByUsername(username);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = userRepository.findByUsername(username);
		if(user == null)
		{
			throw new UsernameNotFoundException("User not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
	}

}
