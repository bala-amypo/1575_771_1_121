// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;

// @Entity
// @Table(name = "students")
// @Getter
// @Setter
// @Builder
// @NoArgsConstructor
// @AllArgsConstructor
// public class Student {
//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
    
//     @Column(unique=true, nullable = false)
//     private String rollNumber;
    
//     private String name;
//     private String department;
//     private Integer year;
// }

package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String rollNumber;

    private String name;
    private String department;
    private Integer year;

    @ManyToMany(mappedBy = "students")
    private Set<ExamSession> sessions;
}
