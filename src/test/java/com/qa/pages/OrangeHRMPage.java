package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMPage {

	WebDriver Driver;
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement AdminLink;
	
	public void ClickOnAdminLink() {
		AdminLink.click();
	}
	
	@FindBy(id="menu_pim_viewPimModule")
	WebElement PIMLink;
	
	public void ClickOnPIMLink() {
		PIMLink.click();
	}
	
	@FindBy(id="menu_dashboard_index")
	WebElement DashBoardLink;
	
	public void ClickOnDashBoardLink() {
		DashBoardLink.click();
	}
	
	@FindBy(id="menu_directory_viewDirectory")
	WebElement DirectoryLink;
	
	public void ClickOnDirectoryLink() {
		DirectoryLink.click();
	}
	
	@FindBy(xpath="//*[@id=\"empsearch_employee_name_empName\"]")
	WebElement EmpNameField;
	public void EnterEmployeeName(String empName) {
		EmpNameField.clear();
		EmpNameField.sendKeys(empName);
	}
	
	@FindBy(xpath="//*[@id=\"searchBtn\"]")
	WebElement SearchBtn;
	
	public void ClickOnSearch() {
		SearchBtn.click();
	}
	
	@FindBy(id="menu_maintenance_purgeEmployee")
	WebElement MaintenanceLink;
	
	public void ClickOnMaintenanceLink() {
		MaintenanceLink.click();
	}
	
	
	@FindBy(id="txtUsername")
	WebElement userName;
	
	public void EnterUserName(String strUserName) {
		userName.clear();
		userName.sendKeys(strUserName);
	}
	
	public boolean CheckLoginDisplayed() {	
		return userName.isDisplayed();
	}
	
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	public void EnterPassword(String strPassword) {
		password.clear();
		password.sendKeys(strPassword);
	}
	
	@FindBy(id="btnLogin")
	WebElement LogIn;
	
	public void ClickOnLogInButton() {
		LogIn.click();
	}
	
	
	@FindBy(xpath="//b[contains(text(),'Dashboard')]")
    WebElement DashBoard;
    public String GetDashBoardConfirmation()
    {
        return DashBoard.getText();   
    }
    
    @FindBy(xpath="//*[@id=\"pdMainContainer\"]/div[1]/h1")
    WebElement MyInfo;
    public String GetMyInfoPageHeadertext()
    {
        return MyInfo.getText();   
    }
    
    @FindBy(xpath="//*[@id=\"menu_admin_UserManagement\"]")
    WebElement UserManagement;
    public boolean CheckAdminPageUserManagementTextExist() {
    	return UserManagement.isDisplayed();
    }
    
    @FindBy(xpath="//*[@id=\"menu_admin_Job\"]")
    WebElement Job;
    public boolean CheckAdminPageJobTextExist() {
    	return Job.isDisplayed();
    }
    
    @FindBy(xpath="//*[@id=\"menu_admin_Organization\"]")
    WebElement Organization;
    public boolean CheckAdminPageOrganizationTextExist() {
    	return Organization.isDisplayed();
    }
    
    @FindBy(xpath="//*[@id=\"menu_admin_Qualifications\"]")
    WebElement Qualifications;
    public boolean CheckAdminPageQualificationsTextExist() {
    	return Qualifications.isDisplayed();
    }
    
    @FindBy(xpath="//*[@id=\"content\"]/div[1]/div[1]/h1")
    WebElement SelectEmplyee;
    public String GetTimePageHeadertext()
    {
        return SelectEmplyee.getText();   
    }
    
    @FindBy(id="menu_admin_Job")
    WebElement JobLink;
    
    public void clickonJobLink() {
    	JobLink.click();
    }
    
    @FindBy(id="menu_time_viewTimeModule")
    WebElement LinkTime;
    
    public void clickOnTimeLink() {
    	LinkTime.click();
    }
    
    @FindBy(id="menu_pim_viewMyDetails")
    WebElement LinkMyInfo;
    
    public void clickOnMyInfoLink() {
    	LinkMyInfo.click();
    }
    
    
    @FindBy(id="menu_admin_viewJobTitleList")
    WebElement JobTitle;
    
    public String GetJobTitleText() {
    	return JobTitle.getText(); 
    }
    
    public String checkTitle() {
        return Driver.getTitle();
    }
    
    public String getURL() {
        return Driver.getCurrentUrl();
    }

    @FindBy(xpath="//*[@id=\"content\"]/div/div[1]/h1")
    WebElement DashBoardHeader;
    
    public String getDashBoardHeaderText() {
    	return DashBoardHeader.getText();
    }
    
    @FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr/td[4]/a")
    WebElement LastName;
    
    public String getLastNameText() {
    	return LastName.getText();
    }
    
    @FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr/td[3]/a")
    WebElement FirstName;
    
    public String getFirstNameText() {
    	return FirstName.getText();
    }
    
    
	public OrangeHRMPage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}
	
	
}