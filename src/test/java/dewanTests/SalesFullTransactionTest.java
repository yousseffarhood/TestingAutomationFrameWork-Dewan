package dewanTests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import dewanPages.CreateSalesOrderPage;
import dewanPages.HomePage;
import dewanPages.QS_SalesOperationPage;
import dewanPages.QuickSalesPage;
import dewanPages.SalesDetailsCRUD;
import dewanPages.UserLogOutPage;
import dewanPages.UserLoginPage;

@Test
public class SalesFullTransactionTest extends TestBase{
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
	String PaymentValue="350";
	String Note="this is a note";
	String Value="50";


	@Test(priority = 1)
	public void CreateNewSalesOrder() throws InterruptedException
	{	//User Can Login
		LoginObj=new UserLoginPage(driver);
		LoginObj.USerLogin(Username, Password);
		//User Can Open HomePage And Choose QS application
		HomeObj=new HomePage(driver);
		HomeObj.OpenQuickSales();
		//User can Choose "Sales" Operation
		QSObj=new QuickSalesPage(driver);
		QSObj.OpenSalesOperation();
		//User Can Create Sales Order 
		QS_salesObj =new QS_SalesOperationPage(driver);
		//User Click On + Btn
		QS_salesObj.AddNewSalesOrder();
		Assert.assertTrue(QS_salesObj.ASsertSalesOrderPage.getText().
				contains("Create Sales Transaction"));
		SOPObj= new CreateSalesOrderPage(driver);
		//User fill the Must Do Fields
		SOPObj.FillSalesOrder();
		Thread.sleep(250);
		Assert.assertTrue(driver.getCurrentUrl().contains
				("https://bdms.dewansoft.com/test/QuickSales/Transaction/Details"));
		SOPObj.FillItemData(ItemName, Qty, Price);
		System.out.println(SOPObj.TableItemName.getText());

		Assert.assertTrue(SOPObj.TableItemName.getText().contains("Valeo"));
		SOPObj.SalesDetailsTab();
		//Testing The CRUD In the Sales Details
		CrudObj=new SalesDetailsCRUD(driver);
		CrudObj.ShowDetails();
		Assert.assertTrue(CrudObj.AssertItem.isDisplayed());
		//User Can go back to the transaction page
		CrudObj.BackFromSalesDetails();
		SOPObj.OpenDebitNoteTab(Note, Value);
		Assert.assertTrue(SOPObj.AssertConfirmCredit_DebitNote.
				getText().contains("Created successfully"));
		Thread.sleep(250);
		SOPObj.BackFromDebitNotePage();
		
		//User can confirm transaction
		SOPObj.ConfirmSalesTransaction();
		Assert.assertTrue(SOPObj.AssertSalesTransaction.getText().contains("Transaction has been confirmed successfully ..."));
		//user click on payment tab
		SOPObj.SalesPaymentsTab();
		@SuppressWarnings("deprecation")
		//implicit wait till the element is visible to be clicked
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/main/div/div[6]/ul/li[2]/a")));
		//redirect to payment page
		SOPObj.ShowPayments(PaymentValue);
		Assert.assertTrue(SOPObj.AssertPayment.isDisplayed());
		//return to transaction page
		SOPObj.BackFromSalesPayments();
		//user confirm on payment
		SOPObj.ConfirmSalesPayment();
		System.out.println(SOPObj.AssertConfrimPayment.getText());
		Assert.assertTrue(SOPObj.AssertConfrimPayment.getText().equals("Confirmed Successfully!"));
		//user logout
		LogoutObj=new UserLogOutPage(driver);
		LogoutObj.UserLogout();


	}
}