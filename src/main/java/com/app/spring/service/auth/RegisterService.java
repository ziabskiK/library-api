package com.app.spring.service.auth;

import com.app.spring.exception.UserExistsInDatabaseException;
import com.app.spring.model.book.user.User;
import com.app.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {


    private final UserRepository userRepository;

    @Autowired
    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(User user) throws UserExistsInDatabaseException {

        if (userRepository.findUserByEmail(user.getEmail()) == null) {

            user.setPassword(encoder().encode(user.getPassword()));
            userRepository.save(user);
            return "Success!";
        }

        throw new UserExistsInDatabaseException();

    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
