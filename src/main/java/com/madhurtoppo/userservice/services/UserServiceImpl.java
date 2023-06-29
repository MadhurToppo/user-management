package com.madhurtoppo.userservice.services;

import com.madhurtoppo.userservice.domains.User;
import com.madhurtoppo.userservice.domains.dtos.Mapper;
import com.madhurtoppo.userservice.domains.dtos.UserDto;
import com.madhurtoppo.userservice.domains.dtos.UsersDto;
import com.madhurtoppo.userservice.exceptions.InvalidArgumentException;
import com.madhurtoppo.userservice.exceptions.UserAlreadyExistsException;
import com.madhurtoppo.userservice.exceptions.UserNotFoundException;
import com.madhurtoppo.userservice.repositories.UserRepository;
import java.util.List;
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
      throw new UserAlreadyExistsException(userDto.getName());
    }
    final User user = mapper.toEntity(userDto);
    final User savedUser = repository.save(user);
    return savedUser.getId();
  }

  @Override
  public UserDto getUser(final long id) {
    final User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    final UserDto userDto = mapper.toDto(user);
    return userDto;
  }

  @Override
  public UsersDto getAllUsers() {
    final List<UserDto> users = repository.findAll().stream().map(user -> mapper.toDto(user)).toList();
    final UsersDto usersDto = new UsersDto(users);
    return usersDto;
  }

  @Override
  public String update(final UserDto userDto, final long id) {
    if (userDto.getName() == null || userDto.getAge() < 0 || userDto.getCity() == null) {
      throw new InvalidArgumentException();
    }
    final User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    user.setName(userDto.getName());
    user.setAge(userDto.getAge());
    user.setCity(userDto.getCity());
    repository.save(user);
    return "Successfully updated.";
  }

  @Override
  public String delete(long id) {
    final User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    repository.delete(user);
    return "Successfully deleted";
  }
}
