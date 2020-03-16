package test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import stepDefinationFlow.LoginStepDefination;

public class LoginTest {
	//create step defination object	
	LoginStepDefination loginObj = new LoginStepDefination();
	
	@Given("^user navigates to Site$")
	public void user_navigates_to_Site() throws Throwable {

		//Hooks.openBrowser();
		loginObj.userNavigateToSite();
		Thread.sleep(2000);
	}

	@Then("^click on SignIN link$")
	public void click_on_SignIN_link() throws Throwable {
		loginObj.signInClick();
		Thread.sleep(200);

	}

	@When("^I enter Username \"(.*?)\" and \"(.*?)\" Password$")
	public void i_enter_Username_and_Password(String arg1, String arg2) throws Throwable {
		loginObj.enterUserNameAndPassword(arg1, arg2);
	}

	@When("^I click on Login button$")
	public void i_click_on_Login_button() throws Throwable {
		loginObj.clickLoginBtn();
	}

	@Then("^login should be successful$")
	public void login_should_be_successful() throws Throwable {
		loginObj.loginSuccessful();
		
		
	}
	
	
}
