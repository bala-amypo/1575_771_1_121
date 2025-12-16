
@RestController
@RequestMapping("/students")
public class AuthController{
    @Autowired
    StudentService studentService;

    @PostMapping("/addstudent")
    public ResponseEntity<User>addStudent(@Valid @RequestBody Student student){
        return ResponseEntity.status(201).body(userService.addStudent(user));
    }

    @PostMapping("/liststudents")
    public ResponseEntity<User>login(@RequestBody String email){
        return ResponseEntity.status(200).body(userService.findByEmail(email));
    }
}