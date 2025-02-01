package com.springboot.crud_example.controller;

import com.springboot.crud_example.dto.request.UserCreationRequest;
import com.springboot.crud_example.dto.request.UserUpdateRequest;
import com.springboot.crud_example.dto.response.UserResponse;
import com.springboot.crud_example.entity.User;
import com.springboot.crud_example.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class UserController {
    UserService userService;

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        User user = userService.isUser(username);
        return user;
    }

    @GetMapping("/")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping("/")
    public UserResponse createUser(@RequestBody UserCreationRequest request) {
        System.out.println("Received UserCreationRequest: " + request);
        return userService.createUser(request);
    }

    @PostMapping("/update/{username}")
    public UserResponse updateUser(
            @PathVariable("username") String username ,
            @RequestBody UserUpdateRequest request) {
        return userService.updateUser(username , request);
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable("username") String username) {
        try {
            boolean isDeleted = userService.deleteUser(username);
            if (isDeleted) {
                return ResponseEntity.ok("User with username: " + username + " has been deleted");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found: " + username);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete user: " + e.getMessage());
        }
    }


    @GetMapping("/search")
    public List<UserResponse> searchUsers(@RequestParam String text) {
        return userService.searchUsers(text);
    }

    
}

