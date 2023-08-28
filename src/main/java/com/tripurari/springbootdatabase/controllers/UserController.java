package com.tripurari.springbootdatabase.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tripurari.springbootdatabase.dto.UserLoginReqDto;
import com.tripurari.springbootdatabase.models.Department;
import com.tripurari.springbootdatabase.models.User;
import com.tripurari.springbootdatabase.services.DepartmentService;
import com.tripurari.springbootdatabase.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;

	}

	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUser();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PostMapping("/createBulkUser")
	public ResponseEntity<String> createBulkUsers(@RequestBody List<User> users) {
		userService.createBulkUsers(users);

		return ResponseEntity.ok("Bulk users saved successfully!");
	}

	@DeleteMapping("/{id}")
	public void delteUser(Long id) {
		userService.deleteUser(id);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> doLogin(@RequestBody UserLoginReqDto loginReqDto) {
		
		if(userService.basicAuthentication(loginReqDto.getEmail(), loginReqDto.getPassword())) {
			return ResponseEntity.ok("User logged in successfully!");
		}
		
		return ResponseEntity.ok("Login failed! Please check the email and password");
		
	}
	
	
//	@PostMapping("/login")
//	public ResponseEntity<String> doLogin() {
//		
//		System.out.println("login");
//		
//		return ResponseEntity.ok("Login failed! Please check the email and password");
//		
//	}
	
	
	
}
