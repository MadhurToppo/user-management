package com.madhurtoppo.userservice.services;

import com.madhurtoppo.userservice.domains.User;

/** UserService */
public interface UserService {

  public User createUser(User user);

  public User getUser(long id);
}
