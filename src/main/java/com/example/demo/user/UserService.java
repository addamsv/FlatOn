package com.example.demo.user;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
			throw new IllegalStateException("email is already taken");
		}

		userRepository.save(user);

		System.out.println(user);
	}

	public void dellUser(Long userId) {
		boolean isUserCandidateExist = userRepository.existsById(userId);

		if (!isUserCandidateExist) {
			throw new IllegalStateException("user does not exist");
		}

		userRepository.deleteById(userId);
	}

	@Transactional
	public void updateUser(Long userId, String name, String email) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new IllegalStateException("user does not exist"));

		if (
				name != null &&
                !name.isEmpty() &&
				!Objects.equals(user.getName(), name)
		) {
			user.setName(name);
		}

		if (
				email != null &&
                !email.isEmpty() &&
				!Objects.equals(user.getEmail(), email)
		) {

			Optional<User> userCandidate = userRepository.findUserByEmail(email);

			if (userCandidate.isPresent()) {
				throw new IllegalStateException("email is already taken");
			}

			user.setEmail(email);
		}
	}
}
