package com.madhurtoppo.usermanagement.repositories;

import com.madhurtoppo.usermanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** UserRepository */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
  boolean existsByNameContainingIgnoreCase(String name);
}
