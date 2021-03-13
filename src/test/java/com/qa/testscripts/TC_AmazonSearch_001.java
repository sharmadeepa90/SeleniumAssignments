package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.qa.pages.AmazonPages;

public class TC_AmazonSearch_001 extends testBase {
	
	AmazonPages AmazonOR;
	
	
	public void loadPages()
	{
		AmazonOR=new AmazonPages(Driver);
	}
	
	
	
	@Test
	public void searchItem() throws IOException
	{
		
		AmazonOR.SetCategoryList("Books");
		AmazonOR.setSearchInput("Da Vinci code");
		AmazonOR.setMagnifierBtn();
		String title = Driver.getTitle();
		boolean res = title.contains("Da vinci code");
		if(res) {
			Assert.assertTrue(true);
			Reporter.log("Title is correct", true);
		}else {
			captureScreenshot(Driver,"searchItem");
			Assert.assertTrue(false);
			Reporter.log("Title is not correct", true);
		
	}
	}
}


