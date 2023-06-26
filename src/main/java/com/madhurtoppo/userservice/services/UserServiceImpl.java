package com.madhurtoppo.userservice.services;

import com.madhurtoppo.userservice.domains.User;
import com.madhurtoppo.userservice.domains.dtos.Mapper;
import com.madhurtoppo.userservice.domains.dtos.UserDto;
import com.madhurtoppo.userservice.exceptions.UserNotFoundException;
import com.madhurtoppo.userservice.repositories.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/** UserServiceImpl */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository repository;
  private final Mapper mapper;

  @Override
  public Long createUser(final UserDto userDto) {
    final User user = mapper.toEntity(userDto);
    final User savedUser = repository.save(user);
    return savedUser.getId();
  }

  @Override
  public UserDto getUser(final long id) {
    final Optional<User> user = this.repository.findById(id);
    if (user.isPresent()) {
      final UserDto userDto = mapper.toDto(user.get());
      return userDto;
    }
    throw new UserNotFoundException("User does not exists");
  }
}
