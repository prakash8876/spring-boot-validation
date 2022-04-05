package com.demp.app.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demp.app.dto.UserRequest;
import com.demp.app.entity.User;
import com.demp.app.exception.UserNotFoundException;
import com.demp.app.repo.UserRepository;

@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	private UserRepository repo;

	@Autowired
	public UserService(UserRepository repo) {
		this.repo = repo;
	}

	public User saveUser(UserRequest request) {
		User user = User.build(0, request.getName(), request.getAge(), request.getMobileNo(), request.getEmail(),
				request.getGender(), request.getNationality());
		log.info("Saving user: {}", user);
		return repo.save(user);
	}

	public List<User> fetchAll() {
		log.info("Fetching all users");
		return repo.findAll();
	}

	public User fetchById(int id) {
		Optional<User> user = repo.findById(id);
		log.info("Fetching user of id: {}", id);
		return user
				.orElseThrow(() -> 
				new UserNotFoundException("User not found for id: " + id));
	}
}
