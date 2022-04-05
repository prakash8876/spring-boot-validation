package com.demp.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demp.app.dto.UserRequest;
import com.demp.app.entity.User;
import com.demp.app.exception.UserNotFoundException;
import com.demp.app.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	private UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@PostMapping(value = "/signup")
	public ResponseEntity<User> saveNewUser(@RequestBody @Valid UserRequest request) {
		return new ResponseEntity<User>(service.saveUser(request), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> fetchAll() {
		return ResponseEntity.ok(service.fetchAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> fetchById(@PathVariable int id) throws UserNotFoundException {
		return ResponseEntity.ok(service.fetchById(id));
	}
}
