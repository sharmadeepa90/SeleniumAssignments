package com.qa.testscripts;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.OrangeHRMPage;

public class Annotations_06To10 {
	
	public static WebDriver driver;
	OrangeHRMPage OrangeOR;
	
	
	//testcase 9 :  Write a method (avoid using Test annotation) to minimize the window.
	public void MinimizeBrowser() {
		Point p = driver.manage().window().getPosition();
		Dimension d = driver.manage().window().getSize();
		driver.manage().window().setPosition(new Point((d.getHeight()-p.getX()), (d.getWidth()-p.getY())));
	} 
	
	
	//testcase 6 : Launch a browser in @Beforesuite annotation and open url .
	
	@Parameters({"browser"})
	@BeforeSuite
	public void setUp() {
		

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sharmadeep\\Selenium\\chromedriver.exe");  
	    WebDriver driver=new ChromeDriver();  
	    driver.get(" https://opensource-demo.orangehrmlive.com/");
	    driver.manage().window().maximize();
		// Used constructor for Minimize the browser without using annotation test 9
		Annotations_06To10 NewConst=new Annotations_06To10();
		NewConst.MinimizeBrowser();
		
		
	}
	
	// testcase 7 : Login to application again in @Test method, set priority 1 of the same method After logging
	@Test(priority=1)
	public void LoginToApp()  {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	}
	
	
	//testcase 8 : Write Test method and page title for different menus- in order(Admin, PIM, Leave Dashboard, Directory and Maintenance)
	@Test(priority=2)
	public void ClickOnTabsAndValidateTitle() throws InterruptedException {
		String strTitle;
		String strURL;
		
		
		OrangeOR.ClickOnAdminLink();
		Thread.sleep(3000);
		strTitle=OrangeOR.checkTitle();
		Reporter.log("Title of the Page is :'" + strTitle +"'", true);
		strURL=OrangeOR.getURL();
		Assert.assertTrue(strURL.contains("admin"));
		
		
		OrangeOR.ClickOnPIMLink();
		Thread.sleep(3000);
		strTitle=OrangeOR.checkTitle();
		strURL=OrangeOR.getURL();
		Reporter.log("Title of the Page is :'" + strTitle +"'", true);
		Assert.assertTrue(strURL.contains("pim"));
		
		OrangeOR.ClickOnDashBoardLink();
		Thread.sleep(3000);
		strTitle=OrangeOR.checkTitle();
		strURL=OrangeOR.getURL();
		Reporter.log("Title of the Page is :'" + strTitle +"'", true);
		Assert.assertTrue(strURL.contains("dashboard"));
		
		
		
		OrangeOR.ClickOnDirectoryLink();
		Thread.sleep(3000);
		strTitle=OrangeOR.checkTitle();
		strURL=OrangeOR.getURL();
		Reporter.log("Title of the Page is :'" + strTitle +"'", true);
		Assert.assertTrue(strURL.contains("directory"));
		
		OrangeOR.ClickOnMaintenanceLink();
		Thread.sleep(3000);
		strTitle=OrangeOR.checkTitle();
		strURL=OrangeOR.getURL();
		Reporter.log("Title of the Page is :'" + strTitle +"'", true);
		Assert.assertTrue(strURL.contains("maintenance"));
	}
	
	/// Testcase 10 : Read Dashboard heading using [driver.findelement(by.xpath()).gettext()].
	@Test(priority=3)
	public void ReadDashBoardHeader() throws InterruptedException {
		/// test 10
		String strText;
		OrangeOR.ClickOnDashBoardLink();
		Thread.sleep(3000);
		strText=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1")).getText();
		Reporter.log("Text Displayed for the Header of the DashBoard page as :'" + strText +"'", true);
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
}