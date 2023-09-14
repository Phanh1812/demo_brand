package com.example.BaiTap1.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@ToString
@Builder
@Entity
@Table(name = "People")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "country")
    private String country;

    @Column(name = "job")
    private String job;

    @Column(name = "company")
    private String company;

    @Column(name = "salary")
    private double salary;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "slogan")
    private String slogan;
}
