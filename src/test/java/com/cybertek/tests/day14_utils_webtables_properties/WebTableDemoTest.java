package com.cybertek.tests.day14_utils_webtables_properties;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class WebTableDemoTest {
    WebDriver driver;
    String url = "http://practice.cybertekschool.com/tables";

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public void readFromTableTest() {
        // Print table data as a single String, Not
        WebElement table1 = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println("Table 1 text = " + table1.getText());

        //
        assertTrue(table1.getText().contains("tconway@earthlink.net"));

        WebElement allColNames = driver.findElement(By.xpath("//table[@id='table1']/thead/tr"));
        System.out.println("Column names = " + allColNames.getText());

        List<WebElement> colNamesList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        System.out.println("Columns count = " + colNamesList.size());

        for (WebElement colName : colNamesList) {
            System.out.println("colName = " + colName.getText());
        }

        // print first col + first cell data
        String xpath = "//table[@id='table1']/tbody/tr[1]/td[1]";
        WebElement firstRowCell = driver.findElement(By.xpath(xpath));
        System.out.println("firstRowCell = " + firstRowCell.getText());

        System.out.println("col 1 , row 4 = " + getCellData(1, 4));
        System.out.println("col 3 , row 3 = " + getCellData(3, 3));
    }

    @Test
    public void getAllColumnData() {
        // print all firstName
        String xpath = "//table[@id='table1']/tbody/tr/td[2]";
        List<WebElement> names = driver.findElements(By.xpath(xpath));

        System.out.println("-------ALL FIRST NAME-------");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(i + " - " + names.get(i).getText());
        }
        // print all Emails
        String EmailXpath = "//table[@id='table1']/tbody/tr/td[5]";
        List<WebElement> emails = driver.findElements(By.xpath(EmailXpath));

        System.out.println("-------ALL EMAILS-------");
        for (WebElement email : emails) {
            System.out.println("Email = " + email.getText());
        }

    }

    @Test
    public void printAllTableDataTest() {
        //get rows count and assign to rowsCount variable and print it
        int rowsCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        System.out.println("rowsCount = " + rowsCount);

        for (int r = 1; r <= rowsCount; r++) {
            for(int c = 1; c <= 6; c++) {
                String value = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+r+"]/td["+c+"]")).getText();
                System.out.println("value = " + value);
            }
        }

    }

    @Test
    public void readNeighborCell() {
        WebElement johnEmail = driver.findElement(By.xpath("//table[@id='table1']//td[.='John']/following-sibling::td[1]"));
        System.out.println("John's email = " + johnEmail.getText());

        WebElement johnsLastName = driver.findElement(By.xpath("//table[@id='table1']//td[.='John']/preceding-sibling::td[1]"));
        System.out.println("John's last name = " + johnsLastName.getText());
    }



    public String getCellData(int row, int col) {
        String xpathStr = "//table[@id='table1']/tbody/tr["+row+"]/td["+col+"]";
        return driver.findElement(By.xpath(xpathStr)).getText();
    }

}