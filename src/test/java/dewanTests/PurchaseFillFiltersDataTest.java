package dewanTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import dewanPages.HomePage;
import dewanPages.PurchaseSearchByFiltersPage;
import dewanPages.QuickSalesPage;
import dewanPages.ReturnSalesSearchByFilters;
import dewanPages.UserLogOutPage;
import dewanPages.UserLoginPage;

public class PurchaseFillFiltersDataTest extends TestBase{
	UserLoginPage LoginObj;
	HomePage HomeObj;
	QuickSalesPage QSPageObj;
	ReturnSalesSearchByFilters RSObj;
	PurchaseSearchByFiltersPage PurObj;
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
		QSPageObj. OpenPurchaseOperation();
		PurObj=new PurchaseSearchByFiltersPage(driver);
		PurObj.FillTheFilterData(Contact, DateFrom, DateTo);
		
		@SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver,3);
	      // presenceOfElementLocated condition
	      w.until(ExpectedConditions.presenceOfElementLocated (By
	    		  .xpath("//h4[contains(text(),'Number Of Rows : 11')]")));
	}
	@Test(priority = 2)
	public void ClickOnExportBtn() throws InterruptedException
	{
		PurObj.ClickOnExportBtn();
		Thread.sleep(5500);
	}
}
