package com.example.exptionsproject.Controller;

import com.example.exptionsproject.DTO.API;
import com.example.exptionsproject.DTO.ClassDTO;
import com.example.exptionsproject.Model.Classroom;
import com.example.exptionsproject.Model.Teacher;
import com.example.exptionsproject.Services.ClassroomService;
import com.example.exptionsproject.Services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/class")
@RequiredArgsConstructor
public class ClassroomController {
    private final ClassroomService classroomService;
    private final TeacherService teacherService;
    Logger logger= LoggerFactory.getLogger(ClassroomController.class);


    @GetMapping
    public ResponseEntity<List<Classroom>> getClasses(){
        logger.info("Request in getClass");
        List<Classroom> classroom=classroomService.getClassroom();
        return ResponseEntity.status(HttpStatus.OK).body(classroom);
    }


    @GetMapping("/class/{id}")
    public ResponseEntity<API> checkUserIsValid(@PathVariable Integer id){
        logger.info("Request in checkUserIsValid");
        classroomService.checkClass(id);
        return ResponseEntity.status(HttpStatus.OK).body(new API("Valid class",200));
    }

    @PostMapping
    public ResponseEntity<API> addclass(@RequestBody Classroom classrooms) {
        logger.info("Request in addclass");
        classroomService.addClassroom(classrooms);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new API("New class added !",201));
    }

    @PostMapping
    public ResponseEntity addClassestoTeacher(@RequestBody ClassDTO classDTO){
        logger.info("Request in addClassestoTeacher");
        Teacher teacher=teacherService.getById(classDTO.getClassId());
        Classroom classrooms=new Classroom(classDTO.getClassId(),classDTO.getName(),teacher);
        teacher.getClassrooms().add(classrooms);
        classroomService.addClassroom(classrooms);
        return ResponseEntity.status(HttpStatus.OK).body(classroomService.getClassroom());
    }

}
