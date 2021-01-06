package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.User;
import com.example.demo.UserRepository;

@Service
public class UserService {

	//Autowire user repo
	@Autowired
	private UserRepository userRepository;
	
	//getAllUsers Method
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//Createuser method
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	//getuserbyid
	public Optional<User> getUser(Long id)
	{
		Optional<User> user = userRepository.findById(id);
		return user;
	}
	
	//update User
	public User updateUserById(Long id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}
	
	//delete user by id
	public void deleteUserById(Long id)
	{
		if (userRepository.findById(id).isPresent())
			userRepository.deleteById(id);
	}
	
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
