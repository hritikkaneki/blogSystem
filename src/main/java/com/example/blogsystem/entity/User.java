package com.example.blogsystem.entity;
import lombok.*;


import jakarta.persistence.*;
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
    @Column(unique = true)
    private String userName;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)

    private List<Blog> blog;


    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
