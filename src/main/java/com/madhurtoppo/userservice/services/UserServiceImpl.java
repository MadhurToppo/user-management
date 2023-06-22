package com.madhurtoppo.userservice.services;

import com.madhurtoppo.userservice.domains.User;
import com.madhurtoppo.userservice.repositories.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/** UserServiceImpl */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  @Override
  public User createUser(final User user) {
    return user;
  }

  @Override
  public User getUser(final long id) {
    final Optional<User> user = userRepository.findById(id);
    if (user.isPresent()) {
      return user.get();
    }
    throw new RuntimeException("User Not found");
    // return userRepository.findById(id).orElse(throw new RuntimeException("Not"));
  }
}
