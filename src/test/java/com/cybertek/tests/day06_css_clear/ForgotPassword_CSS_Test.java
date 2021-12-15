package com.cybertek.tests.day06_css_clear;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword_CSS_Test {
    public static void main(String[] args) throws InterruptedException {
        String appUrl= "http://practice.cybertekschool.com/forgot_password";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
        driver.get(appUrl);

        //input[name='email']
        WebElement emailField = driver.findElement(By.cssSelector("input[name='email']"));
        emailField.sendKeys("student1@gmail.com");
        // wait 1 second and clear it
        Thread.sleep(1234);
        emailField.clear(); // clear and empty
        emailField.sendKeys("student2@gmail.com");

        // loop
        for (int i = 3; i < 10; i++){
            Thread.sleep(1000);

            emailField.clear();
            emailField.sendKeys("student" + i + "@gmail.com");
        }








    }
}
