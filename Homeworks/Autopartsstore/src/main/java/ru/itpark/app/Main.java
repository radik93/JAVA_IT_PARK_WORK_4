package ru.itpark.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itpark.app.models.Role;
import ru.itpark.app.models.State;
import ru.itpark.app.models.User;
import ru.itpark.app.models.newUser;
import ru.itpark.app.repositoris.UsersRepository;

import java.time.LocalDateTime;

@SpringBootApplication
@ComponentScan(basePackages = "ru.itpark")
@EntityScan(basePackages = "ru.itpark.app.models", basePackageClasses = Jsr310JpaConverters.class)
public class Main {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

}