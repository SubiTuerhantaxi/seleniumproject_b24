package com.cybertek.tests.day08_implicitwait_checkbox_radio_testing;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class EtsyRadioCheckBoxTest {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://www.etsy.com";
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // driver.manage().window().maximize();

        // wait upto 10 seconds while finding
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        WebElement searchField = driver.findElement(By.name("search_query"));
        searchField.sendKeys("wooden spoon" + Keys.ENTER);

        WebElement allFilters = driver.findElement(By.id("search-filter-button"));
        allFilters.click();

        WebElement freeShipping = driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']"));
        freeShipping.click();
        WebElement onSale = driver.findElement(By.xpath("//label[@for='special-offers-on-sale']"));
        onSale.click();
        WebElement under25 = driver.findElement(By.xpath("//label[@for='price-input-1']"));
        under25.click();
        WebElement apply = driver.findElement(By.xpath("//button[@aria-label='Apply']"));
        apply.click();

        Thread.sleep(3000);

        WebElement resultCount = driver.findElement(By.xpath("//span[@class='wt-display-inline-flex-sm']/span[1]"));
        System.out.println("Result = " + resultCount.getText());

        driver.quit();


    }
}
