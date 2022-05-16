package dewanTests;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.DewanLoginExcelReader;
import dewanPages.HomePage;
import dewanPages.UserLogOutPage;
import dewanPages.UserLoginPage;

public class UserLoginTestWithDDTUsingExcel extends TestBase{

	@DataProvider(name="exceldata")
	public Object[][]UserRegisterData() throws IOException
	{
		DewanLoginExcelReader ER=new DewanLoginExcelReader();
		return ER.GetExcelData();
	}
	UserLoginPage Loginobj;
	HomePage HomePageObj;
	UserLogOutPage LogoutObj;
	@Test(priority = 1,dataProvider = "exceldata")
	public void UserCanLogin(String username,String password) throws InterruptedException
	{
		Loginobj=new UserLoginPage(driver);
		HomePageObj=new HomePage(driver);

		Loginobj.USerLogin(username, password);
		Assert.assertTrue(HomePageObj.QuickSales.isDisplayed());
		Thread.sleep(20);
		LogoutObj=new UserLogOutPage(driver);
		LogoutObj.UserLogout();
		Thread.sleep(200);

	}
}
