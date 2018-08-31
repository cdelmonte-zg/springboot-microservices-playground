package de.cdelmonte.authentication.domain.repository;

import de.cdelmonte.authentication.domain.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, String> {
  User findByUserName(String username);
}


