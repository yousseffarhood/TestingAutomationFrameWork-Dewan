package dewanPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalesDetailsCRUD extends PageBase {

	public SalesDetailsCRUD(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//*[@id=\"Details\"]/div/table/tbody/tr/td[13]/a[1]/i")
	WebElement Ibutton;
	@FindBy(css = "a.form-group.btn.btn-info")
	WebElement BackBtn; 
	@FindBy(xpath = "/html/body/div[1]/main/div/div[1]/div[1]/div/input")
	public WebElement AssertItem;
	
	
	
	 public void ShowDetails()
	 {
		 ClickButton(Ibutton);		
		 
	 }
	 public void BackFromSalesDetails()
	 {
		 ClickButton(BackBtn);
	 }
	
		 
	 
	 
	
}
