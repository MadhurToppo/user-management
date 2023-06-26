package com.madhurtoppo.userservice.repositories;

import com.madhurtoppo.userservice.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

/** UserRepository */
public interface UserRepository extends JpaRepository<User, Long> {
  boolean existsByNameContainingIgnoreCase(String name);
}
