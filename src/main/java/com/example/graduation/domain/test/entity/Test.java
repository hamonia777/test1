package com.example.graduation.domain.test.entity;

import com.example.graduation.domain.test.dto.request.TestRequestDto;
import com.example.graduation.global.util.Timestamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "test_table")
@Getter
@Setter
@NoArgsConstructor
public class Test extends Timestamped {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column
        private  String name;
        public Test(TestRequestDto testRequestDto)
        {
                this.name = testRequestDto.getName();
        }
}
