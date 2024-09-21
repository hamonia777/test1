package com.example.graduation.domain.test.repository;


import com.example.graduation.domain.test.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    Test findByName(String name);

    List<Test> findAllById(Long id);
}
