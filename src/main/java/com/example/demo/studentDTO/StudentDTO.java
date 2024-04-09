package com.example.demo.studentDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class StudentDTO {
    private Integer id;
    private String name;
    private String address;
    private ClazzDTO clazz;
    private String point;
    private int clazz_id;
    List<SubjectDTO> subjectDTOS = new ArrayList<>();


}
