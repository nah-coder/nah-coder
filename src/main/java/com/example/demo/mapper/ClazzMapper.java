package com.example.demo.mapper;


import com.example.demo.entity.Clazz;
import com.example.demo.studentDTO.ClazzDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ClazzMapper implements EntityMapper<Clazz, ClazzDTO>{


    @Override
    public Clazz toEntity(ClazzDTO dto) {
        return Clazz
                .builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    @Override
    public ClazzDTO toDto(Clazz entity) {
        return ClazzDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public List<Clazz> toEntity(List<ClazzDTO> dto) {
        return null;
    }

    @Override
    public List<ClazzDTO> toDto(List<Clazz> entity) {
        List<ClazzDTO> dtos = new ArrayList<>();
        entity.forEach(clazz -> {
            ClazzDTO clazzDTO = toDto(clazz);
            dtos.add((clazzDTO));
        });
        return null;
    }
}
