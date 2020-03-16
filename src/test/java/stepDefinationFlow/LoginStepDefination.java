
package stepDefinationFlow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import locators.Loginlocators;
import utilities.ConfigFileReader;
import utilities.Driver_Setup;
import utilities.WrapperMethods;

public class LoginStepDefination {
	
	public WebDriver driver;
	ConfigFileReader configFileReader;
	WrapperMethods method = new WrapperMethods();
	
	public LoginStepDefination()
	{
		//configFileReader= new ConfigFileReader();
		//initialize the driver with any driver name
		Driver_Setup n = new Driver_Setup();
		//here we need to provide the browser type 
		//1. CHROME
		//2. FIREFOX
		//3. IE
		driver = n.initializeTestBaseSetup("CHROME");
		
	}
	public void userNavigateToSite() throws Throwable 
	{
		configFileReader= new ConfigFileReader();
		//call application url
		driver.get(configFileReader.getApplicationUrl());
		//driver.navigate().to("https://www.edureka.co/");
		Thread.sleep(2000);
	}


	public void signInClick() throws Throwable {
		
		System.out.println("click on SignIN link");
		Thread.sleep(500);
		method.Clickbtn(driver, Loginlocators.signLink, "SignIN link");
		//driver.findElement(By.xpath("//a[@class='signin top-signin giTrackElementHeader hidden-xs']")).click();
		Thread.sleep(200);

	}

	public void enterUserNameAndPassword(String email, String password) throws Throwable {
		System.out.println("inside email_and_Password()");
		method.inputText(driver,Loginlocators.inpEmail, email, "Email id");
		method.inputText(driver,Loginlocators.inpPassword, password, "Email id");
		Thread.sleep(200);
	}

	
	public void clickLoginBtn() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button[@class='clik_btn_log btn-block']")).click();
	}

	
	public void loginSuccessful() throws Throwable {
		if (driver.getCurrentUrl().equalsIgnoreCase("https://www.edureka.co/")) {
			System.out.println("Test Pass");
		} else {
			System.out.println("Test Failed");
		}
		//close the  browser
		this.closeBrowser();
	}
	
	public void closeBrowser() 
	{
		driver.close();
	}

}