package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Test3OrangeHRMPageWithXpathAndCSS {

	WebDriver Driver;
	
	@FindBy(xpath="//*[@id=\"txtUsername\"]")
	WebElement userNameWithXpath;
	
	@FindBy(css="#txtUsername")
	WebElement userNameWithCSS;
	
	public boolean CheckUserNamWithXpathDisplayed() {	
		return userNameWithXpath.isDisplayed();
	}
	
	public boolean CheckUserNamWithCSSDisplayed() {	
		return userNameWithCSS.isDisplayed();
	}
	
	
	@FindBy(xpath="//*[@id=\"txtPassword\"]")
	WebElement passwordWithXpath;
	
	@FindBy(css="#txtPassword")
	WebElement passwordWithCSS;
	
	public boolean CheckPasswordWithXpathDisplayed() {	
		return passwordWithXpath.isDisplayed();
	}
	
	public boolean CheckPasswordWithCSSDisplayed() {	
		return passwordWithCSS.isDisplayed();
	}
	
	
	@FindBy(xpath="//*[@id=\"forgotPasswordLink\"]/a")
	WebElement ForgotPasswordWithXpath;
	
	@FindBy(css="#forgotPasswordLink > a")
	WebElement ForgotPasswordWithCSS;
	
	public boolean CheckForgotPasswordWithXpathDisplayed() {	
		return userNameWithXpath.isDisplayed();
	}
	
	public boolean CheckForgotPasswordWithCSSDisplayed() {	
		return userNameWithCSS.isDisplayed();
	}
	
	@FindBy(xpath="//*[@id=\"footer\"]/div[1]/a")
	WebElement FooterLinkWithXpath;
	
	@FindBy(css="#footer > div:nth-child(1) > a")
	WebElement FooterLinkWithCSS;
	
	public boolean CheckFooterLinkWithXpathDisplayed() {	
		return FooterLinkWithXpath.isDisplayed();
	}
	
	public boolean CheckFooterLinkWithCSSDisplayed() {	
		return FooterLinkWithCSS.isDisplayed();
	}
	
	@FindBy(xpath="//*[@id=\"divLogo\"]/img")
	WebElement LogoIMGWithXpath;
	
	@FindBy(css="#divLogo > img")
	WebElement LogoIMGWithCSS;
	
	public boolean CheckLogoImageWithXpathDisplayed() {	
		return LogoIMGWithXpath.isDisplayed();
	}
	
	public boolean CheckLogoImageWithCSSDisplayed() {	
		return LogoIMGWithCSS.isDisplayed();
	}
	
	@FindBy(xpath="//*[@id=\"social-icons\"]/a[2]/img")
	WebElement FooterImageFBWithXpath;
	
	@FindBy(css="#social-icons > a:nth-child(2) > img")
	WebElement FooterImageFBWithCSS;
	
	public boolean CheckFooterImageFBWithXpathDisplayed() {	
		return FooterImageFBWithXpath.isDisplayed();
	}
	
	public boolean CheckFooterImageFBWithCSSDisplayed() {	
		return FooterImageFBWithCSS.isDisplayed();
	}
	
	public Test3OrangeHRMPageWithXpathAndCSS(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}
	
	
}