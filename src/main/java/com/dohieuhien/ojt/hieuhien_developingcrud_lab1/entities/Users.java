package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table (name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Users {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "userid", unique = true, nullable = false, length = 20)
    private String userid;

    @Column (name = "username",unique = true,nullable = false, length = 50)
    private String username;

    @Column (name = "email",nullable = false, length = 50)
    private String email;

    @Column (name = "password", nullable = false, length = 50)
    private String password;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "role_id", nullable = false)
    private Role role;
}
