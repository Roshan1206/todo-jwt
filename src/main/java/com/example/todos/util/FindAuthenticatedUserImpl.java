package com.example.todos.util;

import com.example.todos.entity.User;
import com.example.todos.repository.UserRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class FindAuthenticatedUserImpl implements FindAuthenticatedUser{
    private final UserRepository userRepository;

    public FindAuthenticatedUserImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")){
            throw new AccessDeniedException("Authentication is required");
        }
        return userRepository.findByEmail(authentication.getPrincipal().toString()).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );
    }
}
