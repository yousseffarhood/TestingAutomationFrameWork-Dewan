package Configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import dewanPages.PageBase;

public class PaymentType extends PageBase {

	public PaymentType(WebDriver driver) {
		super(driver);
		action=new Actions(driver);


	}
	@FindBy(xpath   = "(//*[@id=\"navbarDropdown\"])[3]")
	WebElement ConfigurationBtn;
	@FindBy(linkText = "Payment Type ")
	WebElement PaymentTypeBtn ;
	@FindBy(css = "a.col-md-3.form-group.text-success")
	WebElement PaymentPlusBtn;
	@FindBy(name = "DomainModel.PaymentTypeName")
	WebElement PaymentTypeNameTxtBox;
	@FindBy(xpath  = "//div[text()='aatest-atest']")
	WebElement AccountIDTxtbox;
	@FindBy(css = "button.form-control.btn.btn-info")
	WebElement SaveBtn;
	@FindBy(id = "check")
	WebElement ExternalPaymentCheckBox;
	@FindBy(id = "ExternalPaymentTypeID")
	WebElement ExternalPaymentTypeIDDrpdwnlst;
	String port="3306";
	String host="localhost";

	public void OpenPaymentType()
	{
		action.moveToElement(ConfigurationBtn).click().build().perform();
		ClickButton(ConfigurationBtn);
		ClickButton(PaymentTypeBtn);	
	}
	public void CreatePaymentTypesBasic(String paymentname,String AccountID)
	{
		ClickButton(PaymentPlusBtn);
		SetTextElement(PaymentTypeNameTxtBox, paymentname);
		SetTextElement(AccountIDTxtbox, AccountID);
		select.selectByIndex(-1);
		ClickButton(SaveBtn);

	}
	public void CreatePaymentTypeExternalSQL() throws SQLException
	{
		ClickButton(PaymentPlusBtn);
		if(!ExternalPaymentCheckBox.isSelected())
		{
			ClickButton(ExternalPaymentCheckBox);
		}
		select=new Select(ExternalPaymentTypeIDDrpdwnlst);
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/tst001", "root", "Root");
		Statement s= con.createStatement();
		ResultSet rs=s.executeQuery("select PaymentValue from branchnames");
		while(rs.next())
		{
			SetTextElement(PaymentTypeNameTxtBox, rs.getString("PaymentValue"));
			select.selectByValue(rs.getNString("PaymentValue"));
			ClickButton(SaveBtn);
		}
		

	}
}
