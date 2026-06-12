package com.project.springsecurity.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private  String role;

    @Builder
    public UserEntity(String username ,String password, String role ){
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
