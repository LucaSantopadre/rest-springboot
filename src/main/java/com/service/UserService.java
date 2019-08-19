package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.*;
import com.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repository;
	
	public List<User> getUsers(){
		List<User> lista = repository.findAll();
		for (User user : lista) {
			System.out.println("user ..... " + user.getName());
		}
		return repository.findAll();
	}
}
