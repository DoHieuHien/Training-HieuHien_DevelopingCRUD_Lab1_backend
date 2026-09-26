package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "roles")

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Role {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "role_name", nullable = false, unique = true, length = 20)
    private String roleName;
}
