package com.itspace.job.service;

import com.itspace.job.dto.RegisterUserDto;
import com.itspace.job.model.User;

public interface UserService {

    User register(RegisterUserDto registerUserDto);

}
