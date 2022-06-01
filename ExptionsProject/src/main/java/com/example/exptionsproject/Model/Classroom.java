package com.example.exptionsproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "classroom",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Student> student;

    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    public Classroom(Integer id, String name, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }
}
