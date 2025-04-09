package com.crud.FlutterBackendCrud.repository;

import com.crud.FlutterBackendCrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
