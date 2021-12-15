package com.cybertek.tests.day18_actions_pom_intro;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsDemoTest extends TestBase {

    @Test
    public void hoverElementTest() throws Exception {
        driver.get(ConfigurationReader.getProperty("hover.url"));
        WebElement image1 = driver.findElement(By.xpath("(//img)[1]"));

        //create Actions class object to be able to hover over image
        Actions actions = new Actions(driver);

        //hover over image1
        actions.moveToElement(image1).perform();

        BrowserUtils.sleep(1);

        WebElement image2 = driver.findElement(By.xpath("(//img)[2]"));
        actions.moveToElement(image2).perform();

        BrowserUtils.sleep(1);

        WebElement image3 = driver.findElement(By.xpath("(//img)[3]"));
        actions.moveToElement(image3).perform();

        for (int i = 1; i <= 3; i++) {
            WebElement image = driver.findElement(By.xpath("(//img)[" + i +"]"));
            actions.moveToElement(image).perform();
            BrowserUtils.sleep(1);
        }

    }

    @Test
    public void hoverOverGroupOfElements() throws Exception {
        driver.get(ConfigurationReader.getProperty("hover.url"));
        List<WebElement> images = driver.findElements(By.tagName("img"));
        for (WebElement img : images) {
            BrowserUtils.sleep(1);
            actions.moveToElement(img);
            actions.perform();

        }
    }

    @Test
    public void googleFeelingLuckyBtnHoverTest() throws Exception {
        driver.get(ConfigurationReader.getProperty("google.url"));
        WebElement searchBtn = driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@value='Google Search']"));
        WebElement feelingLuckBtn = driver.findElement(By.id("gbqfbb"));

//        actions.moveToElement(feelingLuckBtn).perform();
//        BrowserUtils.sleep(1);
//        actions.moveToElement(searchBtn).perform();

        for (int i = 1; i <= 5; i++) {
            actions.moveToElement(feelingLuckBtn).perform();
            BrowserUtils.sleep(1);
            actions.moveToElement(searchBtn).perform();
            BrowserUtils.sleep(1);
        }

    }

}
