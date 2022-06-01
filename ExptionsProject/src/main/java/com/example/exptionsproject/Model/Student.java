package com.example.exptionsproject.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private String major;

//    @ManyToMany
//    @MapsId
//    @JoinColumn
//    private Classroom classroom;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Classroom> classroom;




}
