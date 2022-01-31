package dewanPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ReturnSalesSearchByFilters extends PageBase {

	public ReturnSalesSearchByFilters(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "Filter.ContactID")
	WebElement ContactTxtBox;
	@FindBy(xpath =  "//div[text()='التجاريون لاداره الخدمات المتكاملة AMIS - فرع العباسية ']")	
	List<WebElement> ContactTxtbox2;
	@FindBy(id = "JournalID")
	WebElement Journaldrpdwnlst;
	@FindBy(name = "Filter.Status")
	WebElement Statusdrpdwnlst;
	@FindBy(name = "Filter.DateFrom")
	WebElement DateFromTxtBox;
	@FindBy(name = "Filter.DateTo")
	WebElement DateToTxtBox;
	@FindBy(css ="button.form-control.btn.btn-primary")
	WebElement SearchBtn;
	@FindBy(xpath="/html/body/div[1]/main/div/div[1]/div/a")
	WebElement ExportToExcelBtn;
	@FindBy(xpath = "//h4[contains(text(),' Number Of Rows : 9')]")
	public WebElement AssertNoOfRows;
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
