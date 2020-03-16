package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.cucumber.listener.Reporter;
import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	public static WebDriver driver;

	@Before
	// assigned author
	public void beforeScenario(Scenario scenario) {
		System.out.println("beforeScenario");
		Reporter.assignAuthor("Cucumber Extent Reporting : Kanchan");
	}
	
	public void beforeScenarioReport(Scenario scenario)
    {
		System.out.println("beforeScenarioReport");
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String fileName = scenario.getName() + "-" + timeStamp;
        ExtentReports extent = new ExtentReports ( "src/test/resources/Reports/" + fileName+ ".html", true);
    }
	
	

	@After
	  public void embedScreenshot(Scenario scenario) 
	{
		System.out.println("embedScreenshot");
	       
        if(scenario.isFailed()) {
        try {
        	 scenario.write("Current Page URL is " + driver.getCurrentUrl());
//            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
         
         
    }
}
}