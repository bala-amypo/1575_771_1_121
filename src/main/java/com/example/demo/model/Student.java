package com.example.demo.model;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique=true, nullable = false)
    private String rollNumber;
    
    private String name;
    private String department;
    private Integer year;

    @ManyToMany(mappedBy = "students")
    @JsonIgnoreProperties("students")
    private Set<ExamSession> examSessions = new HashSet<>();
}
