package org.lessons.lesson43.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class InMemoryMapUserDetailsService implements UserDetailsService {

    private final Map<String, String> users = new HashMap<>();

    public InMemoryMapUserDetailsService() {
        users.put("user", new BCryptPasswordEncoder().encode("password"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String encodedPassword = users.get(username);
        if (encodedPassword == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        return User.withUsername(username)
                .password(encodedPassword)
                .roles("USER")
                .build();
    }
}