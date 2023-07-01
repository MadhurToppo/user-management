package com.madhurtoppo.usermanagement.services;

import com.madhurtoppo.usermanagement.dtos.Mapper;
import com.madhurtoppo.usermanagement.dtos.UserDto;
import com.madhurtoppo.usermanagement.dtos.UsersDto;
import com.madhurtoppo.usermanagement.exceptions.InvalidArgumentException;
import com.madhurtoppo.usermanagement.exceptions.UserAlreadyExistsException;
import com.madhurtoppo.usermanagement.exceptions.UserNotFoundException;
import com.madhurtoppo.usermanagement.model.User;
import com.madhurtoppo.usermanagement.repository.UserRepository;
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
