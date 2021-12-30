package dewanTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.DewanAddItemsExcelReader;
import dewanPages.CreateSalesOrderPage;
import dewanPages.HomePage;
import dewanPages.QS_SalesOperationPage;
import dewanPages.QuickSalesPage;
import dewanPages.UserLogOutPage;
import dewanPages.UserLoginPage;

public class NewSalesOrderTestUsingDDTWithExcel extends TestBase{
	@DataProvider(name="Itemsexceldata")
	public Object[][]ItemData() throws IOException
	{
		DewanAddItemsExcelReader ER2=new DewanAddItemsExcelReader();
		return ER2.GetExcelData();
	}
HomePage HomeObj;
UserLoginPage LoginObj;
UserLogOutPage LogoutObj;
QuickSalesPage QSObj;
QS_SalesOperationPage QS_salesObj;
CreateSalesOrderPage SOPObj;
String ProductName="a";
String Username="youssef";
String  Password="1234";
String ItemName ;
String Qty;
String Price;

@Test(priority = 1,dataProvider  = "Itemsexceldata")
public void CreateNewSalesOrder(String ItemName ,String Qty,String Price) throws InterruptedException  
{
	LoginObj=new UserLoginPage(driver);
	LoginObj.USerLogin(Username, Password);
	
	HomeObj=new HomePage(driver);
	HomeObj.OpenQuickSales();

	QSObj=new QuickSalesPage(driver);
	QSObj.OpenSalesOperation();
	
	QS_salesObj =new QS_SalesOperationPage(driver);
	QS_salesObj.AddNewSalesOrder();
	Assert.assertTrue(QS_salesObj.ASsertSalesOrderPage.getText().
			contains("Create Sales Transaction"));
	SOPObj= new CreateSalesOrderPage(driver);
	SOPObj.FillSalesOrder();
	Thread.sleep(250);
	Assert.assertTrue(driver.getCurrentUrl().contains
	("https://bdms.dewansoft.com/test/QuickSales/Transaction/Details"));
   SOPObj=new CreateSalesOrderPage(driver);
	SOPObj.FillItemData(ItemName,Qty,Price);
	System.out.println(SOPObj.TableItemName.getText());
	Assert.assertTrue(SOPObj.TableItemName.getText().contains("Valeo"));
	LogoutObj=new UserLogOutPage(driver);
	LogoutObj.UserLogout();
	

}
}
