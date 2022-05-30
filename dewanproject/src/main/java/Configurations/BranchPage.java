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

public class BranchPage extends PageBase{

	public BranchPage(WebDriver driver) {
		super(driver);
		action=new Actions(driver);
	}
	@FindBy(xpath   = "(//*[@id=\"navbarDropdown\"])[3]")
	WebElement ConfigurationBtn;
	@FindBy(linkText = "Branch")
	WebElement BranchBtn;
	@FindBy(css = "i.text-success.fas.fa-plus-square.fa-sm")
	WebElement BranchPlusSymbol;
	@FindBy(name = "DomainModel.BranchName")
	WebElement BranchNameTxtBox;
	@FindBy(name = "DomainModel.BranchAddress")
	WebElement BranchAddressTxtbox;
	@FindBy(css = "button.form-control.btn.btn-info")
	WebElement SaveBtn;
	@FindBy(xpath = "//a[contains(@href,'/QuickSales/Branch/Details')]")
	WebElement BackbtnPaymentTypePage;
	@FindBy(xpath = "//a[contains(@href,'/QuickSales/BranchPaymentType/Create/')]")
	WebElement BranchPaymentTypePlus;
	@FindBy(id = "PaymentTypeID")
	WebElement PaymentTypeDrpdwnlst;
	@FindBy(xpath = "//a[contains(text(),'Back')]")
	WebElement BackBtnToBranchPage;
	String host="localhost";
	String port="3306";



	public void OpenBranchTab()
	{
		action.moveToElement(ConfigurationBtn).click().build().perform();
		ClickButton(ConfigurationBtn);
		ClickButton(BranchBtn);		
	}
	public void CreateBranch(String BranchName,String BranchAddress) throws InterruptedException, SQLException
	{
		ClickButton(BranchPlusSymbol);
		SetTextElement(BranchNameTxtBox, BranchName);
		SetTextElement(BranchAddressTxtbox, BranchAddress);
		ClickButton(SaveBtn);
		//create a payment type for the branch
		ClickButton(BranchPaymentTypePlus);
		//select payment type from the dropwonlist
		select=new Select(PaymentTypeDrpdwnlst);

		Connection con= DriverManager.getConnection("jdbc:mysql://"+host+":"+port +"/tst001" , "root", "Root");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select branchvalue from branchnames");

		while(rs.next())

		{ select.selectByValue(rs.getString("branchvalue"));
		ClickButton(SaveBtn);

		}
		Thread.sleep(2000);
		ClickButton(BackbtnPaymentTypePage);
		Thread.sleep(2000);
		ClickButton(BackBtnToBranchPage);
		//ExplicitWaitClick(BackbtnPaymentTypePage);

		//		ExplicitWaitClick(BackbtnPaymentTypePage);
		//	
		//		
		//		
		//		
		//		ExplicitWaitClick(BackBtnToBranchPage);
		//		ClickButton(BackBtnToBranchPage);





	}
}