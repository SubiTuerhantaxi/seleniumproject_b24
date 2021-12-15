package com.cybertek.tests.day07_findElements;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorAddTest {
    public static void main(String[] args) throws InterruptedException {
        String appUrl= "https://www.calculator.net";
        int num1 = 5, num2 = 3,  expectedResult = 8;
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // driver.manage().window().maximize();
        driver.get(appUrl);

        // Locate 4 elements “5”, “3”, “+” , “=” using css or xpath and store into WebElement objects
        WebElement numOneElem = driver.findElement(By.cssSelector("span[onclick='r(5)']"));
        WebElement numTwoElem = driver.findElement(By.cssSelector("span[onclick='r(3)']"));
        WebElement add1Elem = driver.findElement(By.xpath("//span[.='+']"));
        WebElement add2Elem = driver.findElement(By.xpath("//span[text()='=']"));

        numOneElem.click();
        Thread.sleep(1234);
        add1Elem.click();
        Thread.sleep(1234);
        numTwoElem.click();
        Thread.sleep(1234);
        add2Elem.click();

        // Locate result area and store into webElement object
        WebElement result = driver.findElement(By.cssSelector("div[id='sciOutPut']")); // #sciOutPut

        System.out.println(num1 + " + " + num2 + " = " + result.getText());
        String resultValue = result.getText();

        resultValue = resultValue.trim();
        // convert from String to int
        int actualResult = Integer.parseInt(resultValue);

        if (actualResult == expectedResult){
            System.out.println("Pass: calculation match");
        } else {
            System.out.println("Fail: calculation mismatch");
        }

        driver.quit();






    }
}
