package dewanTests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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

	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void StartDriver()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver = new ChromeDriver(chromeOption()); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("http://bdms.dewansoft.com/test/Account/LogIn?ReturnUrl=%2Ftest%2F");
		
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
