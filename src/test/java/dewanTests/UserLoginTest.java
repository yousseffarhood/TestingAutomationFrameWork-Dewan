package dewanTests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import dewanPages.HomePage;
import dewanPages.UserLogOutPage;
import dewanPages.UserLoginPage;

public class UserLoginTest extends TestBase{

	String username="youssef";
	String password="1234";
	UserLoginPage Loginobj;
	HomePage HomePageObj;
	UserLogOutPage LogoutObj;
	
	
	String host="localhost";
	String port="3306";
		
	
	
	@Test(priority = 1)
	public void UserCanLogin() throws SQLException
	{	Connection con= DriverManager.getConnection("jdbc:mysql://"+host+":"+port +"/tst001" , "root", "Root");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * from Users where username='admin'");

		while(rs.next())
		
		{
//			System.out.println(rs.getString("username"));
//			System.out.println(rs.getString("password"));
		
		
		Loginobj=new UserLoginPage(driver);
		HomePageObj=new HomePage(driver);
		Loginobj.USerLogin(rs.getString("username"),rs.getString("password"));
		}
		//Loginobj.USerLogin(username,password);
		
		Assert.assertTrue(HomePageObj.WelcomeBoard.isDisplayed());
	}
	@Test(priority = 2)
	public void UserCanLogout() throws InterruptedException
	{
		LogoutObj=new UserLogOutPage(driver);
		LogoutObj.UserLogout();
	}
}
