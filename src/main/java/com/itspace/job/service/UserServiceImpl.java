package com.itspace.job.service;

import com.itspace.job.dto.*;
import com.itspace.job.model.User;
import com.itspace.job.model.UserRole;
import com.itspace.job.repository.UserRepository;
import com.itspace.job.repository.UserRoleRepository;
import com.itspace.job.util.JwtUtil;
import io.jsonwebtoken.impl.DefaultClaims;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;
    private final JwtUtil jwtUtil;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, ModelMapper mapper, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public User register(RegisterUserDto registerUserDto) {
        User byEmail = userRepository.findByEmail(registerUserDto.getEmail());
        User user = new User();
        if (byEmail == null) {
            mapper.map(registerUserDto, user);
            user.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
            UserRole userRoleByName = userRoleRepository.findByName("user");
            List<UserRole> all = new ArrayList<>();
            all.add(userRoleByName);
            user.setUserRoles(all);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public LoginResponseDto login(LoginUser loginUser) {
        User byEmail = userRepository.findByEmail(loginUser.getEmail());
        if (byEmail != null && passwordEncoder.matches(loginUser.getPassword(), byEmail.getPassword())){
            String token = jwtUtil.generateToken(loginUser.getEmail(), new DefaultClaims());
            UserDto userDto = mapper.map(byEmail,UserDto.class);
            userDto.setUserRole(new ArrayList<>());
            for (UserRole userRole : byEmail.getUserRoles()) {
                userDto.getUserRole().add(mapper.map(userRole, UserRoleDto.class));
            }
            return LoginResponseDto.builder()
                    .token(token)
                    .user(userDto)
                    .build();
        }
        return null;
    }

}
