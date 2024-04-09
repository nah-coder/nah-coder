package com.example.demo.entity;

import com.example.demo.studentDTO.ClazzDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;


    @Column(name = "point")
    private String point;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clazz_id")
    private Clazz clazz;
    @ManyToMany
    @JoinTable(name = "student_subject",
            joinColumns = @JoinColumn(name = "id_student",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_subject",referencedColumnName = "id"))
    private List<Subject> subjects = new ArrayList<>();
}
