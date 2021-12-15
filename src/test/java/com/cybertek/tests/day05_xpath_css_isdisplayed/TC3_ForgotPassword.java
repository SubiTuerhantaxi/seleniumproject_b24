package com.cybertek.tests.day05_xpath_css_isdisplayed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC3_ForgotPassword {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // enter
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("fobij33932@cyadp.com");

        // click
        WebElement retrievePwsPassword = driver.findElement(By.id("form_submit"));
        retrievePwsPassword.click();

        //read
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("email_sent")){
            System.out.println("PASS: email_sent url verified");
        } else {
            System.out.println("FAIL: email_sent url verified");
        }

        // verify Your e_mail...
        WebElement message = driver.findElement(By.name("confirmation_message"));
        System.out.println("message displayed = " + message.getText());

        String expMessage = "Your e-mail's been sent!";
        String actMessage = message.getText();
        if (actMessage.equals(expMessage)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        System.out.println("'Name' attribute value of message element = " + message.getAttribute("name"));

        driver.quit();






    }
}
