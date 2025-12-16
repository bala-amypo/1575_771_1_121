
@RestController
@RequestMapping("/auth")
public class AuthController{
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User>register(@Valid @RequestBody User user){
        return ResponseEntity.status(201).body(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<User>login(@RequestBody String email){
        return ResponseEntity.status(200).body(userService.findByEmail(email));
    }
}