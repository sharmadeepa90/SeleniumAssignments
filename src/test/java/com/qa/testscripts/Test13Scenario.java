package com.qa.testscripts;


import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.pages.OrangeHRMPage;

public class Test13Scenario extends testBase {
	WebDriver driver;
	OrangeHRMPage OrangeOR;
	public static FileInputStream fileLoc;
	public static Properties prop;
		
	@BeforeTest
	public void OpenUrlWithBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sharmadeep\\Selenium\\chromedriver.exe");  
	    WebDriver driver=new ChromeDriver();  
	    driver.get(" https://opensource-demo.orangehrmlive.com/");
	    driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void LogInToApp() throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}

	// test 13:
	@Test
	public void validateEmployeeSearch() throws Exception {
		String stringURL;
		String LName;
		String FName;
		OrangeOR.ClickOnPIMLink();
		stringURL=OrangeOR.getURL();
		Assert.assertTrue(stringURL.contains("pim"));
		
		OrangeOR.EnterEmployeeName("Linda Anderson");
		OrangeOR.ClickOnSearch();
		
		FName=OrangeOR.getFirstNameText();
		LName=OrangeOR.getLastNameText();
		boolean fNameresult = FName.contains("Linda");
		boolean lNameresult = LName.contains("Anderson");
		if(fNameresult & lNameresult)  {
			
            captureScreenshot(driver,"Search Success");
            Assert.assertTrue(true); 
            Reporter.log("Search Success", true);
		}
		else {
            captureScreenshot(driver,"Search Failed");
            Assert.assertTrue(false); 
            Reporter.log("Name not found in search", true);
		}
		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}