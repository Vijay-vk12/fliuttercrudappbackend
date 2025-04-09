package com.crud.FlutterBackendCrud.controller;

import com.crud.FlutterBackendCrud.entity.User;
import com.crud.FlutterBackendCrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService service;

    // ✅ Register New User
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            return new ResponseEntity<>("Name is required", HttpStatus.BAD_REQUEST);
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            return new ResponseEntity<>("Email is required", HttpStatus.BAD_REQUEST);
        }
        if (!user.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            return new ResponseEntity<>("Invalid email format", HttpStatus.BAD_REQUEST);
        }
        if (user.getPhone() == null || user.getPhone().trim().isEmpty()) {
            return new ResponseEntity<>("Phone number is required", HttpStatus.BAD_REQUEST);
        }
        if (!user.getPhone().matches("\\d{10}")) {
            return new ResponseEntity<>("Phone number must be exactly 10 digits", HttpStatus.BAD_REQUEST);
        }
        if (user.getAddress() == null || user.getAddress().trim().isEmpty()) {
            return new ResponseEntity<>("Address is required", HttpStatus.BAD_REQUEST);
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            return new ResponseEntity<>("Password is required", HttpStatus.BAD_REQUEST);
        }
        if (user.getPassword().length() < 6) {
            return new ResponseEntity<>("Password must be at least 6 characters", HttpStatus.BAD_REQUEST);
        }

        String hashPassword= BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashPassword);
        String msg = service.saveUser(user);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    // 📋 Get All Users
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = service.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // 🔄 Update User
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        String msg = service.updateUser(id, updatedUser);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    // ❌ Delete User
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        String msg = service.deleteUser(id);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        Optional<User> user = service.getUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
