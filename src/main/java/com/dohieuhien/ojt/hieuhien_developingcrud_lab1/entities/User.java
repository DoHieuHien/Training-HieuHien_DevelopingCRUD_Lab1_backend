package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (unique = true, nullable = false, length = 20)
    private String userid;

    @Column (unique = true,nullable = false, length = 50)
    private String username;

    @Column (nullable = false, length = 50)
    private String email;

    @Column (nullable = false, length = 20)
    private String password;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (nullable = false)
    private RoleUser role;
}
