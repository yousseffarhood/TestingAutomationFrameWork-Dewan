package Configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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
	@FindBy(linkText = "Payment Type")
	WebElement PaymentTypeBtn ;
	@FindBy(css = "a.col-md-3.form-group.text-success")
	WebElement PaymentPlusBtn;
	@FindBy(name = "DomainModel.PaymentTypeName")
	WebElement PaymentTypeNameTxtBox;
	@FindBy(id  = "DomainModel.AccountID")
	WebElement AccountIDTxtbox;
	@FindBy(xpath  = "//div[text()='aatest-atest']")
	List<WebElement> AccountIDList;
	@FindBy(css = "button.form-control.btn.btn-info")
	WebElement SaveBtn;
	@FindBy(id = "check")
	WebElement ExternalPaymentCheckBox;
	@FindBy(id = "ExternalPaymentTypeID")
	WebElement ExternalPaymentTypeIDDrpdwnlst;
	String port="3306";
	String host="localhost";
	@FindBy(css = "a.form-group.btn.btn-info")
	 WebElement Backbtn;
	//assertions
	@FindBy(xpath = "//table//tr[1]/td[1]")
	public WebElement AssertBasicPaymentType;
	@FindBy(xpath = "//table//tr[2]/td[1]")
	public WebElement AssertCashPaymentType;
	@FindBy(xpath = "//table//tr[3]/td[1]")
	public WebElement AssertChequePaymentType;
	@FindBy(xpath = "//table//tr[4]/td[1]")
	public WebElement AssertBankPaymentType;
	@FindBy(xpath = "//table//tr[5]/td[1]")
	public WebElement AssertCreditPaymentType;
	@FindBy(xpath = "//table//tr[6]/td[1]")
	public WebElement AssertAccSettPaymentType;
	@FindBy(xpath = "/html/body/div/main/div/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[5]/a[3]/i")
	WebElement DeleteBtn;
	@FindBy(css = "i.fas.fa-trash")
	WebElement DeleteBtn2;
	
	public void OpenPaymentType()
	{
		action.moveToElement(ConfigurationBtn).click().build().perform();
		ClickButton(ConfigurationBtn);
		ClickButton(PaymentTypeBtn);	

	}
	public void CreatePaymentTypesBasic(String paymentname,String AccountID)
	{			ClickButton(PaymentPlusBtn);

		SetTextElement(PaymentTypeNameTxtBox, paymentname);
		SetTextElement(AccountIDTxtbox, AccountID);
		AccountIDList.get(0).click();
		ClickButton(SaveBtn);

	}
	public void CreatePaymentTypeExternalSQL() throws SQLException, InterruptedException
	{			

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
			if(!ExternalPaymentCheckBox.isSelected())
			{
				ClickButton(ExternalPaymentCheckBox);
			}
			SetTextElement(PaymentTypeNameTxtBox, rs.getString("PaymentValue"));
			select.selectByValue(rs.getNString("PaymentValue"));
			ClickButton(SaveBtn);
			Thread.sleep(1000);
		}
		


	}
	public void BackToPaymentTypePage()
	{
		ClickButton(Backbtn);
		
		
	}
	public void DeletePaymentTypes()
	{
		while(!AssertBasicPaymentType.getText().isEmpty())
		{
			ClickButton(DeleteBtn);
			ClickButton(DeleteBtn2);
		}
		
	}
}
