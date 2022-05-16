package configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Configurations.PaymentType;
import dewanPages.HomePage;
import dewanPages.UserLoginPage;
import dewanTests.TestBase;

public class PaymentTypeTest extends TestBase {
	UserLoginPage LoginObj;
	HomePage HomeObj;
	Configurations.BranchPage BranchObj;
	PaymentType Paymentobj;
	String PaymentType="QuickSalesPaymentType";
	String AccountID="aa";
		String Username="admin";
		String Password="1234";
	//	String BranchName="Tst001";
	//	String BranchAddress="DDT";

	//@Test(priority = 1)
//	public void LoginWithSQL() throws SQLException
//	{	String host="localhost";
//	String port="3306";
//	Connection con= DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/tst001", "root", "Root");
//	Statement s=con.createStatement();
//	ResultSet rs=s.executeQuery("select * from Users where username='admin'");
//	while(rs.next())
//	{
//		LoginObj=new UserLoginPage(driver);
//		LoginObj.USerLogin(rs.getString("username"),rs.getString("password"));
//	}
//	}
	@Test(priority = 1)
	public void Login()
	{ 	LoginObj=new UserLoginPage(driver);
	LoginObj.USerLogin(Username, Password);

	}
	@Test(priority=2,enabled = true)
	public void CreatePaymentTypeUsingSQL() throws InterruptedException, SQLException
	{
		HomeObj=new HomePage(driver);
		HomeObj.OpenQuickSales();
		Paymentobj=new PaymentType(driver);
		Paymentobj.OpenPaymentType();
		Paymentobj.CreatePaymentTypesBasic(PaymentType, AccountID);
		Paymentobj.CreatePaymentTypeExternalSQL();
		Paymentobj.BackToPaymentTypePage();
		Thread.sleep(2000);
		Assert.assertTrue(Paymentobj.AssertBasicPaymentType.getText().contains("QuickSalesPaymentType"));

		Assert.assertTrue(Paymentobj.AssertCashPaymentType.getText().contains("CashManagement"));

		Assert.assertTrue(Paymentobj.AssertChequePaymentType.getText().contains("ChequeManagement"));

		Assert.assertTrue(Paymentobj.AssertBankPaymentType.getText().contains("BankTransfer"));

		Assert.assertTrue(Paymentobj.AssertCreditPaymentType.getText().contains("CreditCard"));

		Assert.assertTrue(Paymentobj.AssertAccSettPaymentType.getText().contains("AccountSettlement"));

	}
	@Test(priority = 3,enabled = false)
	public void DeletePayments() throws InterruptedException
	{	HomeObj=new HomePage(driver);
	HomeObj.OpenQuickSales();
	Paymentobj=new PaymentType(driver);
	Paymentobj.OpenPaymentType();
		Paymentobj=new PaymentType(driver);
		Paymentobj.DeletePaymentTypes();
		Thread.sleep(2000);
		Assert.assertTrue(Paymentobj.AssertBasicPaymentType.getText().isEmpty());

	}
}
