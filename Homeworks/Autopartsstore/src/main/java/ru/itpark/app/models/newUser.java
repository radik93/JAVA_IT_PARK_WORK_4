package ru.itpark.app.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itpark.app.repositoris.UsersRepository;


public class newUser {

    @Autowired
    UsersRepository usersRepository;
    //@Autowired
    //private PasswordEncoder passwordEncoder;

    public void newser()
    {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("123");

       User newUser = User.builder()
                .login("Administrator")
                .state(State.CONFIRMED)
                //.role(Role.ADMIN)
                .hashPassword(hashedPassword)
                .build();
        System.out.println(newUser.getHashPassword());
        usersRepository.save(newUser);
    }
}
