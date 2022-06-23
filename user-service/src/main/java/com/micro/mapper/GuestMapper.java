package com.micro.mapper;


import com.micro.dto.UserDto;
import com.micro.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GuestMapper {
    GuestMapper INSTANCE = Mappers.getMapper(GuestMapper.class);

    User convert(UserDto userDto);

    UserDto convert(User user);
    User zika(UserDto userddo);
    UserDto zabunnk(User sadi);
    User mal (UserDto userDto);
    UserDto neyse (User user );
    UserDto ramo (User user);
    UserDto aaaaa(User user);
}