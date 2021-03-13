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

public class XpathAndCSS_Testcases14And15 {

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
	public void LoginToApp()  {
		   driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
	        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
	        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
	
	// test 15: Write Xpath Selector of highlighted Rectangular object (in Red)
	@Test(priority=2)
	public void ElementsWithXpath() {
		String strText;
		Boolean ObjectExist;
		ObjectExist= driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		strText=driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]")).getText();
		Reporter.log("Text Displayed for the Admin Menu Item as :'" + strText +"'", true);
		
		ObjectExist= driver.findElement(By.xpath("//*[@id=\"dashboard-quick-launch-panel-menu_holder\"]/table/tbody/tr/td[2]/div")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		strText=driver.findElement(By.xpath("//*[@id=\"dashboard-quick-launch-panel-menu_holder\"]/table/tbody/tr/td[2]/div")).getText();
		Reporter.log("Text Displayed for the Leave List ICON as :'" + strText +"'", true);
		
			
		ObjectExist= driver.findElement(By.xpath("//*[@id=\"welcome\"]")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		strText=driver.findElement(By.xpath("//*[@id=\"welcome\"]")).getText();
		Reporter.log("Text Displayed for Welcome message as :'" + strText +"'", true);
		
		ObjectExist= driver.findElement(By.xpath("//*[@id=\"MP_btn\"]")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		strText=driver.findElement(By.xpath("//*[@id=\"MP_btn\"]")).getText();
		Reporter.log("Text Displayed for the market place button as :'" + strText +"'", true);
	}
	
	// test 14 : Write CSS Selector of highlighted Rectangular object (in Red)
	@Test(priority=1)
	public void ElementsWithCSS(){
		String strText;
		Boolean ObjectExist;
		
		ObjectExist= driver.findElement(By.cssSelector("#menu_pim_viewPimModule > b")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		strText=driver.findElement(By.cssSelector("#menu_pim_viewPimModule > b")).getText();
		Reporter.log("Text Displayed for the PIM Menu Item as :'" + strText +"'", true);
		
		ObjectExist= driver.findElement(By.cssSelector("#menu_time_viewTimeModule > b")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		strText=driver.findElement(By.cssSelector("#menu_time_viewTimeModule > b")).getText();
		Reporter.log("Text Displayed for the Time Menu Item as :'" + strText +"'", true);
		
		ObjectExist= driver.findElement(By.cssSelector("#menu_maintenance_purgeEmployee > b")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		strText=driver.findElement(By.cssSelector("#menu_maintenance_purgeEmployee > b")).getText();
		Reporter.log("Text Displayed for the Miaintenance Menu Item as :'" + strText +"'", true);
		
		ObjectExist= driver.findElement(By.cssSelector("#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(1) > div")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		strText=driver.findElement(By.cssSelector("#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(1) > div")).getText();
		Reporter.log("Text Displayed for Assign Leave message as :'" + strText +"'", true);
				
		ObjectExist= driver.findElement(By.cssSelector("#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(3) > div")).isDisplayed();
		Assert.assertTrue(ObjectExist);
		strText=driver.findElement(By.cssSelector("#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(3) > div")).getText();
		Reporter.log("Text Displayed for Timesheet message as :'" + strText +"'", true);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}	
	
}