package com.crud.FlutterBackendCrud.service;

import com.crud.FlutterBackendCrud.entity.User;
import com.crud.FlutterBackendCrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    // Save/Register User
    @Override
    public String saveUser(User user) {
        repository.save(user);
        return "User registered successfully";
    }

    // Get All Users
    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    // Update User by ID
    @Override
    public String updateUser(int id, User updatedUser) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPhone(updatedUser.getPhone());
            existingUser.setAddress(updatedUser.getAddress());
            existingUser.setPassword(updatedUser.getPassword());
            repository.save(existingUser);
            return "User updated successfully";
        } else {
            return "User not found with ID: " + id;
        }
    }

    // Delete User by ID
    @Override
    public String deleteUser(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "User deleted successfully";
        } else {
            return "User not found with ID: " + id;
        }
    }

    @Override
    public Optional<User> getUserById(int id) {
        return  repository.findById(id);
    }
}
