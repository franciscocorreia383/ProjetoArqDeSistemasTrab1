package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {

		List<User> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {

		User object = service.findById(id);

		return ResponseEntity.ok().body(object);
	}
	
	@PostMapping()
	public ResponseEntity<User> insert(@RequestBody User user){
		
		user = service.insert(user);
		
		return ResponseEntity.ok().body(user);
	}

}