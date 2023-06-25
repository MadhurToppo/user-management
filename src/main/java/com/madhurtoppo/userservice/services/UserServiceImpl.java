package com.madhurtoppo.userservice.services;

import com.madhurtoppo.userservice.domains.User;
import com.madhurtoppo.userservice.domains.dtos.Mapper;
import com.madhurtoppo.userservice.domains.dtos.UserDto;
import com.madhurtoppo.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** UserServiceImpl */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository repository;
  @Autowired
  private Mapper mapper;

  @Override
  public Long createUser(final UserDto userDto) {
    final User entity = mapper.toEntity(userDto);
    final User user = repository.save(entity);
    return user.getId();
  }

  @Override
  public UserDto getUser(final long id) {
    final User user = this.repository.findById(id).get();
    final UserDto userDto = mapper.toDto(user);
    return userDto;
  }
}
