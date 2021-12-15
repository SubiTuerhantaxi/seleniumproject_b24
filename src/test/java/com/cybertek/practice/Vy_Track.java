package com.cybertek.practice;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Vy_Track {

    String url = "https://qa2.vytrack.com/";
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void vy_track() throws InterruptedException {
        WebElement userName = driver.findElement(By.name("_username"));
        userName.sendKeys("user10");

        WebElement passWord = driver.findElement(By.name("_password"));
        passWord.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.click();

        Thread.sleep(1234);

        String expTitle = "Dashboard";
        String actTitle = driver.getTitle();
        Assert.assertEquals(expTitle,actTitle);

        Thread.sleep(1234);;

        WebElement FleetDropdown = driver.findElement(By.xpath("//span[@class='title title-level-1']"));
        FleetDropdown.click();
        WebElement VehiclesModule = driver.findElement(By.xpath("//span[.='Vehicles']"));
        VehiclesModule.click();

        Thread.sleep(1234);

        String expTitleVehicle = "Car - Entities - System - Car - Entities - System";
        String actTitleVehicle = driver.getTitle();
        Assert.assertEquals(expTitleVehicle,actTitleVehicle);

        Thread.sleep(1234);

        WebElement ResetButton = driver.findElement(By.xpath("//a[@title='Reset']"));
        ResetButton.click();

        Assert.assertTrue(driver.findElement(By.xpath("//a[@title='Reset']")).isEnabled());


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
