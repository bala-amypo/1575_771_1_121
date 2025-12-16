
@RestController
@RequestMapping("/rooms")
public class ExamRoomController{

    @Autowired
    ExamRoomService examRoomService;

    @PostMapping(/addroom)
    public ResponseEntity<ExamRoom> addRoom(@RequestBody ExamRoom examRoom){
        return ResponseEntity.status(200).body(examRoomService.addRoom(examRoom));
    }

    @GetMapping(/listrooms)
    public ResponseEntity<ExamRoom> listRooms(@RequestBody ExamRoom examRoom){
        return ResponseEntity.status(200).body(examRoomService.getAllStudents());
    }
}