package com.cybertek.tests.day19_page_object_model;

import com.cybertek.pages.BookManagementPage;
import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utils.BrowserUtils;
import com.cybertek.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class LibraryLoginPOMTest extends TestBase {
    @Test
    public void invalidCredentialsTest() throws Exception {
        driver.get(ConfigurationReader.getProperty("library.url"));
        //create object of LibraryLoginPage page object class
        LibraryLoginPage loginPage = new LibraryLoginPage();
        //access email WebElement and type the email
        loginPage.email.sendKeys("invalid_email@gmail.com");
        loginPage.password.sendKeys("randomPwd12");
        loginPage.signInBtn.click();
        //loginPage.errorMsg.getText();

        BrowserUtils.sleep(1);
        Assert.assertTrue(loginPage.errorMsg.isDisplayed());

    }

    @Test
    public void positiveLoginTest() {
        driver.get(ConfigurationReader.getProperty("library.url"));
        LibraryLoginPage loginPage = new LibraryLoginPage();
        loginPage.email.sendKeys(ConfigurationReader.getProperty("library3.email"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("library3.password"));
        loginPage.signInBtn.click();

        // Book management page step: verify is correct page, verify label is displayed
        BookManagementPage bookManagementPage = new BookManagementPage();
        assertTrue(bookManagementPage.bookManagementHeader.isDisplayed());
        bookManagementPage.isCurrentPage();

    }


}
