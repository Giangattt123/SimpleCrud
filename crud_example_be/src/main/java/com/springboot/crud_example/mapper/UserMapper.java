package com.springboot.crud_example.mapper;

import com.springboot.crud_example.dto.request.UserCreationRequest;
import com.springboot.crud_example.dto.response.UserResponse;
import com.springboot.crud_example.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "email", source = "email")
    User toUser(UserCreationRequest request);


    UserResponse toUserResponse(User user);

    List<UserResponse> toUserResponseList(List<User> users);

}
