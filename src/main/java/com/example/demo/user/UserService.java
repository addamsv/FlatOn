package com.example.demo.user;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // the same @Component
public class UserService {
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	//	List.of(new User(1L, "Serg", "a@a.a"))
	public List<User> getUsers() { return userRepository.findAll(); }
	
}
