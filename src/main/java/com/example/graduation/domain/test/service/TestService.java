package com.example.graduation.domain.test.service;

import com.example.graduation.domain.test.dto.request.TestRequestDto;
import com.example.graduation.domain.test.dto.response.TestResponseDto;
import com.example.graduation.domain.test.entity.Test;
import com.example.graduation.domain.test.repository.TestRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j(topic = "postService")
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;
    public List<TestResponseDto> getTest()
    {
        List<Test> testList = new ArrayList<Test>();
        List<TestResponseDto> testResponseDtoList = new ArrayList<TestResponseDto>();
        testList = testRepository.findAll();
        for(Test test : testList)
        {
            TestResponseDto testResponseDto = new TestResponseDto(test);
            testResponseDtoList.add(testResponseDto);
        }
        return testResponseDtoList;
    }

    public List<TestResponseDto> getSearch(Long id)
    {
        List<Test> testList = testRepository.findAllById(id);
        List<TestResponseDto> testResponseDtoList = new ArrayList<TestResponseDto>();
        for(Test test : testList)
        {
            TestResponseDto testResponseDto = new TestResponseDto(test);
            testResponseDtoList.add(testResponseDto);
        }
        return testResponseDtoList;
    }

    @Transactional
    public TestResponseDto testPost(TestRequestDto testRequestDto) {
        Test test = new Test(testRequestDto);
        Test saveTest = testRepository.save(test);
        return new TestResponseDto(saveTest);
    }
}
