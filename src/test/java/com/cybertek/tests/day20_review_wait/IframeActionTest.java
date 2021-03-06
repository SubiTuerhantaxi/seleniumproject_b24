package com.cybertek.tests.day20_review_wait;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeActionTest extends TestBase {

    @Test
    public void test() throws Exception {

        driver.get(ConfigurationReader.getProperty("doubleclick.url"));

        //let's switch to iframe

        driver.switchTo().frame("iframeResult");

        WebElement textForDoubleClick = driver.findElement(By.id("demo"));

        // I already have my action object
        BrowserUtils.sleep(1); //Static wait
        actions.doubleClick(textForDoubleClick).perform();
        BrowserUtils.sleep(1);

        // Assert: Text's "style" attribute value contains "red"

        String expectedStyle = "red";
        String actualStyle = textForDoubleClick.getAttribute("style");

        Assert.assertTrue(actualStyle.contains(expectedStyle));







    }



}
