package com.itspace.job.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "blogs")
public class BlogCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToMany(mappedBy = "blogCategories",cascade={CascadeType.ALL})
    private List<Blog> blogs;

}
