package dewanPages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ReturnSalesCreateFullTransactionPage extends PageBase{

	public ReturnSalesCreateFullTransactionPage(WebDriver driver) {
		super(driver);
		jse=(JavascriptExecutor) driver;
	}

	@FindBy(css = "i.text-success.fas.fa-plus-square.fa-sm")
	WebElement PlusSymbol;
	@FindBy(id = "DomainModel.ContactID")
	WebElement ContactTxtbox;
	@FindBy(xpath = "//div[text()='التجاريون لاداره الخدمات المتكاملة AMIS - فرع العباسية '] ")
	List<WebElement>ContactTxtbox2;
	@FindBy(id = "JournalId")
	WebElement Journaldrpdwnlst ;
	@FindBy(id = "PaymentTypeId")
	WebElement PaymentTypedrpdwnlst;
	@FindBy(name = "DomainModel.Date")
	WebElement DateTxtbox;
	@FindBy(name="DomainModel.CurrencyID")
	WebElement Currencydrpdwnlst;
	@FindBy(id = "ExchangeRate")
	WebElement ExchangeRateTxtbox;
	@FindBy(css  = "button.form-control.btn.btn-info")
	WebElement SaveBtn;
	//11/11/2021
	@FindBy(name = "Filter.DateFrom")
	WebElement DateFromTxtbox;
	@FindBy(name = "Filter.DateTo")
	WebElement DateToTxtbox;
	@FindBy(css = "button.form-control.btn.btn-primary")
	WebElement SearchBtn;
	@FindBy(css = "h4")
	public WebElement WaitTillThisElementIsVisible; 
	@FindBy(xpath = "//table/tbody/tr[18]/td[3]")
	WebElement ScrollTo;
	@FindBy(id = "17CK")
	WebElement ItemInTable;
	@FindBy(id = "17Qty")
	WebElement QtyItemTable;
	@FindBy(id = "submit")
	WebElement SubmitBtn;
	@FindBy(xpath = "/html/body/div[1]/main/div/div[4]/a[2]")
	WebElement FirstConfirmBtn;
	@FindBy(id = "submitButton")
	WebElement SecondConfirmBtn;
	@FindBy(css = "strong")
	public WebElement AssetTransactionConfirmation;
	@FindBy(linkText = "Credit Note")
	WebElement CreditNoteTab;
	@FindBy(xpath = "//*[@id=\"CreditNote\"]/h2/a/i")
	WebElement CreditPlusSymbol;
	@FindBy(name = "DomainModel.Note")
	WebElement NoteCR;
	@FindBy(name = "DomainModel.Value")
	WebElement ValueCR;
	@FindBy(name = "DomainModel.CreditNoteTypeID")
	WebElement TypeIDCR;
	@FindBy(css = "button.form-control.btn.btn-info")
	WebElement SaveCRBtn;
	@FindBy(css = "a.col-md-2.form-group.btn.btn-info")
	WebElement BackBtn;
	@FindBy(css = "div.alert.alert-success.alert-dismissible.fade.show.col-md-12")
	public WebElement AssertCR;
	@FindBy(xpath = "/html/body/div[1]/main/div/div[4]/a[2]")
	WebElement ConfirmTrasnasctionBtn1;
	@FindBy(id = "submitButton")
	WebElement ConfirmTransactionBtn2;
	@FindBy(xpath = "/html/body/div[1]/main/div/div[4]/strong")
	public WebElement AssertConfirmTransaction;
	@FindBy(linkText = "Payments")
	WebElement PaymentsTab;
	@FindBy(xpath = "//*[@id=\"Payments\"]/div/h2/a/i")
	WebElement PaymentsPlusSymbol;
	@FindBy(name = "DomainModel.PaymentValue")
	WebElement PaymentsValue;
	@FindBy(name = "DomainModel.PayamentTypeID")
	WebElement Payment2TypeDrpdwnlst;
	@FindBy(id = "submitButton")
	WebElement PaymentsSavebtn;
	@FindBy(xpath = "/html/body/div[1]/main/div/form/div[3]/div[2]/a")
	WebElement BackFromPayments;
	@FindBy(xpath = "/html/body/div[1]/main/div/div/strong")
	public WebElement AssertConfirmPayments;
	
	
	





	public void FirstStageInRS(String Contact,String Date)
	{
		ClickButton(PlusSymbol);

		select=new Select(Journaldrpdwnlst);
		select.selectByValue("5");
		DateTxtbox.clear();
		SetTextElement(DateTxtbox, Date);
		ContactTxtbox.clear();
		SetTextElement(ContactTxtbox,Contact);
		ContactTxtbox2.get(0).click();
		ClickButton(SaveBtn);	
	}

	public void SecondStageInRS(String DateFrom,String DateTo,String QuantityNumber) throws InterruptedException
	{
		DateFromTxtbox.clear();
		SetTextElement(DateFromTxtbox, DateFrom);
		DateToTxtbox.clear();
		SetTextElement(DateToTxtbox, DateTo);
		ClickButton(SearchBtn);
		ScrollToBottom(ScrollTo);		
		ClickButton(ItemInTable);
		QtyItemTable.clear();
		SetTextElement(QtyItemTable, QuantityNumber);
		ClickButton(SubmitBtn);
	}
	public void ThirdStageInRSCR(String Note, String Value)
	{
		ClickButton(CreditNoteTab);
		ClickButton(CreditPlusSymbol);
		SetTextElement(NoteCR, Note);
		ValueCR.clear();
		SetTextElement(ValueCR, Value);
		select=new Select(TypeIDCR);
		select.selectByValue("2");
		ClickButton(SaveCRBtn);
		
		
	}
	public void BackFromThirdStageUnRSCR()
	{
		ClickButton(BackBtn);
	}
	public void FourthStageInRSConfirmTransaction()
	{
		ClickButton(ConfirmTrasnasctionBtn1);
		ClickButton(ConfirmTransactionBtn2);
	}
	public void FifthStageInRSPayment(String Value2)
	{
		ClickButton(PaymentsTab);
		ClickButton(PaymentsPlusSymbol);
		PaymentsValue.clear();
		SetTextElement(PaymentsValue, Value2);
		select=new Select(Payment2TypeDrpdwnlst);
		select.selectByValue("7");
		ClickButton(SaveBtn);
		
	}
	public void BackFromFifthStageInRSPayment()
	{
		ClickButton(BackFromPayments);
	}
}	
