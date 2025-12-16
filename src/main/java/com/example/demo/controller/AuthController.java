
@RestController
@RequestMapping("/auth")
public class AuthController{
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User>register(@Valid 2){
        return ResponseEntity.status(201).body()
    }

    @PostMapping("/login")
    public ResponseEntity<User>login(){

    }
}