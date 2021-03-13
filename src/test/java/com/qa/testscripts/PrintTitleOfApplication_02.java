package com.qa.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintTitleOfApplication_02 {

	    public static void main(String[] args) {  
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sharmadeep\\Selenium\\chromedriver.exe");  
	        WebDriver driver=new ChromeDriver();  
	        driver.get(" https://opensource-demo.orangehrmlive.com/");
	        String Title="OrangeHRM";
	        
	      String title=  driver.getTitle();
	      System.out.println(title);
	      if(title.contentEquals(Title)) {
	    	  System.out.println("test case passed");
	      }
	      else
	    	  System.out.println("failed");
	        System.out.println(title);

       driver.manage().window().maximize(); 
       driver.close();
       
       

    }  

  }  


