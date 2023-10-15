package com.example.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User sergey = new User(
                    "Sergey",
                    "a@a.a"
            );

            User alexandr = new User(
                    "Alex",
                    "a@a.a"
            );

            userRepository.saveAll(List.of(sergey, alexandr));
        };
    }
}
