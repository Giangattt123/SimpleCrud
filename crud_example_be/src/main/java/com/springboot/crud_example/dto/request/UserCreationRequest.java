package com.springboot.crud_example.dto.request;

//import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {

//    @Schema(
//            description = "User First Name",
//            name = "firstName",
//            type = "String",
//            example = "Duc")
    String firstName;


//    @Schema(
//            description = "User Last Name",
//            name = "lastName",
//            type = "String",
//            example = "Giang")
    String lastName;


//    @Schema(
//            description = "User Username",
//            name = "username",
//            type = "String",
//            example = "ducgiangdev123")
    String username;

//    @Schema(
//            description = "User Email",
//            name = "email",
//            type = "String",
//            example = "ducgiangdev@gmail.com")
    String email;
}

