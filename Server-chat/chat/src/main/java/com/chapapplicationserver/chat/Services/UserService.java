package com.chapapplicationserver.chat.Services;


import com.chapapplicationserver.chat.Collection.Roles;
import com.chapapplicationserver.chat.Collection.User;
import com.chapapplicationserver.chat.Repository.UserRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService implements UserDetailsService {
    private  UserRepository userRepository;


    private  PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User NOt Found"));
    }

    public ResponseEntity<?> registerUserMethod(User user) throws UsernameAlreadyExistException{
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        long id;
        String hashedPassword;
        Roles userRole = Roles.USER;

        if (existingUser.isPresent() && existingUser.get().getUsername() != null){
            throw new UsernameAlreadyExistException("USERNAME ALREADY EXISTS");
        }else {
            id = userRepository.count() + 1;
            hashedPassword = passwordEncoder.encode(user.getPassword());
            userRepository.save(new User(id,user.getUsername(),hashedPassword,userRole));
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> loginUser(User user) throws Exception{
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser.isPresent() && existingUser.get().getUsername() != null) {
            if (passwordEncoder.matches(user.getPassword(), existingUser.get().getPassword()) && existingUser.get().getUsername().equals(user.getUsername())) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                throw new Exception("USER NOT FOUND");
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

