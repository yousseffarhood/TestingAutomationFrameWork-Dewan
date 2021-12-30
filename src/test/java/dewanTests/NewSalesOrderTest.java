package dewanTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import dewanPages.CreateSalesOrderPage;
import dewanPages.HomePage;
import dewanPages.QS_SalesOperationPage;
import dewanPages.QuickSalesPage;
import dewanPages.SalesDetailsCRUD;
import dewanPages.UserLogOutPage;
import dewanPages.UserLoginPage;

@Test
public class NewSalesOrderTest extends TestBase{
	HomePage HomeObj;
	UserLoginPage LoginObj;
	UserLogOutPage LogoutObj;
	QuickSalesPage QSObj;
	QS_SalesOperationPage QS_salesObj;
	CreateSalesOrderPage SOPObj;
	SalesDetailsCRUD CrudObj;
	String ProductName="a";
	String Username="youssef";
	String  Password="1234";
	String ItemName ="آلة تصوير مستندات متعددة الوظائف ابيض واسود-Valeo";
	String Qty="2";
	String Price="150";
	String PaymentValue="300";


	@Test(priority = 1)
	public void CreateNewSalesOrder() throws InterruptedException
	{
		LoginObj=new UserLoginPage(driver);
		LoginObj.USerLogin(Username, Password);

		HomeObj=new HomePage(driver);
		HomeObj.OpenQuickSales();

		QSObj=new QuickSalesPage(driver);
		QSObj.OpenSalesOperation();

		QS_salesObj =new QS_SalesOperationPage(driver);
		QS_salesObj.AddNewSalesOrder();
		AssertJUnit.assertTrue(QS_salesObj.ASsertSalesOrderPage.getText().
				contains("Create Sales Transaction"));
		SOPObj= new CreateSalesOrderPage(driver);
		SOPObj.FillSalesOrder();
		Thread.sleep(250);
		AssertJUnit.assertTrue(driver.getCurrentUrl().contains
				("https://bdms.dewansoft.com/test/QuickSales/Transaction/Details"));
		SOPObj.FillItemData(ItemName, Qty, Price);
		System.out.println(SOPObj.TableItemName.getText());

		AssertJUnit.assertTrue(SOPObj.TableItemName.getText().contains("Valeo"));
		SOPObj.SalesDetailsTab();

		CrudObj=new SalesDetailsCRUD(driver);
		CrudObj.ShowDetails();
		AssertJUnit.assertTrue(CrudObj.AssertItem.isDisplayed());
		CrudObj.BackFromSalesDetails();
		SOPObj.SalesPaymentsTab();

		@SuppressWarnings("deprecation")
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/main/div/div[6]/ul/li[2]/a")));
		SOPObj.ShowPayments(PaymentValue);
		Assert.assertTrue(SOPObj.AssertPayment.isDisplayed());
		SOPObj.BackFromSalesPayments();
		SOPObj.ConfirmSalesPayment();
		System.out.println(SOPObj.AssertConfrimPayment.getText());
		Assert.assertTrue(SOPObj.AssertConfrimPayment.getText().equals("Confirmed Successfully!"));
		LogoutObj=new UserLogOutPage(driver);
		LogoutObj.UserLogout();


	}
}