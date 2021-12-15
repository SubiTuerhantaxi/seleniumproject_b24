package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMapsXpathTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        String url = "https://www.google.com/maps/";
        driver.get(url);
        WebElement addressField = driver.findElement(By.xpath("/html/body/div[3]/div[9]/div[3]/div[1]/div[1]/div[1]/div[2]/form/div/div[3]/div/input[1]"));
        addressField.sendKeys("cybertek school" + Keys.ENTER);

        Thread.sleep(4000);
        // click on direction
        WebElement direction = driver.findElement(By.xpath("/html/body/div[3]/div[9]/div[8]/div/div[1]/div/div/div[4]/div[1]/button/span/img"));
        direction.click();

        WebElement startingAddressField = driver.findElement(By.xpath("//input[@placeholder='Choose starting point, or click on the map...']"));
        startingAddressField.sendKeys("Houston, Texas" + Keys.ENTER);



    }
}
