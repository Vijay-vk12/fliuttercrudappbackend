package com.crud.FlutterBackendCrud.service;

import com.crud.FlutterBackendCrud.entity.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserService {

    String saveUser(User user);
    List<User> getAllUsers();
    String updateUser(int id, User user);
    String deleteUser(int id);
    Optional<User> getUserById(int id);
}
