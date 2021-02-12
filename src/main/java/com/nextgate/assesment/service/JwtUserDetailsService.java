package com.nextgate.assesment.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.nextgate.assesment.service.AuthService;
// import com.nextgate.assesment.models.User;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthService authService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.nextgate.assesment.models.User user = authService.findByUsername(username);
		if (user != null) {
			return new User(user.getUsername(), user.getPassword(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}