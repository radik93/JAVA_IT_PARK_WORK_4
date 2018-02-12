package ru.itpark.app.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itpark.app.repositoris.UsersRepository;

// Интерфейс, который описывает класс, который
// позволит Spring доставать пользователя из бд
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UsersRepository usersRepository;

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

    return new UserDetailsImpl(
        usersRepository.findByLogin(login).orElseThrow(() ->
    new IllegalArgumentException("User not found by login")));
  }
}
