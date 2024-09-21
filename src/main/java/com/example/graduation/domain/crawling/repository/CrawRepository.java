package com.example.graduation.domain.crawling.repository;

import com.example.graduation.domain.crawling.entity.Craw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrawRepository extends JpaRepository<Craw, Long> {
}
