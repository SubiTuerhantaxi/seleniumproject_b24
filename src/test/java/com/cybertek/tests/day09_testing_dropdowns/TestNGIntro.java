package com.cybertek.tests.day09_testing_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGIntro {
    // can be used by each test
    String url = "https://www.etsy.com";

    @BeforeClass
    public void setUp() {
        System.out.println("@BeforeClass setUp method ....");
        System.out.println("Opened browser and Navigating to " + url);
        System.out.println("======================================================");
    }

    @BeforeMethod
    public void setUpApp() {
        System.out.println("@BeforeMethod setUpApp method is running ... ");
        System.out.println("Navigating back to " + url);
        System.out.println("===============================================");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("@AfterMethod tearDown is running ... ");
        System.out.println("========================================");
    }

    @AfterClass
    public void cleanUp() {
        System.out.println("@AfterClass setUp method ....");
        System.out.println("========================================");

    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("Running My Test 1 ...");
        int num = 10;
        Assert.assertEquals(10,num);
    }

    @Test(priority = 2) // converts regular method to Test method
    public void myTest2() {
        System.out.println("Running My Test 2 ...");
        String name = "Bob";
        Assert.assertTrue(name.contains("o"));
    }

}
