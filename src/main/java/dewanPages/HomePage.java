package dewanPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse=(JavascriptExecutor) driver;
		action=new Actions(driver);
		
	}

	@FindBy(xpath  =".//a[contains(@href,'/test/QuickSales')]")
	public WebElement QuickSales;
	public void OpenQuickSales() throws InterruptedException
	{
		ScrollToBottom(QuickSales);	
		Thread.sleep(2000);
		action.moveToElement(QuickSales).click().build().perform();
		
	}
	@FindBy(xpath = ".//a[contains(@href,'/test/TasksAndWorkflow')]")
	WebElement TasksAndWorkflowLink;
	@FindBy(css="main.pb-3")
	public WebElement TasksAndWorkflow;
	
	public void OpenTasksAndWorkflow() throws InterruptedException  
	{
		ScrollToBottom(TasksAndWorkflowLink);		
		Thread.sleep(2000);
		action.moveToElement(TasksAndWorkflowLink).click().build().perform();
	}
}
