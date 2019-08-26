package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.repository.UserRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	//@Autowired
	//private UserService userService;
	
	// BASIC CRUD -------------------------------------------
    @GetMapping
    public List<User> getAllUsers() {    	
        return userRepository.findAll();
    }
    

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") long id) {
    	Optional<User> opt = userRepository.findById(id);
    	User user = opt.get();
    	System.out.println("User: "+ user.getName());
        return user;
    }
    
    
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping
    public User updateUser( @RequestBody User u) {
        return userRepository.save(u);
    }
    

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable long id) {
    	userRepository.deleteById(id);
    	return "User is deleted successfully";
    }
    // END CRUD ------------------------------------------

    
}
