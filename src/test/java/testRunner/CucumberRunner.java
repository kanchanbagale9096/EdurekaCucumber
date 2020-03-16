package testRunner;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.Constants;
import utilities.FileReaderManager;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature",
		// plugin = {"pretty", "html:target/cucumber-html-report","json:cucumber.json"},
		
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:" },
		glue = { "stepDefinationFlow", "test" },
		tags = { "@End2End" }, 
		monochrome = true)

// to ignore test or tags in test runner use :
//  tags = { "~@End2End" }


// runner class should extend  "AbstractTestNGCucumberTests " class to execute framework in testng instead of junit
public class CucumberRunner extends AbstractTestNGCucumberTests{
	

	@BeforeClass
	public static void setUP() {
		
		System.out.println("inside setUP() :- @BeforeClass");
		 DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		 Date date = new Date();
		 String d=dateFormat.format(date);
		 String filename="Execution_Summary_"+d+".html";
		 System.out.println(filename);
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath(Constants.reportPath +filename);
	}

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10" + " 64 Bit");
		Reporter.setSystemInfo("Selenium", "3.8.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");

	}

}
