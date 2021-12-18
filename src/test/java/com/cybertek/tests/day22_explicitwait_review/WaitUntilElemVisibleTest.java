package com.cybertek.tests.day22_explicitwait_review;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitUntilElemVisibleTest extends TestBase {
    @Test
    public void waitForWebDriverElem() {
        driver.get(ConfigurationReader.getProperty("seleniumpractice.url"));
        WebElement startTimer= driver.findElement(By.xpath("//button[@onclick='timedText()']"));
        startTimer.click();
        // <p id="demo">WebDriverWait</p> wait until this is visible
        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[.='WebDriver']")));
//        System.out.println("WEBDRIVER is now visible");

        wait.until(ExpectedConditions.textToBe(By.id("demo") , "WebDriver"));
    }

    @Test
    public void cheapInternetSpeedTest() {
        driver.get(ConfigurationReader.getProperty("speedtest.url"));
        WebDriverWait wait = new WebDriverWait(driver, 60);
          //wait until Finding message disappears
//        WebElement findingLabel = driver.findElement(By.xpath("//div[.='Finding optimal server...']"));
//        wait.until(ExpectedConditions.invisibilityOf(findingLabel));
        //wait until "change server" link is displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Change Server")));

        //click on Go button
        WebElement go = driver.findElement(By.className("start-text"));
        go.click();

        //wait until element with class gauge-speed-needle disappears
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("gauge-speed-text")));

        WebElement speedElem = driver.findElement(By.className("gauge-speed-text"));
        //
        wait.until(ExpectedConditions.visibilityOf(speedElem));
        //
        wait.until(ExpectedConditions.visibilityOf(speedElem));


    }

}
