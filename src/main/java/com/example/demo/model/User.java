package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name="users")
@Getter 
@Setter
@Builder
@NoArgsConstructor // Required by JPA
@AllArgsConstructor // Required by Lombok Builder
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Email
    @NotBlank
    @Column(unique=true)
    private String email;

    @NotBlank
    private String password;

    @Builder.Default // Ensures the default value is kept when using the builder
    private String role = "STAFF";
}