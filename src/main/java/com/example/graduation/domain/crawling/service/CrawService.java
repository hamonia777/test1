package com.example.graduation.domain.crawling.service;

import com.example.graduation.domain.crawling.entity.Craw;
import com.example.graduation.domain.crawling.repository.CrawRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CrawService {
    private final CrawRepository crawRepository;
    public List<Craw> getCraw() {
        return crawRepository.findAll();
    }

    public void crawling() {
        // ChromeDriver 경로 설정 (ChromeDriver 경로로 바꿔야 함)
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver-win64/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // Headless 모드 설정
        options.addArguments("--no-sandbox"); // 권장: 서버 환경에서 사용 시
        options.addArguments("--disable-dev-shm-usage"); // 권장: 리소스 절약용
        // 브라우저 자동화 실행
        WebDriver driver = new ChromeDriver(options);

        int j = 0;
        try {
            // Google Trends 페이지로 이동
            driver.get("https://trends.google.co.kr/trending?geo=KR&hl=ko&hours=24");

            List<String> trends = new ArrayList<>();
            List<String> trends2 = new ArrayList<>();
            Thread.sleep(2000); // 필요한 경우 조정 가능

            // 100개의 트렌드를 가져오기 위해 4페이지를 순환
            for (int i = 0; i < 4; i++) {
                // 페이지의 트렌드 요소 가져오기
                List<WebElement> elements = driver.findElements(By.className("mZ3RIc"));
                List<WebElement> elements2 = driver.findElements(By.className("lqv0Cb"));

                // 각 트렌드의 텍스트 추출
                for (WebElement element : elements) {
                    trends.add(element.getText());
                }
                for (WebElement element : elements2) {
                    trends2.add(element.getText());
                }
                // 다음 페이지 화살표 클릭 (페이지 넘기기)
                WebElement nextButton = driver.findElement(By.xpath("//div[contains(@class,'pYTkkf') and contains(@class,'Bz112c') and contains(@class,'RLmnJb')]"));
                if (nextButton != null && nextButton.isDisplayed()) {
                    nextButton.click();
                } else {
                    break; // 더 이상 다음 페이지가 없으면 종료
                }

                // 페이지가 로드되는 동안 잠시 대기
                Thread.sleep(2000); // 필요한 경우 조정 가능
            }

            // 모든 트렌드 출력
            for(int i=0; i< 100;i++)
            {
                System.out.println(trends.get(i) + " " + trends2.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 브라우저 종료
            driver.quit();
        }
    }
}
