package stepdefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import gherkin.formatter.model.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AddNewCustomerPage;
import pageObject.AdminPage;
import utilities.ReadConfig;

public class StepDefination extends Base{
	
	//@Before will execute before every scenario
	@Before
	public void setUp() throws Exception {
		
		System.out.println("SetUp method execution");
		
		readConfig=new ReadConfig();//create object of ReadConfig Java class
		
		String browser=readConfig.getBrowser();
		
		if (browser.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
		} else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			
			Thread.sleep(2000);
		}else if(browser.equalsIgnoreCase("IE")) {
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}
		
		
		
	}
	
	
	
	//coding snippet

	@Given("User launch Chrome Browser")
	public void user_launch_chrome_browser() throws Exception {
		
		//driver=new ChromeDriver();
		
		//create object of AdminPage java class
		
		ad=new AdminPage(driver);
		Thread.sleep(2000);
				
	    
		
	}

	@When("User open url {string}")
	public void user_open_url(String url) throws Exception {
		
		driver.get(url);
	   Thread.sleep(2000);
	}

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) throws Exception {
	   
		ad.setUsername(email);
		Thread.sleep(2000);
		ad.setPassword(password);
		Thread.sleep(2000);
	}

	@When("User click on Login button")
	public void user_click_on_login_button() throws Exception {
	    ad.clickOnLogin();
	    Thread.sleep(2000);
	}

	

		@Then("User verify page title should be {string}")
		public void user_verify_page_title_should_be(String title) throws Exception {
			Assert.assertEquals(driver.getTitle(), title);
			Thread.sleep(2000);
		  
		}
		
		@Then("close browser")
		public void close_browser() throws Exception {
		   driver.close();
		   Thread.sleep(2000);
		
		}
		
		// new new Customer snippet //add new customer
		
		@Then("User can view dashboard")
		public void user_can_view_dashboard() throws Exception {
			addCust=new AddNewCustomerPage(driver);
			Assert.assertEquals("pageObject.AddNewCustomerPage@3cae7b8b",addCust);
			Thread.sleep(2000);
		   
		}

		@When("User click on customer menu")
		public void user_click_on_customer_menu() throws Exception {
			addCust.clickOnCustomerMenu();
			Thread.sleep(2000);
		}

		@When("User click on customer menu item")
		public void user_click_on_customer_menu_item() throws Exception {
			addCust.clickOnCustomerMenuItem();
			Thread.sleep(2000);
		}

		@When("User click on new add button")
		public void user_click_on_new_add_button() throws Exception {
			addCust.clickOnAddNew();
			Thread.sleep(2000);
		}

		@Then("User can view and add customer page")
		public void user_can_view_and_add_customer_page() throws Exception {
			Thread.sleep(2000);
			Assert.assertEquals("Add a new customer / nopCommerce administration",addCust);
		}

		
		  
			@When("User enter customer info as {string} and {string} and {string} and {string} and {string} and\"{int}\"and \"ABC\" and \"Testcase1\"")
			public void user_enter_customer_info_as_and_and_and_and_and_and_abc_and_testcase1(String newEmail, String newPassword, String firstName, String lastName, String gender, Integer int1,String compName,String adminComment) throws Exception {
				Thread.sleep(2000); 
				addCust.setEmail(newEmail); 
				addCust.setPass(newPassword);
				addCust.setFirstName(firstName);
				addCust.setLastName(lastName);
				addCust.setGender(gender);
				addCust.enterDob("8/23/1985");
				addCust.setCompanyName(compName);
				addCust.setAdminComment(adminComment);
				
				
							
		}

		@When("User click on save button")
		public void user_click_on_save_button() throws Exception {
			addCust.clickOnSave();
			Thread.sleep(2000);
		}

		@Then("User can view configuration msg {string}")
		public void user_can_view_configuration_msg(String string) throws Exception {
			
		}


	
	
	
	@After
	public void tearDown(io.cucumber.java.Scenario sc) throws Exception {
		System.out.println("Tear down method execute after each testcase scenario");
		
		if(sc.isFailed()==true) {
			
		String filewithpath="C:\\Users\\Sunita\\eclipse-workspace\\10thJulyCucumberMavenProject\\screenshot\\failedScreenshot.png";
		
		//convert WEbdriver object into Takescreenshot
		
		TakesScreenshot scrshot=(TakesScreenshot)driver;
		
		//call getScreenshotAs() to store image file
		
		File srcFile=scrshot.getScreenshotAs(OutputType.FILE);
		
		File destFile=new File(filewithpath);
		
		FileUtils.copyFile(srcFile, destFile);
		
		
	}
		Thread.sleep(2000);
		driver.quit();
	
	}
	
}
