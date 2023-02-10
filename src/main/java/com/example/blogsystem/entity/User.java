package com.example.blogsystem.entity;
import lombok.*;
import org.hibernate.annotations.Cascade;


import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)

    private List<Blog> blog;
}
