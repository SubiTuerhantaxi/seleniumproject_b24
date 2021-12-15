package com.cybertek.tests.day09_testing_dropdowns;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MultiSelectDropDown {
    String url = "http://practice.cybertekschool.com/dropdown";
    WebDriver driver; // can use in every method

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }


    @Test
    public void selectMultipleLanguageTest() throws InterruptedException {
        Select language = new Select(driver.findElement(By.name("Languages")));
        language.selectByVisibleText("Java");
        language.selectByVisibleText("JavaScript");
        language.selectByVisibleText("Python");

        System.out.println("languages.isMultiple() = " + language.isMultiple());

        Thread.sleep(1234);
        // un check all
        language.deselectAll();

        for (WebElement each : language.getOptions()) {
            each.click();
        }
    }

}
