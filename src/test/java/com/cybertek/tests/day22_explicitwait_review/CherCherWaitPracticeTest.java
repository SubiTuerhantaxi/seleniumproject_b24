package com.cybertek.tests.day22_explicitwait_review;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CherCherWaitPracticeTest extends TestBase {

    @BeforeMethod
    public void gotoHomePage() {
        driver.get(ConfigurationReader.getProperty("chercher.url"));
    }

    @Test
    public void waitForAlertTest() {
        WebElement openAlertBtn = driver.findElement(By.id("alert"));
        openAlertBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(alertIsPresent());

        //
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void waitForButtonEnabledTest() {

        WebElement button = driver.findElement(By.id("disable"));
        System.out.println("cher cher button enable = " + button.isEnabled()); // false

        // click on Enable button
        WebElement enableBtn = driver.findElement(By.id("enable-button"));
        enableBtn.click();

        // wait until the button is enabled
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(button));

        System.out.println("cher cher button enable = " + button.isEnabled());

    }

    @Test
    public void waitForCheckBoxIsCheckedTest() {

    }



}
