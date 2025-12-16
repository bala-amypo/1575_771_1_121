
@RestController
@RequestMapping("/sessions")
public class ExamSessionController{

    @Autowired
    ExamSessionService examSessionService;

    @PostMapping("/")
    public ResponseEntity<ExamSession> createSession(@RequestBody ExamSession examSession){
        return ResponseEntity.status(200).body(examSessionService.createSession(examSession));
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<ExamSession> getSession(@PathVariable sessionId){
        return ResponseEntity.status(200).body(examSessionService.getSession(sessionId));
    }
}