package com.nextgate.assesment.service;

// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user){
        if (userRepository.existsByUsername(user.getUsername())){
            return null;
        }else{
            // user.setPass(bCryptPasswordEncoder.encode(user.getPass()));
            return userRepository.save(user);
        }
    }

    public boolean userExists(User user){
        return userRepository.existsByUsername(user.getUsername());
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

}
