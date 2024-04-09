package com.example.demo.studentDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class ClazzDTO {
    private int id;
    private String name;
//    private String clazz;
}
