package com.example.exptionsproject.Controller;

import com.example.exptionsproject.DTO.API;
import com.example.exptionsproject.Model.Classroom;
import com.example.exptionsproject.Model.Student;
import com.example.exptionsproject.Services.ClassroomService;
import com.example.exptionsproject.Services.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final ClassroomService classroomService;
    Logger logger= LoggerFactory.getLogger(StudentController.class);



    @GetMapping
    public ResponseEntity<List<Student>> getStudent(){
        logger.info("Request in getStudent");
        List<Student> classroom=studentService.getStudent();
        return ResponseEntity.status(HttpStatus.OK).body(classroom);
    }


    @PostMapping("/student/{id}")
    public ResponseEntity<API> checkUserIsValid(@PathVariable Integer id){
        logger.info("Request in checkUserIsValid");
        studentService.checkStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(new API("Valid student",200));
    }

    @PostMapping
    public ResponseEntity<API> addstudent(@RequestBody Student student) {
        logger.info("Request in addstudent");
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new API("New student added !",201));
    }

    @PostMapping("/class/{roomId}/{studentId}")
    public ResponseEntity<List<Student>> addclass(@PathVariable Integer roomId,@PathVariable Integer studentId){
        logger.info("Request in addclass");
        Student student=studentService.getById(studentId);
        Classroom classroom=classroomService.getById(roomId);
        student.getClassroom().add(classroom);
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudent());
    }
}
