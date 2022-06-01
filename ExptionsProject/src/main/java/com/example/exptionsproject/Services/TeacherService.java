package com.example.exptionsproject.Services;

import com.example.exptionsproject.Model.Classroom;
import com.example.exptionsproject.Model.Teacher;
import com.example.exptionsproject.MyExptions.InvalidIdException;
import com.example.exptionsproject.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeacher() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher)  {
        teacherRepository.save(teacher);
    }
    public Teacher getById(Integer id){
        return teacherRepository.findById(id).get();
    }



    public void checkTeacher(Integer id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(
                        () -> new InvalidIdException("Invalid id"));

    }
}
