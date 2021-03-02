package com.itspace.job.service;

import com.itspace.job.dto.RegisterUserDto;
import com.itspace.job.model.User;
import com.itspace.job.model.UserRole;
import com.itspace.job.repository.UserRepository;
import com.itspace.job.repository.UserRoleRepository;
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

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }


    @Override
    public User register(RegisterUserDto registerUserDto) {
        User byEmail = userRepository.findByEmail(registerUserDto.getEmail());
        User user = new User();
        if (byEmail == null) {
            user.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
            UserRole userRoleByName = userRoleRepository.findByName("user");
            List<UserRole> all = new ArrayList<>();
            all.add(userRoleByName);
            user.setUserRoles(all);
            mapper.map(registerUserDto,user);
            return userRepository.save(user);
        }
        return null;
    }
}
