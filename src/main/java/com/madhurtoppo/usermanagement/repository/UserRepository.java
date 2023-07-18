package com.madhurtoppo.usermanagement.repository;

import com.madhurtoppo.usermanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/** UserRepository */
public interface UserRepository extends JpaRepository<User, Long> {
  boolean existsByNameContainingIgnoreCase(String name);
}
