package actitime.script;

import org.testng.annotations.Test;

import actitime.pom.LoginPage;

public class ValidateValidLoginPage extends BaseTest
{
@Test
public void validateValidLoginPage()
{
	LoginPage l1 = new LoginPage(driver);
	l1.setUserName("admin");
	l1.setPassWord("manager");
	l1.clickOnLoginButton();
}
}
 