package dewanPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class QS_SalesOperationPage extends PageBase {

	public QS_SalesOperationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "h2")
	public WebElement AssertOnTheCurrentPage;
	@FindBy(id = "filter.ContactID")
	WebElement ContactTxtbox;
	@FindBy(xpath =  "//div[text()='التجاريون لاداره الخدمات المتكاملة AMIS - فرع العباسية ']")	
	List<WebElement> ContactTxtbox2;
	@FindBy(id = "filter.ContactID")
	public WebElement AssertContactFilter;	
	@FindBy(css ="button.form-control.btn.btn-primary")
	WebElement SearchBtn;
	@FindBy(css = "select.browser-default.custom-select")
	WebElement JournalFilter;
	@FindBy(id = "PaymentTypeID")
	WebElement PaymentTypeFilter;
	@FindBy(name = "filter.PaymentStatus")
	WebElement PaymentStatus;
	@FindBy(name = "filter.Status")
	WebElement Status;
	@FindBy(name = "filter.DateFrom")
	WebElement DateFrom;
	@FindBy(name = "filter.DateTo")
	WebElement DateTo;
	@FindBy(css = "h4")
	public WebElement NoOfRows;
	@FindBy(css = "a.col-md-2.form-group.text-blue.btn.btn-info")
	
	WebElement ExportToExcel;
	@FindBy(id = "dropdownMenuButton")
	WebElement dropdownMenuButton;
	@FindBy(tagName = "tr")
	List<WebElement>allrows;
	@FindBy(css="a.col-md-3.form-group.text-success")
	WebElement SAlesPlusSymbol;
	@FindBy(css="h2")
	public WebElement ASsertSalesOrderPage;

	public void FillContact(String ProductName) throws InterruptedException
	{
		SetTextElement(ContactTxtbox,ProductName );

		Thread.sleep(2000);
		System.out.println("the size of these elements are "+ContactTxtbox2.size()); 
		ContactTxtbox2.get(0).click();
	}
	public void JournalFilter()
	{
		select=new Select(JournalFilter);
		select.selectByValue("5");
		//select.selectByValue("1");
		//select.selectByValue("2");
		//select.selectByValue("4");
		//select.selectByValue("6");
		//select.selectByValue("7");
	}
	public void PaymentTypeFilter()
	{
		select=new Select(PaymentTypeFilter);
		select.selectByValue("7");
		//select.selectByValue("3");
		//select.selectByValue("4");
		//select.selectByValue("5");
		//select.selectByValue("6");
		//select.selectByValue("7");
		//select.selectByValue("8");
	}
	public void PaymentStatusFilter()
	{
		select =new Select(PaymentStatus);
		select.selectByValue("Paid");
		//select.selectByValue("PartiallyPaid");
		//select.selectByValue("UnPaid");
	}
	public void StatusFilter()
	{
		select =new Select(Status);
		select.selectByValue("Confirmed");
		//select.selectByValue(" Canceled ");
		//select.selectByValue("0");
	}
	public void DateFilter(String StartDate,String EndDate)
	{
		SetTextElement(DateFrom, StartDate);
		SetTextElement(DateTo, EndDate);

	}
	public void ClickOnSearch()
	{
		ClickButton(SearchBtn);

	}
	public void ClickOnExportToExcel()
	{
		ClickButton(ExportToExcel);
	}
	
	public void GetNoOfRows()
	{
		System.out.println(allrows.size());
	}
	@FindBy(tagName = "td")
	List<WebElement> allcols;
	public void GetTableData()
	{	
		for(WebElement row:allrows)
		{System.out.println(row.getText()+"\t");
		for(WebElement col :allcols)
		{
			System.out.println(col.getText()+"\t");
		}
		}
	}
	
	public void AddNewSalesOrder()
	{
		ClickButton(SAlesPlusSymbol);
		
		
	}



}



