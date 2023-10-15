package com.example.demo.user;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // the same @Component
public class UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getUsers() { return userRepository.findAll(); }

	public void addUser(User user) {
		System.out.println(user);
//		userRepository.();
	}

}
