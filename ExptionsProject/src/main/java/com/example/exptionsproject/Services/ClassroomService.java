package com.example.exptionsproject.Services;

import com.example.exptionsproject.Model.Classroom;
import com.example.exptionsproject.Model.Student;
import com.example.exptionsproject.MyExptions.InvalidIdException;
import com.example.exptionsproject.Repository.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomService {
    private final ClassroomRepository classroomRepository;


    public List<Classroom> getClassroom() {
        return classroomRepository.findAll();
    }

    public void addClassroom(Classroom classroom)  {
        classroomRepository.save(classroom);
    }

    public Classroom getById(Integer id){
        return classroomRepository.findById(id).get();
    }

    public void checkClass(Integer id) {
        Classroom classrooms = classroomRepository.findById(id)
                .orElseThrow(
                        () -> new InvalidIdException("Invalid id"));

    }



}
