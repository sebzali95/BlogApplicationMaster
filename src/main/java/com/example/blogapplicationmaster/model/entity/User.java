package com.example.blogapplicationmaster.model.entity;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    Long id;
    @Column(name = "user_name", unique = true)
    String userName;
    @Column(name = "first_name", nullable = false)
    String firstName;
    @Column(name = "last_name", nullable = false)
    String lastName;
    @Column(name = "user_password", nullable = false)
    String password;
    @Column(name = "user_mail", nullable = false)
    String mail;
    @Column(name = "user_phoneNumber", nullable = false)
    String phoneNumber;


}
