package com.example.demo.user;
import java.util.List;
import java.util.Optional;

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
		Optional<User> userCandidate = userRepository.findUserByEmail(user.getEmail());

		if (userCandidate.isPresent()) {
			throw new IllegalStateException("email already taken");
		}

		userRepository.save(user);

		System.out.println(user);
	}

	public void dellUser(Long userId) {
		boolean isUserCandidateExist = userRepository.existsById(userId);

		if (!isUserCandidateExist) {
			throw new IllegalStateException("user does not  exist");
		}

		userRepository.deleteById(userId);
	}
}
