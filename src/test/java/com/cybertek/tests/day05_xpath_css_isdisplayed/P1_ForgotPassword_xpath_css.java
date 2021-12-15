package com.cybertek.tests.day05_xpath_css_isdisplayed;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_ForgotPassword_xpath_css {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");


        // home
                                                          //<a class="nav-link" href="/">Home</a>
        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        // <h2>Forgot Password</h2>
        WebElement forgotPassword = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        WebElement emailLabel;
        WebElement emailField;
        WebElement retrievePasswordBth;
        WebElement poweredByLabel;

        System.out.println("homeLink = " + homeLink.isDisplayed());



    }
}
