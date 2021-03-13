package com.qa.testscripts;

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



public class ValidateTextInAdminTab_05 {
	WebDriver driver;
	OrangeHRMPage OrangeOR;
	
	
		
	@BeforeTest
	public void OpenUrlWithBrowser() {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sharmadeep\\Selenium\\chromedriver.exe");  
	    WebDriver driver=new ChromeDriver();  
	    driver.get(" https://opensource-demo.orangehrmlive.com/");
	    driver.manage().window().maximize();
	}
	@BeforeClass
	public void LoginToApp() {
	
			driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
	        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
	        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}

	// test 5: Click on Admin Link in Home Page and validate following text -
	//• User Management
	//• Job
	//• Organization
	//• Qualifications
	@Test
	public void validateTextsAdminTab() {
		OrangeOR.ClickOnAdminLink();
		Assert.assertTrue(OrangeOR.CheckAdminPageUserManagementTextExist());
		Reporter.log("User Management Text Displayed on Admin Page", true);
		
		Assert.assertTrue(OrangeOR.CheckAdminPageJobTextExist());
		Reporter.log("JOB Text Displayed on Admin Page", true);
		
		Assert.assertTrue(OrangeOR.CheckAdminPageOrganizationTextExist());
		Reporter.log("Organization Text Displayed on Admin Page", true);
		
		Assert.assertTrue(OrangeOR.CheckAdminPageQualificationsTextExist());
		Reporter.log("Qualification Text Displayed on Admin Page", true);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}