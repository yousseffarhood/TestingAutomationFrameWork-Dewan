package dewanTests;

import org.testng.annotations.Test;

import dewanPages.UserLogOutPage;

public class UserLogoutTest extends TestBase{
	UserLogOutPage LogoutObj;
	@Test(priority = 1)
	public void UserCanLogout() throws InterruptedException
	{
		LogoutObj=new UserLogOutPage(driver);
		LogoutObj.UserLogout();
	}

}
