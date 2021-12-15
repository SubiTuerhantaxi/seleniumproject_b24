package com.cybertek.tests.day13_faker_practice_browserutil_properties;

import com.cybertek.utils.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RegistrationFormTest extends RegistrationFormTesBase{

    Faker faker = new Faker();

    @Test
    public void formTest() {
        driver.findElement(By.name("firstname")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("lastname")).sendKeys(faker.name().lastName());

        enterUserName(faker.name().username().replace(".",""));

        driver.findElement(By.name("email")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.name("password")).sendKeys(faker.internet().password());

        WebElement mobile = driver.findElement(By.name("phone"));
        mobile.sendKeys(faker.phoneNumber().cellPhone()
                .replace("(","")
                .replace(")","")
                .replace(".","-")
                .replace(" ",""));

        driver.findElement(By.xpath("//*[@value='male']")).click();
        driver.findElement(By.name("birthday")).sendKeys("01/01/1990");

        Select department = new Select(driver.findElement(By.name("department")));
        department.selectByIndex(faker.number().numberBetween(1,9));

        Select jobTitle = new Select(driver.findElement(By.name("job_title")));
        jobTitle.selectByIndex(faker.number().numberBetween(1,8));

        List<WebElement> languages = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement eachLang : languages){
            eachLang.click();
        }

        driver.findElement(By.id("wooden_spoon")).click();

        //WebElement heading = driver.findElement(By.className("alert_heading"));
        //Assert.assertEquals(heading.getText(), "Well done!");
        //Assert.assertTrue(heading.isDisplayed());
    }

    public void enterUserName(String userName) {
        WebElement userNameField = driver.findElement(By.name("username"));
        userNameField.sendKeys(userName);
    }
}
