package dewanPages;

import java.sql.ResultSet;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
		protected WebDriver driver;
		public Select select;
		public Actions action;
		public JavascriptExecutor jse;

		public PageBase(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
			
		}
		
		public void ClickButton(WebElement element)
		{
		element.click();
		}
		public void ClickListButton(List<WebElement> elements)
		{
		((WebElement) elements).click();
		}
		public void SetTextElement(WebElement element,String text )
		{
			element.sendKeys(text);
		}
		public void SetResultElement(WebElement element, ResultSet text)
		{
			
		}
		public void ScrollToBottom(WebElement webelment)
				{
				//	jse.executeScript("scrollBy(0, 2500)");
					jse.executeScript("arguments[0].scrollIntoView()", webelment);
				}
		public void ClickOnWebElement(WebElement element1)
		{
			jse.executeScript("arguments[0].click();", element1);
		}
		

}
