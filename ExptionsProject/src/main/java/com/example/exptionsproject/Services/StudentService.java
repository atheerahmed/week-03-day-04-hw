package com.example.exptionsproject.Services;

import com.example.exptionsproject.Model.Student;
import com.example.exptionsproject.MyExptions.InvalidIdException;
import com.example.exptionsproject.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student)  {
        studentRepository.save(student);
    }

   public Student getById(Integer id){
       return studentRepository.findById(id).get();
   }

    public void checkStudent(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(
                        () -> new InvalidIdException("Invalid id"));

    }
}
