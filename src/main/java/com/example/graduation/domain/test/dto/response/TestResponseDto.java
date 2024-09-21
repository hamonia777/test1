package com.example.graduation.domain.test.dto.response;

import com.example.graduation.domain.test.entity.Test;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TestResponseDto {
    Long id;
    String name;
    LocalDateTime createBy;
    LocalDateTime modifiedBy;
    public TestResponseDto(Test test) {
        this.id = test.getId();
        this.name = test.getName();
        this.createBy = test.getCreatedAt();
        this.modifiedBy = test.getModifiedAt();
    }
}
