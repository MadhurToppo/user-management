package com.madhurtoppo.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madhurtoppo.usermanagement.model.User;

/** UserRepository */
public interface UserRepository extends JpaRepository<User, Long> {
  boolean existsByNameContainingIgnoreCase(String name);
}
