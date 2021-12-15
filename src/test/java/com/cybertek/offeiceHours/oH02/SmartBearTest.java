package com.cybertek.offeiceHours.oH02;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class SmartBearTest {

    @Test
    public void LoginTest() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        // driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        // page Title before login
        String expectedTitle = "Web Orders Login";
        String actualTitle = driver.getTitle();
        System.out.println(expectedTitle.equalsIgnoreCase(actualTitle));

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement passWord = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        passWord.sendKeys("test" + Keys.ENTER);

        // check the title after login

        String extTitleLogin = "Web Orders";
        String actTitleLogin = driver.getTitle();
        System.out.println(extTitleLogin.equalsIgnoreCase(actTitleLogin));

        driver.quit();
    }

/*
Test Case 2:
After login
 - click on Check All button
 - verify that all check buttons are selected
 - click on Uncheck All button
 - verify that all buttons are unchecked
 - select one of the check box and delete that row
 - verify that row of information is deleted
*/

    @Test
    public void checkBoxTest() throws InterruptedException {


            WebDriver driver = WebDriverFactory.getDriver("chrome");
            // driver.manage().window().maximize();
            driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

            // page Title before login
            String expectedTitle = "Web Orders Login";
            String actualTitle = driver.getTitle();
            System.out.println(expectedTitle.equalsIgnoreCase(actualTitle));

            WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
            userName.sendKeys("Tester");
            WebElement passWord = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
            passWord.sendKeys("test" + Keys.ENTER);

            //
            WebElement checkAllButton = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
            checkAllButton.click();

            //
            List<WebElement> allCheckBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
            for (WebElement eachCheckBox : allCheckBoxes) {
                if (eachCheckBox.isSelected()== false){
                    System.out.println("Not All selected");
                    break;
                }
            }

            WebElement unCheckAllButton = driver.findElement(By.id("ctl00_MainContent_btnUncheckAll"));
            unCheckAllButton.click();

            allCheckBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
            for (WebElement eachCheckBox : allCheckBoxes){
                if (eachCheckBox.isSelected()!=true){
                    System.out.println("Not All check boxes unselected");
                    break;
                }
            }

        allCheckBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println("Before I delete : " + allCheckBoxes.size());

        WebElement itemForDeleting = driver.findElement(By.xpath("//tr//td[.='Paul Brown']/../td[1]/input"));
        itemForDeleting.click();

        Thread.sleep(3000);

        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteButton.click();

        allCheckBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println("After I delete : " + allCheckBoxes.size());








        }


    }
