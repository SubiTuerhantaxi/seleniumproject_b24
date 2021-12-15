package com.cybertek.practice;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LibraryTask {

    WebDriver driver;
    String url = "https://library3.cybertekschool.com/login.html";

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void libraryTest() {
        driver.findElement(By.id("inputEmail")).sendKeys("librarian1259@library ");
        driver.findElement(By.id("inputPassword")).sendKeys("q6OOPRlm ");
        driver.findElement(By.xpath("//button[@class='btn btn-lg btn-primary btn-block']")).click();

    }

}
