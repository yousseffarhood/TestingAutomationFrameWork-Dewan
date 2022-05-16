package dewanTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import dewanPages.HomePage;
import dewanPages.QuickSalesPage;
import dewanPages.ReturnPurchaseSearchByFiltersPage;
import dewanPages.UserLogOutPage;
import dewanPages.UserLoginPage;

public class ReturnPurchaseFillFiltersDataTest extends TestBase{
	UserLoginPage LoginObj;
	HomePage HomeObj;
	QuickSalesPage QSPageObj;
	ReturnPurchaseSearchByFiltersPage RPObj;
	String UserName="youssef";
	String Password="1234";
	String Contact="التجاريون لاداره الخدمات المتكاملة AMIS";
	String DateFrom="7/10/2021";
	String DateTo="9/1/2022";
	UserLogOutPage LogOutObj;
	@Test(priority = 1)
	public void FillFilterTest() throws InterruptedException
	{
		LoginObj=new UserLoginPage(driver);
		LoginObj.USerLogin(UserName, Password);
		HomeObj=new HomePage(driver);
		HomeObj.OpenQuickSales();
		QSPageObj=new QuickSalesPage(driver);
		QSPageObj. OpenReturnPurchaseOperation();
		RPObj=new ReturnPurchaseSearchByFiltersPage(driver);
		RPObj.FillTheFilterData(Contact, DateFrom, DateTo);

		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver,3);
		// presenceOfElementLocated condition
		w.until(ExpectedConditions.presenceOfElementLocated (By
				.xpath("//h4[contains(text(),'Number Of Rows : 8')]")));
	}
	@Test(priority = 2)
	public void ClickOnExportBtn() throws InterruptedException
	{
		RPObj.ClickOnExportBtn();
		Thread.sleep(5500);
	}
	@Test(priority = 3)
	public void LogOut() throws InterruptedException
	{	LogOutObj=new UserLogOutPage(driver);
		LogOutObj.UserLogout();
	}
}
