package com.itspace.job.service;

import com.itspace.job.dto.LoginResponseDto;
import com.itspace.job.dto.LoginUser;
import com.itspace.job.dto.RegisterUserDto;
import com.itspace.job.dto.UserDto;
import com.itspace.job.model.User;

public interface UserService {

    User register(RegisterUserDto registerUserDto);

    LoginResponseDto login(LoginUser loginUser);

    User update(UserDto userDto);

}
