package com.cybertek.practice;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ActionClass_Practice extends TestBase {


    @Test
    public void hoverTest() throws Exception {

        List<WebElement> images = driver.findElements(By.tagName("img"));
        for (WebElement img : images) {
            BrowserUtils.sleep(1);
            actions.moveToElement(img);
            actions.perform();
            BrowserUtils.sleep(1);
            Assert.assertTrue(driver.findElement(By.tagName("img")).isDisplayed());
        }

    }

    @Test
    public void contextClick() throws Exception {

        driver.get(ConfigurationReader.getProperty("herokuapp.url"));
        WebElement box = driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();
        driver.switchTo().alert().accept();

    }

    @Test
    public void TC17_Drag_N_Drop() throws Exception {

        driver.get(ConfigurationReader.getProperty("kendo_ui.url"));
        BrowserUtils.sleep(2);
        WebElement smallCircle = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement bigCircle = driver.findElement(By.xpath(("//div[@id='droptarget']")));
        actions.dragAndDrop(smallCircle, bigCircle).perform();
        Assert.assertEquals(bigCircle.getText(), "You did great!");

    }


}
