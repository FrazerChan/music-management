package com.nextgate.assesment.service;

import org.springframework.stereotype.Service;
import com.nextgate.assesment.models.User;
import com.nextgate.assesment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The Auth service that will handle the CRUD operations
 */
@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Returns all users
     */
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Adds a new user if it does not already exist
     * @return the user created
     */
    public User addUser(User user){
        if (userRepository.existsByUsername(user.getUsername())){
            return null;
        }else{
            return userRepository.save(user);
        }
    }

    /**
     * Checks if a user exists
     * @return true if exists, false if not
     */
    public boolean userExists(User user){
        return userRepository.existsByUsername(user.getUsername());
    }

    /**
     * Finds a user based on a username
     * @return User if found
     */
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
