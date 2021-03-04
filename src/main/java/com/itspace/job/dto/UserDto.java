package com.itspace.job.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private long id;
    private String name;
    private String email;
    private String phone;
    private String description;
    private String photo;
    private String facebook;
    private String twitter;
    private String whatsapp;
    private List<UserRoleDto> userRole;

}
