package com.nextgate.assesment.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nextgate.assesment.models.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

    boolean existsByUser(String user);

}