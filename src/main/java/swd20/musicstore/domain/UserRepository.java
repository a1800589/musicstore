package swd20.musicstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
	Users findByUsername(String username);
	}