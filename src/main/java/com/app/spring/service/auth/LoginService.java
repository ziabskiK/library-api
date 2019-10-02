package com.app.spring.service.auth;


import com.app.spring.exception.IncorrectRequestException;
import com.app.spring.model.user.User;
import com.app.spring.repository.UserRepository;
import com.app.spring.service.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepository repository;

    private final PasswordEncoder encoder;

    @Autowired
    public LoginService(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public String login(User user) throws IncorrectRequestException {

        //Check if user is in db
        if (repository.findUserByEmail(user.getEmail()) != null) {
            User userFromDb = repository.findUserByEmail(user.getEmail());


            //return token
            if (encoder.matches(user.getPassword(), userFromDb.getPassword())) {
                return TokenService.createToken(userFromDb.getId(), user.getPassword(), userFromDb.getRole(), userFromDb.getFirstName(), userFromDb.getLastName(), userFromDb.getEmail());
            }


        }

        throw new IncorrectRequestException();


    }


}
