package com.example.demo.controller;

import com.example.demo.Service.jwt.UserServiceImpl;
import com.example.demo.model.Dto.UserDto;
import com.example.demo.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:8080")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserServiceImpl userServiceImpl;

    @GetMapping("/user")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userServiceImpl.getAllUsers());
    }

    @PostMapping("/post")
    public ResponseEntity<User> createUser(@RequestBody UserDto user){
        return ResponseEntity.ok(userServiceImpl.createUser(user));
    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok(userServiceImpl.deleteUser(id));
    }

}
