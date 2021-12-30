package dewanTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dewanPages.HomePage;
import dewanPages.QS_SalesOperationPage;
import dewanPages.QuickSalesPage;
import dewanPages.UserLogOutPage;
import dewanPages.UserLoginPage;

public class QS_SalesOperationTest extends TestBase{
	String username="youssef";
	String password="1234";
	UserLoginPage Loginobj;
	HomePage HomePageObj;
	QuickSalesPage QSobj;
	QS_SalesOperationPage SalesObj;
	UserLogOutPage LogoutObj;
	//FIlter Of Contact
	String ProductName="a";

	@Test(priority = 1)
	public void UserCanLogin()
	{
		Loginobj=new UserLoginPage(driver);
		HomePageObj=new HomePage(driver);

		Loginobj.USerLogin(username, password);
		Assert.assertTrue(HomePageObj.QuickSales.isDisplayed());
	}

	@Test(priority = 2)
	public void EnterQuickSalesApp() throws InterruptedException
	{
		HomePageObj=new HomePage(driver);
		HomePageObj.OpenQuickSales();
		QSobj=new QuickSalesPage(driver);
		Assert.assertTrue(QSobj.WelcomeInQuickSales.getText().equalsIgnoreCase("Welcome in BDMS Quick Sales App."));

	}
	@Test(priority = 3)
	public void UserCanOpenSalesTransaction()
	{	
		QSobj=new QuickSalesPage(driver);
		QSobj.OpenSalesOperation();
		SalesObj=new QS_SalesOperationPage(driver);
		Assert.assertTrue(SalesObj.AssertOnTheCurrentPage.isDisplayed());
	}
	@Test(priority = 4)
	public void UserCanFilterSalesData() throws InterruptedException  
	{
		SalesObj=new QS_SalesOperationPage(driver);
		SalesObj.FillContact(ProductName);
		Assert.assertTrue(SalesObj.AssertContactFilter.isDisplayed());
		Thread.sleep(2000);
		SalesObj.JournalFilter();
		SalesObj.PaymentTypeFilter();
		SalesObj.PaymentStatusFilter();
		SalesObj.StatusFilter();
		SalesObj.DateFilter("1/11/2021", "30/11/2021");
		SalesObj.ClickOnSearch();
		Assert.assertTrue(SalesObj.NoOfRows.getText().contains("Number Of Rows : 5"));

	}
	@Test(priority = 5)
	public void UserCanExportToExcel()
	{
		SalesObj.ClickOnExportToExcel();
	}
	@Test(priority = 6)
	public void GetAllDataInTheTable()
	{	
		SalesObj.GetNoOfRows();
		SalesObj.GetTableData();

	}
	
	
	@Test(priority = 8)
	public void UserCanLogout() throws InterruptedException
	{
		LogoutObj=new UserLogOutPage(driver);

		LogoutObj.UserLogout();
		Assert.assertTrue(LogoutObj.LogoutAssertion.getText().contentEquals("Login Using Your Username And Password"));
	}
}
