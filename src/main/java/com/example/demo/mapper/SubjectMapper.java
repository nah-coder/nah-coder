package com.example.demo.mapper;

import com.example.demo.entity.Subject;
import com.example.demo.studentDTO.SubjectDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class SubjectMapper implements EntityMapper<Subject, SubjectDTO> {

    @Override
    public Subject toEntity(SubjectDTO dto) {
        return null;
    }

    @Override
    public SubjectDTO toDto(Subject entity) {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setId(entity.getId());
        subjectDTO.setName(entity.getName());
        subjectDTO.setKhoi1(entity.getKhoi1());
        subjectDTO.setKhoi2(entity.getKhoi2());

         return subjectDTO;
    }

    @Override
    public List<Subject> toEntity(List<SubjectDTO> dto) {
        return null;
    }

    @Override
    public List<SubjectDTO> toDto(List<Subject> entity) {
        List<SubjectDTO> dtos = new ArrayList<>();
        entity.forEach(item ->{
            SubjectDTO subjectDTO = toDto(item);
            dtos.add(subjectDTO);
        });
        return dtos;
    }
}
