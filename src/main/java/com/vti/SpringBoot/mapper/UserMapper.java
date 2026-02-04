package com.vti.SpringBoot.mapper;

import com.vti.SpringBoot.dto.request.UserCreateRequest;
import com.vti.SpringBoot.dto.request.UserUpdateRequest;
import com.vti.SpringBoot.dto.response.UserResponse;
import com.vti.SpringBoot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreateRequest request);

    //    lastName và firstName sẽ trùng nhau
//    @Mapping(source = "firstName", target = "lastName")
    UserResponse toResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);

}
