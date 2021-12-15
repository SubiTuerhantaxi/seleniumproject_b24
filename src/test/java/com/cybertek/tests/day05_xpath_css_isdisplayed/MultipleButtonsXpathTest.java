package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MultipleButtonsXpathTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        // <button class="btn btn-primary" onclick="button1()">Button 1</button>
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();

        //<p id="result" style="color:green">Clicked on button one!</p>
        WebElement resultMsg = driver.findElement(By.xpath("//p[@id='result']"));
        System.out.println(resultMsg.getText());

        // locate button2 using xpath and check if it is currently displayed on the page, then click on it
        //<button class="btn btn-primary" onclick="button2()" name="button2">Button 2</button>
        //By.xpath("//button[.='Button 2']")
        WebElement button2 = driver.findElement(By.xpath("//button[text()='Button 2']"));
        if (button2.isDisplayed()){
            System.out.println("pass");
            button2.click();
        }else {
            System.out.println("fail");
        }

        driver.quit();






    }
}
