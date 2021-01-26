package com.example.oslash.demo.service;

import com.example.oslash.demo.model.User;
import com.example.oslash.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User createUser(User user){
        return this.userRepository.save(user);
    }

    public Optional<User> getUserByUserId(Long id){
        return this.userRepository.findById(id);
    }
}
