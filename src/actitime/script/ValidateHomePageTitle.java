package actitime.script;

import org.testng.annotations.Test;

import actitime.pom.HomePage;
import actitime.pom.LoginPage;

public class ValidateHomePageTitle extends BaseTest 
{
@Test
public void validateHomePageTitle()
{
	LoginPage l1 =new LoginPage(driver);
	l1.setUserName("admin");
	l1.setPassWord("manager");
	l1.clickOnLoginButton();
	HomePage h1 = new HomePage(driver);
	h1.getTitle("actiTIME - Enter Time-Track");
}
}
