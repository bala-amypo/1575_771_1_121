
@RestController
@RequestMapping("/students")
public class AuthController{
    @Autowired
    StudentService studentService;

    @PostMapping("/addstudent")
    public ResponseEntity<Student>addStudent(@Valid @RequestBody Student student){
        return ResponseEntity.status(201).body(StudentService.addStudent(student));
    }

    @PostMapping("/liststudents")
    public ResponseEntity<Student> getAllStudents(){
        return ResponseEntity.status(200).body(StudentService.getAllStudents());
    }
}