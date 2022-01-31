package dewanPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ReturnPurchaseSearchByFiltersPage extends PageBase{

	public ReturnPurchaseSearchByFiltersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "Filter.ContactID")
	WebElement ContactTxtBox;
	@FindBy(xpath =  "//div[text()='التجاريون لاداره الخدمات المتكاملة AMIS - فرع العباسية ']")	
	List<WebElement> ContactTxtbox2;
	@FindBy(id = "JournalID")
	WebElement Journaldrpdwnlst;
	@FindBy(name = "filter.Status")
	WebElement Statusdrpdwnlst;
	@FindBy(name = "filter.DateFrom")
	WebElement DateFromTxtBox;
	@FindBy(name = "filter.DateTo")
	WebElement DateToTxtBox;
	@FindBy(css ="button.form-control.btn.btn-primary")
	WebElement SearchBtn;
	@FindBy(linkText = "Export To Excel")
	WebElement ExportToExcelBtn;
	public void FillTheFilterData(String Contact, String DateFrom,String DateTo)
	{
		SetTextElement(ContactTxtBox, Contact);
		ContactTxtbox2.get(0).click();
		select=new Select(Journaldrpdwnlst);
		select.selectByValue("5");
		select=new Select(Statusdrpdwnlst);
		select.selectByValue("Confirmed");
		DateFromTxtBox.clear();
		SetTextElement(DateFromTxtBox, DateFrom);
		DateToTxtBox.clear();
		SetTextElement(DateToTxtBox, DateTo);
		ClickButton(SearchBtn);
	}
	public void ClickOnExportBtn()
	{
		ClickButton(ExportToExcelBtn);
	}

}
