package de.cdelmonte.authentication.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import de.cdelmonte.authentication.domain.User;
import de.cdelmonte.authentication.domain.repository.UserRepository;


@Service(value = "userService")
public class UserService implements UserDetailsService {

  @Autowired
  private UserRepository userRepo;

  public UserDetails loadUserByUsername(String userId) {
    User user = userRepo.findByUserName(userId);
    if (user == null) {
      throw new UsernameNotFoundException("Invalid username or password.");
    }
    return new org.springframework.security.core.userdetails.User(user.getUserName(),
        user.getPassword(), getAuthority());
  }

  private List<SimpleGrantedAuthority> getAuthority() {
    return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
  }

  public List<User> findAll() {
    List<User> list = new ArrayList<>();
    userRepo.findAll().iterator().forEachRemaining(list::add);
    return list;
  }

  public void delete(String userName) {
    userRepo.deleteById(userName);
  }

  public User save(User user) {
    return userRepo.save(user);
  }
}
