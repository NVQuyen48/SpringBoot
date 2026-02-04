package com.vti.SpringBoot.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserCreateRequest {
    @Size(min = 3, message = "USERNAME_INVALID")
    String username;

    //    @Size(min = 8, message = "Password must be at least ")
    String password;
    String firstName;
    String lastName;
    LocalDate dob;


}
