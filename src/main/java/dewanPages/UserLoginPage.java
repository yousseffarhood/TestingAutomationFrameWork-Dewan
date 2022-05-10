package dewanPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLoginPage extends PageBase{

	public UserLoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "UserName")
	WebElement UserNameTxtbox;
	@FindBy(id = "Password")
	WebElement PasswordTxtbox;
	@FindBy(css = "button.col-3")
	WebElement LoginBtn;
	
	public void USerLogin(String username,String password)
	{
		
		SetTextElement(UserNameTxtbox, username);
		SetTextElement(PasswordTxtbox, password);
		ClickButton(LoginBtn);

	}
}
