package dewanPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLogOutPage extends PageBase {

	public UserLogOutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "dropdownMenuButton")
	WebElement dropdownMenuButton;
	@FindBy(linkText = "Log out")
	WebElement LogOut;
	@FindBy(css = "h1.welcomeText")
	public WebElement LogoutAssertion;
	public void UserLogout() throws InterruptedException
	{
		ClickButton(dropdownMenuButton);
		Thread.sleep(500);
		ClickButton(dropdownMenuButton);

		ClickButton(LogOut);
	}
}
