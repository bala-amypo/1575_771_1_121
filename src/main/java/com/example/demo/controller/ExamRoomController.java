
@RestController
@RequestMapping("/rooms")
public class ExamRoomController{

    @Autowired
    ExamRoomService examRoomService;

    @PostMapping
    public ResponseEntity<
}