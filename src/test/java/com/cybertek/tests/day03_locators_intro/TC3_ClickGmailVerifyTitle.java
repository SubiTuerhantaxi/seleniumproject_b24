package com.cybertek.tests.day03_locators_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_ClickGmailVerifyTitle {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver diver = new ChromeDriver();
        diver.manage().window().maximize();

        String url = "https://google.com";
        diver.get(url);
        // Find Gmail link and click on it
        diver.findElement(By.linkText("Gmail")).click();
        // diver.findElement(By.partialLinkText("Gmail")).click();
        //verify title contains/starts with Gmail
        String expectedTitle = "Gmail";
        String actualTitle = diver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("PASS: gmail title verification successful");
        }else {
            System.out.println("FAIL: gmail title verification failed");
        }

        // go back
        diver.navigate().back();

        String googleExpectedTitle = "Google";
        String googleActualTitle = diver.getTitle();

        if (googleActualTitle.equals(googleExpectedTitle)){
            System.out.println("PASS: Google title verification successful");
        }else {
            System.out.println("FAIL: Google title verification failed");
        }


        diver.quit();














    }
}
