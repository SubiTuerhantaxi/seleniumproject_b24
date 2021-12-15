package com.cybertek.tests.day11_alerts_ifrsme_windows;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertExamplesTest {

    WebDriver driver;
    String url = "http://practice.cybertekschool.com/javascript_alerts";

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void infoAlertTest() {
        //
        WebElement alertLink = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alertLink.click();
        // switch to
        Alert alert = driver.switchTo().alert();
        System.out.println("Text of Alert = " + alert.getText());
        assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();

        //
        WebElement resultMsg = driver.findElement(By.id("result"));
        System.out.println("resultMsg.getText() = " + resultMsg.getText());
        assertEquals(resultMsg.getText(), "You successfuly clicked an alert");
    }

    @Test
    public void confirmAlertTest() {
        // click on JS Confirm link
        WebElement jsConfirmBtn = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsConfirmBtn.click();
        // switch to alert then assert the text is "I am a JS Confirm"
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Confirm alert test = " + confirmAlert.getText());
        assertEquals(confirmAlert.getText(), "I am a JS Confirm");
        // click on cancel
        confirmAlert.dismiss();
        //assert result message is "You clicked: Cancel"'
        WebElement resultMsg = driver.findElement(By.id("result"));
        System.out.println("resultMsg.getText() = " + resultMsg.getText());
        assertEquals(resultMsg.getText(), "You clicked: Cancel");

    }

    @Test
    public void promAlert() {
        //click on JS prompt button
        //switch to alert and assert/confirm the text is "I am a JS prompt"
        //enter "hello" and click on Ok
        //assert "You entered: hello" message is displayed

        WebElement jsPromptBtn = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPromptBtn.click();

        Alert promptAlert = driver.switchTo().alert();
        System.out.println("Prompt alert test = " + promptAlert.getText());
        assertEquals(promptAlert.getText(), "I am a JS prompt");
        promptAlert.sendKeys("Hello");
        promptAlert.accept();

        WebElement resultMsg = driver.findElement(By.id("result"));
        System.out.println("resultMsg.getText() = " + resultMsg.getText());
        assertEquals(resultMsg.getText(), "You entered: Hello");

    }



}
