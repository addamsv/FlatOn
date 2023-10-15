package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@PostMapping
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	@DeleteMapping(path = "{userId}")
	public void dellUser(@PathVariable("userId") Long id) {
		userService.dellUser(id);
	}
}
