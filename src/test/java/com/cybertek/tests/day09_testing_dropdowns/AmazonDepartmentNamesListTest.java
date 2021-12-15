package com.cybertek.tests.day09_testing_dropdowns;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
// import all static method/Variable of Assert class
import static org.testng.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDepartmentNamesListTest {
    String url = "https://www.amazon.com";
    WebDriver driver; // can use in every method

    @BeforeClass
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void amazonDepartmentTest() throws InterruptedException {
        String expTitle = "Amazon.com. Spend less. Smile more.";

        assertEquals(driver.getTitle(), expTitle);

        // assert
        Select departments = new Select(driver.findElement(By.id("searchDropdownBox")));
        String selectedOption = departments.getFirstSelectedOption().getText();
        assertEquals(selectedOption, "All Departments");

        List<WebElement> allDepartments = departments.getOptions();
        int countOfDepartments = allDepartments.size();
        System.out.println("countOfDepartments = " + countOfDepartments);
        assertTrue(countOfDepartments > 10, "Department names are missing");

        // loop and print all available options
        for (WebElement dept : allDepartments) {
            System.out.println(dept.getText());
        }
        System.out.println("=========================USING FOREACH METHOD + LAMBDA EXPRESSION ===");
        allDepartments.forEach(dept -> System.out.println(dept.getText()));

        // select each item by order and wait for 400 ms ib between
        for (WebElement dept : allDepartments) {
            departments.selectByVisibleText(dept.getText());
            // Thread.sleep(400);
        }

    }



    @Test(enabled = false) // skip this test
    public void testDemo() {
        System.out.println("testDemo is running");
    }



}
