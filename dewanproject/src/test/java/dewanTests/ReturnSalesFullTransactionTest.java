package dewanTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dewanPages.HomePage;
import dewanPages.QuickSalesPage;
import dewanPages.ReturnSalesCreateFullTransactionPage;
import dewanPages.UserLogOutPage;
import dewanPages.UserLoginPage;

public class ReturnSalesFullTransactionTest extends TestBase {
	UserLoginPage LoginObj;
	UserLogOutPage LogoutObj;
	HomePage HomeObj;
	ReturnSalesCreateFullTransactionPage RSObj;
	QuickSalesPage QSObj;

	String username="youssef";
	String password="1234";
	String Contact="التجاريون لاداره الخدمات المتكاملة AMIS - فرع العباسية";
	String Date="11/11/2021";
	String QuantityNumber="1";
	String DateFrom="11/11/2021";
	String DateTo="18/1/2022";
	String Note= "This note is from the test automation framework note :)";
	String Value="20";
	String Value2="32";

	@Test(priority = 1)
	public void UserCanLogin()
	{
		LoginObj=new UserLoginPage(driver);
		HomeObj=new HomePage(driver);
		LoginObj.USerLogin(username, password);
		Assert.assertTrue(HomeObj.QuickSales.isDisplayed());
	}

	@Test(priority = 2)
	public void EnterQuickSalesApp() throws InterruptedException
	{
		HomeObj=new HomePage(driver);
		HomeObj.OpenQuickSales();
		QSObj=new QuickSalesPage(driver);
		System.out.println(QSObj.WelcomeInQuickSales.getText());
		Assert.assertTrue(QSObj.WelcomeInQuickSales.getText()
				.equalsIgnoreCase("Welcome in BDMS Quick Sales App."));

	}
	@Test(priority = 3)
	public void OpenRS()
	{
		QSObj=new QuickSalesPage(driver);
		QSObj.OpenReturnSalesOperation();

	}
	@Test(priority = 4)
	public void RSFullTransaction() throws InterruptedException
	{
		RSObj=new ReturnSalesCreateFullTransactionPage(driver);
		RSObj.FirstStageInRS(Contact, Date);
		Thread.sleep(2500);
		RSObj.SecondStageInRS(DateFrom, DateTo, QuantityNumber);
		RSObj.ThirdStageInRSCR(Note, Value);
		Assert.assertTrue(RSObj.AssertCR.getText().contains("Created successfully"));
		RSObj.BackFromThirdStageUnRSCR();
		RSObj.FourthStageInRSConfirmTransaction();
		Assert.assertTrue(RSObj.AssertConfirmTransaction.getText()
				.contains("Transaction has been confirmed successfully ..."));
		RSObj.FifthStageInRSPayment(Value2);
		Assert.assertTrue(RSObj.AssertConfirmPayments.getText().
				contains("Created successfully"));
		RSObj.BackFromFifthStageInRSPayment();
	}

	@Test(priority = 5)
	public void UserCanLogout() throws InterruptedException
	{
		LogoutObj=new UserLogOutPage(driver);
		LogoutObj.UserLogout();
	}

}
