package com.example.demo.model;

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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "session_student_mapping",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "session_id")
    )
    private Set<ExamSession> examSessions = new HashSet<>();
}
