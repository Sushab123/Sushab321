package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {

	
	//add locators and user defined methods in this file and we call this method in step defination file
	
	public WebDriver ldriver;
	
	public AddNewCustomerPage(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(rdriver,this);
		
	}
	
	//web elements
	
	//@FindBy(xpath = "//input[@id='Email']")
	//WebElement txtEmail;
	
	//@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	//WebElement lnkCustomer_menu;
	
	//locator with the help of "By"
	By lnkCustomer_menu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	
	By lnkCustomer_menu_item =By.xpath("//p[text()=' Customers']");
	
	By btnAddNew=By.xpath("//a[@class='btn btn-primary']");
	
	By txtEmail=By.xpath("//input[@id='Email']");
	
	By txtPass=By.xpath("//input[@id='Password']");
	
	By txtFirstName=By.xpath("//input[@id='FirstName']");
		
	By txtLastName=By.xpath("//input[@id='LastName']");
	
	By rdMaleGender=By.id("Gender_Male");
	
	By rdFemaleGender=By.id("Gender_Female");
	
	By txtDob=By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName=By.xpath("//input[@id='Company']");
	
	By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave=By.xpath("//button[@name='save']");
	
	
	//user defined methods
	
	public String getPageTitle() {
		return ldriver.getTitle();		
		
	}
	
	public void clickOnCustomerMenu() {
		ldriver.findElement(lnkCustomer_menu).click();
	}
	
	public void clickOnCustomerMenuItem() {
		
		ldriver.findElement(lnkCustomer_menu_item).click();;
			}
	
	public void clickOnAddNew() {
		ldriver.findElement(btnAddNew).click();;
	}
	
	public void setEmail(String email) {
		ldriver.findElement(txtEmail).sendKeys(email);
		
		
	}
	public void setPass(String password) {
		ldriver.findElement(txtPass).sendKeys(password);
	}
	
	public void setFirstName(String fName) {
		ldriver.findElement(txtFirstName).sendKeys(fName);
	}
	public void setLastName(String lName) {
		ldriver.findElement(txtLastName).sendKeys(lName);
	}
	
	public void setGender(String gender) {
		if(gender.equals("male")) {
			ldriver.findElement(rdMaleGender).click();
		}else { ldriver.findElement(rdFemaleGender).click();;
			
		}
		}
	
	
	public void enterDob(String dob) {
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	
	
	
	
	public void setCompanyName(String comName) {
		ldriver.findElement(txtCompanyName).sendKeys(comName);
		
	}
	
	public void setAdminComment(String content) {
		ldriver.findElement(txtAdminContent).sendKeys(content);
	
	}
	
	public void clickOnSave() {
		ldriver.findElement(btnSave).click();
		
	}
	
	
	
}
