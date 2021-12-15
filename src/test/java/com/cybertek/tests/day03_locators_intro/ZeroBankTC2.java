package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankTC2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "http://zero.webappsecurity.com/login.html";
        driver.get(url);

        String testOfLink = driver.findElement(By.className("brand")).getText();
        System.out.println("testOfLink = " + testOfLink);
        String exp = "Zero Bank";

        if (testOfLink.equals(exp)){
            System.out.println("PASS: link text matched");
        }else {
            System.out.println("FAIL: link text miss matched");
        }

        String href = driver.findElement(By.className("brand")).getAttribute("href");
        System.out.println("href = " + href);

        //if (href.equals()) ...

        driver.quit();
    }
}
