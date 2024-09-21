package com.example.graduation.domain.crawling.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Entity
@Table(name = "crawling")
@NoArgsConstructor
@Getter
public class Craw {
    @Id
    String Id;
    @Column
    String name;
}
