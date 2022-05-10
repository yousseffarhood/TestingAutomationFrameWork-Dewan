package configurations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import dewanPages.HomePage;
import dewanPages.UserLoginPage;
import dewanTests.TestBase;

public class BranchTest extends TestBase{
	UserLoginPage LoginObj;
	HomePage HomeObj;
	Configurations.BranchPage BranchObj;
//	String Username;
//	String Password;
//	String BranchName="Tst001";
//	String BranchAddress="DDT";
	String host="localhost";
	String port="3306";
	@Test(priority = 1)
	public void UserLoginWithSQL() throws SQLException
	{
		Connection con= DriverManager.getConnection("jdbc:mysql://"+host+":"+port +"/tst001" , "root", "Root");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * from Users where username='admin'");

		while(rs.next())

		{
			LoginObj=new UserLoginPage(driver);
			HomeObj=new HomePage(driver);
			LoginObj.USerLogin(rs.getString("username"),rs.getString("password"));
		}
		
	}
	
	
	@Test(priority =2)
	public void BranchWithSQL() throws SQLException, InterruptedException
	{
		HomeObj=new HomePage(driver);
		HomeObj.OpenQuickSales();
		BranchObj=new Configurations.BranchPage(driver);
		BranchObj.OpenBranchTab();
		Connection con= DriverManager.getConnection("jdbc:mysql://"+host+":"+port +"/tst001" , "root", "Root");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * from branchnames");
		
		
		while(rs.next())

		{
			
			BranchObj.CreateBranch (rs.getString("branch"),rs.getString("branchadress"));


		}
		System.out.println("test this here");

	}
	
	
	
	
	@Test(priority = 3,enabled = false)
	public void FillBranch() throws InterruptedException
	{

		HomeObj=new HomePage(driver);
		HomeObj.OpenQuickSales();
		BranchObj=new Configurations.BranchPage(driver);
		BranchObj.OpenBranchTab();
		//BranchObj.CreateBranch(BranchName, BranchAddress);

	}
	

}
