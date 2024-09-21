package com.example.graduation.domain.test.controller;

import com.example.graduation.domain.test.dto.request.TestRequestDto;
import com.example.graduation.domain.test.dto.response.TestResponseDto;
import com.example.graduation.domain.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("/test")
    public List<TestResponseDto> getTest()
    {
        List<TestResponseDto> testResponseDtoList = testService.getTest();
        return testResponseDtoList;
    }
    @GetMapping("/testSearch")
    public List<TestResponseDto> getSearch(@RequestParam Long id)
    {
        List<TestResponseDto> testResponseDtoList = testService.getSearch(id);
        return testResponseDtoList;
    }

    @PostMapping("/testPost")
    public TestResponseDto testPost(@RequestBody TestRequestDto testRequestDto)
    {
        return testService.testPost(testRequestDto);
    }
}
