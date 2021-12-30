package dewanTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dewanPages.HomePage;
import dewanPages.UserLogOutPage;
import dewanPages.UserLoginPage;

public class UserLoginTest extends TestBase{

	String username="youssef";
	String password="1234";
	UserLoginPage Loginobj;
	HomePage HomePageObj;
	UserLogOutPage LogoutObj;
	@Test(priority = 1)
	public void UserCanLogin()
	{
		Loginobj=new UserLoginPage(driver);
		HomePageObj=new HomePage(driver);

		Loginobj.USerLogin(username, password);
		Assert.assertTrue(HomePageObj.QuickSales.isDisplayed());
	}
	@Test(priority = 2)
	public void UserCanLogout() throws InterruptedException
	{
		LogoutObj=new UserLogOutPage(driver);
		LogoutObj.UserLogout();
	}
}
