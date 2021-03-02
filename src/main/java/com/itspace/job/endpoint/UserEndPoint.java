package com.itspace.job.endpoint;

import com.itspace.job.dto.RegisterUserDto;
import com.itspace.job.dto.UserDto;
import com.itspace.job.model.User;
import com.itspace.job.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEndPoint {

    private UserService userService;
    private ModelMapper mapper;

    public UserEndPoint(UserService userService, ModelMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody RegisterUserDto registerUserDto) {

        User user = userService.register(registerUserDto);
        if (user != null) {
            UserDto userDto = mapper.map(user, UserDto.class);
            return ResponseEntity.ok(userDto);
        }
        return ResponseEntity.status(400).build();
    }

}
