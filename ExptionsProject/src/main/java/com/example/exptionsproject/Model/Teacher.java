package com.example.exptionsproject.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Teacher {
            @Id
        private Integer id;
        private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Classroom> classrooms;



}
