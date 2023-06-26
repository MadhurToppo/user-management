package com.madhurtoppo.userservice.services;

import com.madhurtoppo.userservice.domains.User;
import com.madhurtoppo.userservice.domains.dtos.Mapper;
import com.madhurtoppo.userservice.domains.dtos.UserDto;
import com.madhurtoppo.userservice.exceptions.UserAlreadyExistsException;
import com.madhurtoppo.userservice.exceptions.UserNotFoundException;
import com.madhurtoppo.userservice.repositories.UserRepository;
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
    if (repository.existsByNameContainingIgnoreCase(userDto.getName())) {
      throw new UserAlreadyExistsException(
          "User with name '%s' already exists".formatted(userDto.getName()));
    }
    final User user = mapper.toEntity(userDto);
    return repository.save(user).getId();
  }

  @Override
  public UserDto getUser(final long id) {
    final User user =
        repository
            .findById(id)
            .orElseThrow(
                () -> new UserNotFoundException("User with id '%d' does not exists".formatted(id)));
    return mapper.toDto(user);
  }
}
