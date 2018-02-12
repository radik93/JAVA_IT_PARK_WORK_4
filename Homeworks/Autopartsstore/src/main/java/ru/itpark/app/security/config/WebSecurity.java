package ru.itpark.app.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

// Класс, который содержит конфигурацию безопасности приложения
@EnableWebSecurity
@ComponentScan(basePackages = "ru.itpark")
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    // основной метод для конфигурирования доступов
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index/**").permitAll() // разрешили страницу  всем
                .antMatchers("/carmodels/**").permitAll()
                .antMatchers("/cars/**").permitAll()
                .antMatchers("/contact/**").permitAll()
                .antMatchers("/topMeny/**").permitAll()
                .antMatchers("/singIn/**").permitAll()
                .antMatchers("/css/**").permitAll()// разрешить css
                .anyRequest().authenticated() // все остальные страницы запретили
                .and()
                .formLogin()
                .loginPage("/signIn")// сказали, какая страница будет странцией авторизации
                .usernameParameter("login") // что является параметром username
                .passwordParameter("password")
                .defaultSuccessUrl("/addnewcar") // на какую страницу следует выполнить переадресацию в случае успеха
                .failureUrl("/signIn") // на какую страницу перенаправлять с случае фейла
                .permitAll() // разрешить страницу логина
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/signIn")
                .and()
                .rememberMe() // настраиваем функционал "Запомнить меня"
                .rememberMeParameter("remember-me") // говорим, что параметр будет называться именно так
                .tokenRepository(persistentTokenRepository()) // говорим, каким репозиторием следует пользоваться, для того, чтобы запомнить пользователя
                .tokenValiditySeconds(6000)
                .and()
                .csrf().disable();
    }

    // бин, который хранит объект-репозиторий
    // связанный с таблицей для запоминания сессий
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository =
                new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        return tokenRepository;
    }

    // сконфигуривали безопасность для работы с нашим UserDetailsImpl и PasswordEncoder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
