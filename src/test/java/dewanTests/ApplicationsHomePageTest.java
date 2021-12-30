package dewanTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dewanPages.HomePage;
import dewanPages.QuickSalesPage;
import dewanPages.UserLoginPage;

public class ApplicationsHomePageTest extends TestBase {

	String username="youssef";
	String password="1234";
	UserLoginPage Loginobj;
	HomePage HomePageObj;
	QuickSalesPage QSobj;

	@Test(priority = 1)
	public void UserCanLogin()
	{
		Loginobj=new UserLoginPage(driver);
		HomePageObj=new HomePage(driver);
		Loginobj.USerLogin(username, password);
		Assert.assertTrue(HomePageObj.QuickSales.isDisplayed());
	}
	@Test(priority = 2,enabled = false)

	public void EnterQuickSalesApp() throws InterruptedException
	{
		HomePageObj=new HomePage(driver);
		HomePageObj.OpenQuickSales();
		QSobj=new QuickSalesPage(driver);
		System.out.println(QSobj.WelcomeInQuickSales.getText());
		Assert.assertTrue(QSobj.WelcomeInQuickSales.getText().equalsIgnoreCase("Welcome in BDMS Quick Sales App."));

	}
	@Test(priority = 3,enabled = true)
	public void EnterTasksAndWorkflowApp() throws InterruptedException
	{
		HomePageObj=new HomePage(driver);
		HomePageObj.OpenTasksAndWorkflow();
		Assert.assertTrue(HomePageObj.TasksAndWorkflow.isDisplayed());
	}
}
