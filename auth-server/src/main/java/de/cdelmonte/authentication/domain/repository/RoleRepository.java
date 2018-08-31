package de.cdelmonte.authentication.domain.repository;

import de.cdelmonte.authentication.domain.Role;

import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<Role, String> {

}
