package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subject")
public class Subject {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "khoi1")
    private String khoi1;

    @Column(name = "khoi2")
    private String khoi2;

    @Column(name = "point")
    private String point;

//    @Column(name = "clazz")
//    private String clazz;


}
