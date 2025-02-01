package com.springboot.crud_example.service;

import com.springboot.crud_example.dto.request.UserCreationRequest;
import com.springboot.crud_example.dto.request.UserUpdateRequest;
import com.springboot.crud_example.dto.response.UserResponse;
import com.springboot.crud_example.entity.User;
import com.springboot.crud_example.exception.UserNotFoundException;
import com.springboot.crud_example.mapper.UserMapper;
import com.springboot.crud_example.repository.UserRepository;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Data
@RequiredArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public User isUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(
                        () -> new UserNotFoundException("User with username: " + username + "not found!!"));
    }


    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.toUserResponseList(users);
    }

    public UserResponse createUser(UserCreationRequest request) {
        User user = userMapper.toUser(request);
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    public UserResponse updateUser(String username , UserUpdateRequest request) {
        User user = isUser(username);
        user = user.toBuilder()
                .firstName(request.getFirstName() != null ? request.getFirstName() : user.getFirstName())
                .lastName(request.getLastName() != null ? request.getLastName() : user.getLastName())
                .build();
//        user = User.builder().
//                firstName(request.getFirstName())
//                .lastName(request.getLastName())
//                .build();

        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    public boolean deleteUser(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
            return true;
        } else {
            return false;
        }
    }


    public List<UserResponse> searchUsers(String text) {
        List<User> users = userRepository.searchUsers(text);
        return users.stream().map(userMapper::toUserResponse).toList();
    }
}

