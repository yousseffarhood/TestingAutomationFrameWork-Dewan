package dewanPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PurchaseFullTransactionPage extends PageBase{

	public PurchaseFullTransactionPage(WebDriver driver) {
		super(driver);
	}
	//first stage
	@FindBy(xpath = "/html/body/div[1]/main/div/h2/a/i")
	WebElement PlusSymbol;
	@FindBy(id ="DomainModel.ContactID")
	WebElement ContactTxtBox;
	@FindBy(xpath =  "//div[text()='التجاريون لاداره الخدمات المتكاملة AMIS - فرع العباسية ']")	
	List<WebElement> ContactTxtbox2;
	@FindBy(name = "DomainModel.JournalID")
	WebElement JournalDrpdwnlst;
	@FindBy(xpath = "/html/body/div[1]/main/div/form/div[3]/div[1]/div/button")
	WebElement SaveBtnFirstStage;
	//second stage
	@FindBy(id = "DomainModel.ItemID")
	WebElement ItemTxtBox;
	@FindBy(xpath = "//div[text()='آلة تصوير مستندات متعددة الوظائف ابيض واسود-Valeo']")
	List<WebElement> ListItems;
	@FindBy(name = "DomainModel.Description")
	WebElement DescriptionTxtBox;
	@FindBy(name = "DomainModel.Quantity")
	WebElement QtyTxtBox;
	@FindBy(name = "DomainModel.Price")
	WebElement PriceTxtBox;
	@FindBy(id  = "Create")
	WebElement SaveBtnSecondStage;
	@FindBy(xpath = "//table/tbody/tr[1]/td[1]")
	public WebElement AssertSecondStage;
	@FindBy(linkText = "Confirm")
	WebElement ConfirmThirdStage1;
	@FindBy(id = "submitButton")
	WebElement ConfirmThirdStage2;
	@FindBy(xpath = "/html/body/div[1]/main/div/div[4]/strong")
	public WebElement AssertThirdStage;
	@FindBy(xpath = "//a[@href='#Payments']")
	WebElement PaymentsTab;
	@FindBy(xpath = "//*[@id=\"Payments\"]/div/h2/a/i")
	WebElement PaymentsPlusSymbol;
	@FindBy(name = "DomainModel.PaymentValue")
	WebElement PaymentValueTxtBox;
	@FindBy(name = "DomainModel.PayamentTypeID")
	WebElement PayamentTypeDrpdwnlst;
	@FindBy(id = "submitButton")
	WebElement SaveBtnFourthStage;
	@FindBy(xpath = "/html/body/div[1]/main/div/div/strong")
	public WebElement AssertFourthStage;
	@FindBy(xpath = "/html/body/div[1]/main/div/form/div[3]/div[2]/a/i")
	WebElement PaymentBackBtn;
	@FindBy(linkText = "Confirm")
	WebElement PaymentConfirmBtn;
	@FindBy(xpath = "/html/body/div[1]/main/div/div[4]")
	public WebElement AssertFifthStage;
	public void PurchaseFirstStage(String Contact)
	{
		ClickButton(PlusSymbol);
		SetTextElement(ContactTxtBox, Contact);
		ContactTxtbox2.get(0).click();
		select=new Select(JournalDrpdwnlst);
		select.selectByValue("5");
		ClickButton(SaveBtnFirstStage);
	}
	
	public void PurchaseSecondStage(String ItemName,String Description,String Qty,String Price)
	{
		SetTextElement(ItemTxtBox, ItemName);
		ListItems.get(0).click();
		SetTextElement(DescriptionTxtBox, Description);
		QtyTxtBox.clear();
		SetTextElement(QtyTxtBox, Qty);
		PriceTxtBox.clear();
		SetTextElement(PriceTxtBox, Price);
		ClickButton(SaveBtnSecondStage);
	}
	public void PurchaseThirdStage()
	{
		ClickButton(ConfirmThirdStage1);
		ClickButton(ConfirmThirdStage2);
		
	}
	public void PurchaseFourthStage(String PaymentValue)
	{
		ClickButton(PaymentsTab);
		ClickButton(PaymentsPlusSymbol);
		PaymentValueTxtBox.clear();
		SetTextElement(PaymentValueTxtBox, PaymentValue);
		select=new Select(PayamentTypeDrpdwnlst);
		select.selectByValue("7");
		ClickButton(SaveBtnFourthStage);
		
	}
	public void PaymenstBackBtn()
	{
		ClickButton(PaymentBackBtn);
		
	}
	public void FifthStage()
	{
		ClickButton(PaymentsTab);
		ClickButton(PaymentConfirmBtn);
		
	}
	
}
