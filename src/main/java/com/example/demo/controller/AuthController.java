
@RestController
@RequestMapping("/auth")
public class AuthController{
    @Autowired
    ExamRoomService examRoomService;

    @PostMapping("/register")
    Response<>register(){

    }

    @PostMapping("/login")
    ResponseEntity<>login(){

    }
}