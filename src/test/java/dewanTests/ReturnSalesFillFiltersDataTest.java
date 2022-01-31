package dewanTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import dewanPages.HomePage;
import dewanPages.QuickSalesPage;
import dewanPages.ReturnSalesSearchByFilters;
import dewanPages.UserLogOutPage;
import dewanPages.UserLoginPage;

public class ReturnSalesFillFiltersDataTest extends TestBase {
	UserLoginPage LoginObj;
	HomePage HomeObj;
	QuickSalesPage QSPageObj;
	ReturnSalesSearchByFilters RSObj;
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
		QSPageObj.OpenReturnSalesOperation();
		RSObj=new ReturnSalesSearchByFilters(driver);
		RSObj.FillTheFilterData(Contact, DateFrom , DateTo);
		// explicit wait condition
	      @SuppressWarnings("deprecation")
		WebDriverWait w = new WebDriverWait(driver,3);
	      // presenceOfElementLocated condition
	      w.until(ExpectedConditions.presenceOfElementLocated (By
	    		  .xpath("//h4[contains(text(),' Number Of Rows : 9')]")));
		System.out.println(RSObj.AssertNoOfRows.getText());
		Assert.assertTrue(RSObj.AssertNoOfRows.getText().endsWith("9"));
		RSObj.ClickOnExportBtn();
		Thread.sleep(5000);
		LogOutObj=new UserLogOutPage(driver);
		LogOutObj.UserLogout();
		
		

	}

}
