package com.cybertek.tests.day13_faker_practice_browserutil_properties;

import com.cybertek.utils.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class RegistrationFormNegativeTest extends RegistrationFormTesBase{
    @Test
    public void invalidFirstnameTest() throws Exception {
        //
        //
        WebElement signUp = driver.findElement(By.id("wooden_spoon"));
        signUp.click();

        BrowserUtils.sleep(2);

        WebElement errorMsg = driver.findElement(By.xpath("//small[.='first name is required']"));
        assertTrue(errorMsg.isDisplayed(),"Error message is not displayed");

        //
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("12345");

        BrowserUtils.sleep(2);

        WebElement noNumbersMsg = driver.findElement(By.xpath("//small[.='first name can only consist of all alphabetical letters']"));
        assertTrue(noNumbersMsg.isDisplayed(), "Error message is not displayed");






    }


}
