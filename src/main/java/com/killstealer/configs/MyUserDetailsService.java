package com.killstealer.configs;

import com.killstealer.entities.User;
import com.killstealer.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;

@Configuration
public class MyUserDetailsService implements UserDetailsService {
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public BCryptPasswordEncoder getEncoder() {
        return encoder;
    }

    @Autowired
    private UserRepo userRepo;

    @PostConstruct
    private void createDefaultUser() {
        if (userRepo.findByUsername("xPeke") == null) {
            addUser(new User("xPeke", "abc123"));
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found by username: " + username);
        }
        return toUserDetails(user);
    }

    public User addUser(User user) { // encrypting the password
        user.setPassword(encoder.encode(user.getPassword()));
        try {
            return userRepo.save(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private UserDetails toUserDetails(User user) {
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("USER").build();
    }
}
