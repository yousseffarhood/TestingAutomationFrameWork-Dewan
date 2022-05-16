package dewanTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import dewanPages.HomePage;
import dewanPages.PurchaseFullTransactionPage;
import dewanPages.QuickSalesPage;
import dewanPages.UserLogOutPage;
import dewanPages.UserLoginPage;

public class PurchaseFullTransactionTest extends TestBase {
	HomePage HomeObj;
	UserLoginPage LoginObj;
	UserLogOutPage LogoutObj;
	QuickSalesPage QSObj;
	PurchaseFullTransactionPage PurcObj;
	String ContactName="التجاريون لاداره الخدمات المتكاملة AMIS - فرع العباسية";
	String ItemName ="آلة تصوير مستندات متعددة الوظائف ابيض واسود-Valeo";
	String Description="this is the description for this transaction 1";
	String Username="youssef";
	String  Password="1234";
	String Qty="2";
	String Price="150";
	String PaymentValue="300";
	String Value="50";
	@Test(priority = 1)
	public void PurchaseFullTransaction() throws InterruptedException
	{	//User Can Login
		LoginObj=new UserLoginPage(driver);
		LoginObj.USerLogin(Username, Password);
		//User Can Open HomePage And Choose QS application
		HomeObj=new HomePage(driver);
		HomeObj.OpenQuickSales();
		//User can Choose "Sales" Operation
		QSObj=new QuickSalesPage(driver);
		QSObj.OpenPurchaseOperation();
		PurcObj=new PurchaseFullTransactionPage(driver);
		PurcObj.PurchaseFirstStage(ContactName);
		PurcObj.PurchaseSecondStage(ItemName, Description, Qty, Price);
		Assert.assertTrue(PurcObj.AssertSecondStage.getText().contains("آلة تصوير مستندات متعددة الوظائف ابيض واسود-Valeo"));
		PurcObj.PurchaseThirdStage();
		Assert.assertTrue(PurcObj.AssertThirdStage.getText().contains("Transaction has been confirmed successfully ..."));
		PurcObj.PurchaseFourthStage(PaymentValue);
		Assert.assertTrue(PurcObj.AssertFourthStage.getText().contains("Created successfully"));
		PurcObj.PaymenstBackBtn();
		PurcObj.FifthStage();
		Assert.assertTrue(PurcObj.AssertFifthStage.getText().contains("Confirmed Successfully!"));
		LogoutObj=new UserLogOutPage(driver);
		LogoutObj.UserLogout();

}
}
