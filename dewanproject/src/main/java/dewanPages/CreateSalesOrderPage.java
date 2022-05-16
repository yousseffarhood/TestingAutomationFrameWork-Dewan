package dewanPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateSalesOrderPage extends PageBase {

	public CreateSalesOrderPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "DomainModel.ContactID")
	WebElement ContactTxtBox;
	@FindBy(xpath = "//div[text()='true contact']")
	List<WebElement> ContactTxtBox2;
	String Contactname="a";
	@FindBy(css = "select.browser-default.custom-select")
	WebElement JournalFilter;
	@FindBy(id = "PriceListID")
	WebElement PriceList;
	@FindBy(name = "DomainModel.Date")
	WebElement DateFilter;
	String DateDay="28/12/2021";
	@FindBy(name = "DomainModel.CurrencyId")
	WebElement CurrencyFilter;
	@FindBy(id = "ExchangeRate")
	WebElement ExchangeRateFilter;
	String ExchangeRateTxtBox="1";
	@FindBy(css = "button.form-control.btn.btn-info")
	WebElement SaveBtn;
	@FindBy(id = "DomainModel.ItemID")
	WebElement ItemTxtBox;
	//	String ItemName="valeo";
	@FindBy(xpath = "//div[text()='آلة تصوير مستندات متعددة الوظائف ابيض واسود-Valeo']")
	List<WebElement> ListItems;
	@FindBy(name = "DomainModel.Quantity")
	WebElement QuantityTxtBox;
	//String Qty="2";
	@FindBy(id = "price")
	WebElement PriceTxtBox;
	//String Prc="150";
	@FindBy(id = "Create")
	WebElement SaveBtn2;
	@FindBy(xpath = "//table/tbody/tr[1]/td[1]")
	public WebElement TableItemName;
	@FindBy(css = "a.nav-link.active.show")
	WebElement DetailsTabBtn;
	@FindBy(xpath =  "//a[@href='#Payments']")
	WebElement PaymentsTabBtn;

	@FindBy(xpath = "//*[@id=\"Payments\"]/div/table/tbody/tr/td[10]/a")
	WebElement ConfirmPaymentBtn;
	@FindBy(xpath = "/html/body/div[1]/main/div/div[2]/strong")
	public WebElement AssertConfrimPayment;
	@FindBy(xpath="//tr/td[8]")
	public WebElement AssertConfrimPayment2;
	@FindBy(css = "i.text-success.fas.fa-plus-square.fa-sm")
	WebElement PlusSymbol;
	@FindBy(name = "DomainModel.PaymentValue")
	WebElement PaymentValueTxtBox;
	@FindBy(xpath = "//select[@name='DomainModel.PayamentTypeID']")
	WebElement PaymentTypeDrpDwnList;
	@FindBy(id = "submitButton")
	WebElement SaveBtn3;
	@FindBy(css = "strong")
	public WebElement AssertPayment;
	@FindBy(css = "a.form-group.btn.btn-info")
	WebElement BackBtn; 
	@FindBy(css = "a.btn.btn-primary")
	WebElement ConfirmTransactionBtn;
	@FindBy(css = "i.text-success.far.fa-check-circle.fa-lg")
	WebElement ConfirmTransactionBtn2;
	@FindBy(id = "submitButton")
	WebElement ConfirmTransactionBtn3;
	@FindBy(xpath = "/html/body/div[1]/main/div/div[4]/strong")
	public WebElement AssertSalesTransaction;
	@FindBy(xpath = "//a[@href='#CreditNote']")
	WebElement CreditNoteTab;
	@FindBy(name = "DomainModel.Note")
	WebElement NoteTxtBox;
	@FindBy(name = "DomainModel.Value")
	WebElement ValueTxtBox;
	@FindBy(xpath = "//a[@href='#DebitNote']")
	WebElement DebitNoteTab;
	@FindBy(name = "DomainModel.DebitTypeID")
	WebElement DebitNoteType;
	@FindBy(name = "DomainModel.CreditNoteTypeID")
	WebElement CreditNoteType;
	@FindBy(xpath = "/html/body/div/main/div/div")
	public WebElement AssertConfirmCredit_DebitNote;
	@FindBy(css ="a.form-group.btn.btn-info")
	WebElement BackFromDebitNotePageBtn;
	@FindBy(xpath ="//*[@id=\"DebitNote\"]/div/h2/a/i")
	WebElement PlusSymbol2;
	public void FillSalesOrder() throws InterruptedException
	{


		//choose the journal filter
		select=new Select(JournalFilter);
		select.selectByValue("5");
		//choose the pricelist filter
		select=new Select(PriceList);
		select.selectByValue("5");
		//fill the date d
		DateFilter.clear();
		SetTextElement(DateFilter, DateDay);
		//select egp currency

		select=new Select(CurrencyFilter);
		select.selectByIndex(1);
		//fill the ExchangeRate 
		ExchangeRateFilter.clear();
		SetTextElement(ExchangeRateFilter, ExchangeRateTxtBox);

		//fill the contact
		SetTextElement(ContactTxtBox, Contactname);
		//add wait till the auto suggest is shown


		ContactTxtBox2.get(0).click();
		Thread.sleep(200);


		//click save
		ClickButton(SaveBtn);
	}

	public void FillItemData(String ItemName,String Qty,String Price) throws InterruptedException
	{
		SetTextElement(ItemTxtBox, ItemName);
		ListItems.get(0).click();
		QuantityTxtBox.clear();
		SetTextElement(QuantityTxtBox, Qty);
		PriceTxtBox.clear();
		SetTextElement(PriceTxtBox, Price);
		ClickButton(SaveBtn2);
		Thread.sleep(2500);


	}
	public void  SalesDetailsTab()
	{
		ClickButton(DetailsTabBtn);

	}
	public void  SalesPaymentsTab()
	{	System.out.println(PaymentsTabBtn.getText());
	//ScrollToBottom(PaymentsTabBtn);
	//ClickOnWebElement(PaymentsTabBtn);
	ClickButton(PaymentsTabBtn);

	}
	public void ConfirmSalesPayment()
	{	ClickButton(PaymentsTabBtn);
	ClickButton(ConfirmPaymentBtn);
	}
	public void ShowPayments(String PaymentValue)
	 {
		 ClickButton(PlusSymbol);
		 PaymentValueTxtBox.clear();
		 SetTextElement(PaymentValueTxtBox, PaymentValue);
		 select=new Select(PaymentTypeDrpDwnList);
		 select.selectByValue("7");
		 ClickButton(SaveBtn3);
	 }

	 public void BackFromSalesPayments()
	 {
		 ClickButton(BackBtn);
	 }
	 public void ConfirmSalesTransaction()
	 {
		 ClickButton(ConfirmTransactionBtn);
		 ClickButton(ConfirmTransactionBtn2);
		 ClickButton(ConfirmTransactionBtn3);
		 
	 }
	 public void OpenCreditNoteTab(String Note,String Value)
	 {
		 ClickButton(CreditNoteTab);
		 ClickButton(PlusSymbol2);
		 SetTextElement(NoteTxtBox, Note);
		 ValueTxtBox.clear();
		 SetTextElement(ValueTxtBox, Value);
		 select=new Select(CreditNoteType);
		 select.selectByValue("1");
		 ClickButton(SaveBtn);
	 }
	 public void OpenDebitNoteTab(String DNote,String DValue) throws InterruptedException
	 {
		 ClickButton(DebitNoteTab);
		 Thread.sleep(250);
		 ClickButton(PlusSymbol2);
		 SetTextElement(NoteTxtBox, DNote);
		 ValueTxtBox.clear();
		 SetTextElement(ValueTxtBox, DValue);
		 select=new Select(DebitNoteType);
		 select.selectByValue("1");
		 ClickButton(SaveBtn);
		 
	 }
	 public void BackFromDebitNotePage()
	 {
		 ClickButton(BackFromDebitNotePageBtn);
	 }
}
