package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver_Setup {

	public WebDriver driver;
	public String driverPath = Constants.driverPath;
	public String TC_ID = null;
	public String Url = null;
	public String browser_Type = null;
	public Properties prop;
	public FileInputStream fis;

	public WebDriver initIEDriver() {
		System.out.println("Launching Internet Explorer with new profile..");
		System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
		
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		cap.setCapability("nativeEvents", false);
		cap.setCapability("unexpectedAlertBehaviour", "accept");
		cap.setCapability("ignoreProtectedModeSettings", true);
		cap.setCapability("enable-popup-blocking", true);
		cap.setCapability("enablePersistentHover", true);
		cap.setCapability("ignoreZoomSetting", true);
		cap.setJavascriptEnabled(true);
		driver = new InternetExplorerDriver(cap);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver initChromeDriver() throws IOException {
		System.out.println("Launching google chrome with new profile..");
		
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		driver.manage().window().maximize();
		//driver.navigate().to(appURL);
		return driver;
	}

	public WebDriver initFirefoxDriver() {
		System.out.println("Launching Firefox browser..");
		System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		//driver.navigate().to(appURL);
		return driver;
	}

	// @Parameters({ "browserType", "appURL","tcID" })

	public WebDriver initializeTestBaseSetup(String browserType) {
		try {
			// browserType=CHROME
			switch (browserType) 
			{
			case "IE":
				driver = initIEDriver();
				break;
			case "CHROME":
				System.out.println("hiiie im in chrome");
			
				driver = initChromeDriver();
				break;
			case "FIREFOX":
				System.out.println("hi I am in FFox");
				driver = initFirefoxDriver();
				break;
			default:
				System.out.println(
						"browser : " + browserType + " is invalid, Launching Chrome as default for execution...");
				driver = initChromeDriver();

				// TC_ID=tcID;
				//Url = appURL;
				browser_Type = browserType.toUpperCase();
			
			}
		
			
		} catch (Exception e) {
			System.out.println("Error while launching browser....." + e.getStackTrace());
			driver.close();
		}
		return driver;
	}
}