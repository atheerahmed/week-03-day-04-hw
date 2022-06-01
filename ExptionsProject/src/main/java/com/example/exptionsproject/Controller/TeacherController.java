package com.example.exptionsproject.Controller;

import com.example.exptionsproject.DTO.API;
import com.example.exptionsproject.Model.Teacher;
import com.example.exptionsproject.Services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    Logger logger= LoggerFactory.getLogger(StudentController.class);



    @GetMapping
    public ResponseEntity<List<Teacher>> getTeachers(){
        logger.info("Request in getTeachers");
        List<Teacher> classroom=teacherService.getTeacher();
        return ResponseEntity.status(HttpStatus.OK).body(classroom);
    }


    @GetMapping("/teacher/{id}")
    public ResponseEntity<API> checkUserIsValid(@PathVariable Integer id){
        logger.info("Request in checkUserIsValid");

        teacherService.checkTeacher(id);
        return ResponseEntity.status(HttpStatus.OK).body(new API("Valid teacher",200));
    }

    @PostMapping
    public ResponseEntity<API> addTeacher(@RequestBody @Valid Teacher teacher) {
        logger.info("Request in addTeacher");
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new API("New teacher added !",201));
    }
}
