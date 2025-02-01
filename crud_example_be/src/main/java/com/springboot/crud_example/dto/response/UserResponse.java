package com.springboot.crud_example.dto.response;

//import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    @Column(name = "first_name" , nullable = false)
//    @Schema(
//            description = "User First Name",
//            name = "firstName",
//            type = "String",
//            example = "Duc")
    String firstName;

    @Column(name = "last_name" , nullable = false)
//    @Schema(
//            description = "User Last Name",
//            name = "lastName",
//            type = "String",
//            example = "Giang")
    String lastName;

    @Column(name = "username" , nullable = false)
//    @Schema(
//            description = "User Username",
//            name = "username",
//            type = "String",
//            example = "ducgiangdev123")
    String username;
    @Column(unique = true, nullable = false)
//    @Schema(
//            description = "User Email",
//            name = "email",
//            type = "String",
//            example = "ducgiangdev@gmail.com")
    String email;
}
