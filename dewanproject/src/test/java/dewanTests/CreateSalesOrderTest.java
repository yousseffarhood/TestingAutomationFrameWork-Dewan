package dewanTests;

import org.testng.annotations.Test;

import dewanPages.CreateSalesOrderPage;
import dewanPages.HomePage;
import dewanPages.QS_SalesOperationPage;
import dewanPages.QuickSalesPage;
import dewanPages.UserLogOutPage;
import dewanPages.UserLoginPage;

public class CreateSalesOrderTest extends TestBase {
	
	UserLoginPage LoginObj;
	HomePage HomeObj;
	QuickSalesPage QSObj;
	QS_SalesOperationPage QS_SalesObj;
	CreateSalesOrderPage CreateObj;
	UserLogOutPage LogoutObj;
	String Username="youssef";
	String  Password="1234";
	
	@Test(priority = 1)
	public void CreateSalesOrder() throws InterruptedException
	{
		LoginObj=new UserLoginPage(driver);
		LoginObj.USerLogin(Username, Password);
		
		HomeObj=new HomePage(driver);
		HomeObj.OpenQuickSales();

		QSObj=new QuickSalesPage(driver);
		QSObj.OpenSalesOperation();

		QS_SalesObj =new QS_SalesOperationPage(driver);
		QS_SalesObj.AddNewSalesOrder();
		
		
		CreateObj=new CreateSalesOrderPage(driver);
		CreateObj.FillSalesOrder();
		
		LogoutObj=new UserLogOutPage(driver);
		LogoutObj.UserLogout();
		
	}

}
