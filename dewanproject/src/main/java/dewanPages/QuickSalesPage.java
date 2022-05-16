package dewanPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class QuickSalesPage extends PageBase {

	public QuickSalesPage(WebDriver driver) {
		super(driver);
		action=new Actions(driver);
		
	}
	//open all transaction tabs
	QS_SalesOperationPage SalesObj; 
	@FindBy(css = "main.pb-3")
	public WebElement WelcomeInQuickSales;
	@FindBy(id ="navbarDropdown")
	WebElement TransactionBtn;
	@FindBy(linkText = "Sales")
	WebElement SalesLink;
	public void OpenSalesOperation()
	{	
		action.moveToElement(TransactionBtn).click().build().perform();
		ClickButton(TransactionBtn);	
		action.moveToElement(SalesLink).click().build().perform();
		}
	@FindBy(linkText = "Return Sales")
	WebElement ReturnSalesLink;
	public void OpenReturnSalesOperation()
	{
		action.moveToElement(TransactionBtn).click().build().perform();
		ClickButton(TransactionBtn);	
		action.moveToElement(ReturnSalesLink).click().build().perform();
	}
	
	@FindBy(linkText = "Purchase")
	WebElement PurchaseLink;
	public void OpenPurchaseOperation()
	{
		action.moveToElement(TransactionBtn).click().build().perform();
		ClickButton(TransactionBtn);	
		action.moveToElement(PurchaseLink).click().build().perform();
	}
	@FindBy(linkText = "Return Purchase")
	WebElement ReturnPurchase;
	public void OpenReturnPurchaseOperation()
	{
		action.moveToElement(TransactionBtn).click().build().perform();
		ClickButton(TransactionBtn);	
		action.moveToElement(ReturnPurchase).click().build().perform();
	}
	@FindBy(linkText = "Expenses")
	WebElement ExpensesLink;
	public void OpenExpensesOperation()
	{
		action.moveToElement(TransactionBtn).click().build().perform();
		ClickButton(TransactionBtn);	
		action.moveToElement(ExpensesLink).click().build().perform();
	}
	@FindBy(linkText = "Cash Transfer")
	WebElement CashTransferLink;
	public void OpenCashTransferOperation()
	{
		action.moveToElement(TransactionBtn).click().build().perform();
		ClickButton(TransactionBtn);	
		action.moveToElement(CashTransferLink).click().build().perform();
	}
	
}
