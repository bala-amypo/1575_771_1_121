
@RestController
@RequestMapping("/")
public class ExamSessionController{

    @Autowired
    ExamSessionService examSessionService;

    @PostMapping("/")
    public ResponseEntity<ExamSession> (@RequestBody ExamSession examSession){
        return ResponseEntity.status(200).body(examSessionService.admSession(examSession));
    }

    @GetMapping("/")
    public ResponseEntity<ExamSession> lismSessions(@RequestBody ExamSession examSession){
        return ResponseEntity.status(200).body(examSessionService.getAllStudents());
    }
}