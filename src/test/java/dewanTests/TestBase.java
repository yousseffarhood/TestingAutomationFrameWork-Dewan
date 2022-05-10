package dewanTests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;

public class TestBase {
	public static WebDriver driver;
	public static String downloadPath = System.getProperty("user.dir")+"\\downloads";

	public static ChromeOptions chromeOption() 
	{
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options ; 		
	}
	/*public static FirefoxOptions firefoxoption() 
	{
		FirefoxOptions options2 = new FirefoxOptions();
		HashMap<String, Object> firefoxPrefs = new HashMap<String, Object>();
		firefoxPrefs.put("profile.default.content_settings.popups", 0);
		firefoxPrefs.put("download.default_directory", downloadPath);
		options2.setCapability("prefs", firefoxPrefs);
		options2.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options2 ; 		
	}*/

	@SuppressWarnings("deprecation")
	@BeforeSuite
	@Parameters({"browser"})
	public void StartDriver(@Optional("chrome") String BrowserName)
	{	
		if (BrowserName.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver = new ChromeDriver(chromeOption()); 
		} 
		else if ( BrowserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://bdms.dewansoft.com/beta");
		
	}
	@AfterSuite
	public void StopDriver()
	{
		driver.quit();
	}
	@AfterMethod
	public void ScreenShotOnFailure(ITestResult result)
	{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		System.out.println("failed");
		System.out.println("Taking Screenshot...");
		Helper.CaptureScreenShot(driver, result.getName());

	}
	}
}
