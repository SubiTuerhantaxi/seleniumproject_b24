package com.cybertek.tests.day17_upload_js_executor;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Guru99UploadTest extends TestBase {
    @Test
    public void uploadFileTest() throws Exception {
        driver.get(ConfigurationReader.getProperty("guru99upload.url"));

        WebElement chooseFileElem = driver.findElement(By.id("uploadfile_0"));
        WebElement terms = driver.findElement(By.id("terms"));
        WebElement submitFileButton = driver.findElement(By.id("submitbutton"));

        chooseFileElem.sendKeys(System.getProperty("user.home") + "/Downloads/some-file.txt");
        terms.click();
        submitFileButton.click();

        BrowserUtils.sleep(2);

        // verify upload successfully uploaded
        WebElement resultMsg = driver.findElement(By.id("res"));
        assertEquals(resultMsg.getText(),"1 file\nhas been successfully uploaded.");

    }
}
