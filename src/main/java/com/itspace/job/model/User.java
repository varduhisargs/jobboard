package com.itspace.job.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"userRoles","jobs"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String description;
    private String photo;
    private String facebook;
    private String twitter;
    private String whatsapp;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "user_role_id"))
    private List<UserRole> userRoles;
    @ManyToMany
    @JoinTable(name = "favorite_list", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "job_id"))
    private List<Job> jobs;
    @OneToOne
    @JoinColumn(name = "resume_id", referencedColumnName = "id")
    private Resume resume;

}
