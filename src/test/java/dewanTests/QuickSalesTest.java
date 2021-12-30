package dewanTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dewanPages.HomePage;
import dewanPages.QS_SalesOperationPage;
import dewanPages.QuickSalesPage;
import dewanPages.UserLoginPage;

public class QuickSalesTest extends TestBase {
	
	HomePage Homepageobj;
	QuickSalesPage QSObj;
	QS_SalesOperationPage SalesObj;
	UserLoginPage UserLoginObj;
	String username="youssef";
	String password="1234";
	@Test(priority = 1)
	public void UserCanOpenSalesTransaction() throws InterruptedException
	{	UserLoginObj=new UserLoginPage(driver);
	UserLoginObj.USerLogin(username, password);
		Homepageobj =new HomePage(driver);
		Homepageobj.OpenQuickSales();
		QSObj=new QuickSalesPage(driver);
		QSObj.OpenSalesOperation();
		SalesObj=new QS_SalesOperationPage(driver);
		Assert.assertTrue(SalesObj.AssertOnTheCurrentPage.isDisplayed());
	}

}
