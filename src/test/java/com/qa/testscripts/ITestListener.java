package com.qa.testscripts;


import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.OrangeHRMPage;

public class ITestListener extends testBase {
	public static WebDriver driver;
	OrangeHRMPage OrangeOR;
	public static FileInputStream fileLoc;
	public static Properties prop;

	
	
	@Parameters({"browser"})
	@BeforeSuite
	public void setUp(String browser) {
		
		try {
			fileLoc = new FileInputStream(System.getProperty("user.dir"));
			prop = new Properties();
			prop.load(fileLoc);
		}catch(Exception e) {
			e.printStackTrace();
		}
				
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir"));
			driver = new ChromeDriver();
		} 
		
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
	}
	
	
	@Test(priority=1)
	public void LogInToApp() throws Exception {
		try {
			fileLoc = new FileInputStream("C:\\Users\\sharmadeep\\eclipse-workspace\\com.qa.devlabs.selenium\\src\\test\\java\\com\\qa\\utilities\\Testdata.properties");
			prop = new Properties();
			prop.load(fileLoc);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		OrangeOR=new OrangeHRMPage(driver);
		
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		OrangeOR.EnterUserName(username);
		OrangeOR.EnterPassword(password);
		OrangeOR.ClickOnLogInButton();
		Thread.sleep(3000);
		String strURL;
		strURL=OrangeOR.getURL();
		Assert.assertTrue(strURL.contains("dashboard"));
		Reporter.log("Log in Successfull and Dashboard page is displayed", true);
	}
	
		
	@Test(priority=2 , retryAnalyzer=com.qa.listener.RetryAnalyzer.class)
    public void ListenerFunction() throws Exception   {
		String HeaderText;
		HeaderText=OrangeOR.getDashBoardHeaderText();
		boolean result = HeaderText.equalsIgnoreCase("Dashboard");
		if(result) {
			Thread.sleep(4000);
            captureScreenshot(driver,"DashBoard navigation has been Passed");
            Assert.assertTrue(true); 
            Reporter.log("User is in Dashboard Menu", true);
		}
		else {
			int i = 1; 
            captureScreenshot(driver,"DashBoard page validation Failed  = "+ i);
            Assert.assertTrue(false); 
            Reporter.log("User is NOT in the Dashboard page", true);
            i++;
		}
			
		
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
   
}