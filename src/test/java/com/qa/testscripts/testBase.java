package com.qa.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class testBase {
//pre requisites are coded
	
	public WebDriver Driver;
	public static FileInputStream fileLoc;
	public static Properties prop;
	
	@Parameters({"browser"})
	@BeforeClass
public void setUp(String browser)

{
		try
		{
			fileLoc=new FileInputStream("D:\\SeleniumTraining\\com.qa.devlabs.selenium\\Configuration\\config.properties");
			prop=new Properties();
			prop.load(fileLoc);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	     System.setProperty("webdriver.chrome.driver", "C:\\Users\\sharmadeep\\Downloads\\chromedriver.exe");
	        Driver.get("http://www.amazon.in");
	        Driver = new ChromeDriver();
	        Driver.manage().window().maximize();
	        Driver.manage().deleteAllCookies();
	        Driver.get(prop.getProperty("url"));
		
}

	@AfterClass
public void tearDown()
{
	Driver.quit();
}
	
	public  void captureScreenshot(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) Driver;
		File Src=ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"/Screenshots/" + tname + ".png");
		//FileUtils.copyFile(Src, dest);
		System.out.println("Screen shot is captured");
	}
	
}
