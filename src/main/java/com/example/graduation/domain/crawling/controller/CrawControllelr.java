package com.example.graduation.domain.crawling.controller;

import com.example.graduation.domain.crawling.entity.Craw;
import com.example.graduation.domain.crawling.service.CrawService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CrawControllelr {
    private final CrawService crawService;
    @GetMapping("/craw")
    public List<Craw> getCraw()
    {
        return crawService.getCraw();
    }

    @PostMapping("/crawling")
    public void crawling()
    {
        crawService.crawling();
    }
}
