// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.stereotype.Service;

// import com.example.demo.service.StudentService;


// import com.example.demo.model.ExamRoom; 
// import com.example.demo.model.Student;
// import com.example.demo.repository.StudentRepository;
// import com.example.demo.exception.ApiException;
// import com.example.demo.model.Student;

// @Service
// public class StudentServiceImpl implements StudentService{
    
//     private final StudentRepository studentRepository;

//     public StudentServiceImpl(StudentRepository studentRepository) {
//         this.studentRepository = studentRepository;
//     }
    
//     public Student addStudent(Student student){
//         if(student.getRollNumber()==null||student.getYear()==null){
//             throw  new ApiException("invalid student");
//         }
//         if(student.getYear()<1 || student.getYear()>5){
//             throw new ApiException("year");
//         }
//         if(studentRepository.findByRollNumber(student.getRollNumber()).isPresent()){
//             throw new ApiException("exists");
//         }
//         return studentRepository.save(student);
//     }

//     public List<Student> getAllStudents(){
//         return studentRepository.findAll();
//     }

// }

package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ExamSession;
import com.example.demo.model.Student;
import com.example.demo.repository.ExamSessionRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.ExamSessionService;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExamSessionServiceImpl implements ExamSessionService {

    private final ExamSessionRepository examSessionRepository;
    private final StudentRepository studentRepository;

    public ExamSessionServiceImpl(
            ExamSessionRepository examSessionRepository,
            StudentRepository studentRepository) {
        this.examSessionRepository = examSessionRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public ExamSession createSession(ExamSession session) {

        if (session.getExamDate().isBefore(LocalDate.now())) {
            throw new ApiException("past");
        }

        if (session.getStudents() == null || session.getStudents().isEmpty()) {
            throw new ApiException("at least 1 student");
        }

        // 🔥 FIX: Convert incoming students to managed entities
        Set<Student> managedStudents = new HashSet<>();

        for (Student s : session.getStudents()) {
            Student student = studentRepository.findById(s.getId())
                    .orElseThrow(() ->
                            new ApiException("student not found: " + s.getId()));
            managedStudents.add(student);
        }

        session.setStudents(managedStudents);

        return examSessionRepository.save(session);
    }

    @Override
    public ExamSession getSession(Long sessionId) {
        return examSessionRepository.findById(sessionId)
                .orElseThrow(() -> new ApiException("session not found"));
    }
}
// 