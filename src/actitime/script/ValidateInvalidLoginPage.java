package actitime.script;

import org.testng.annotations.Test;

import actitime.pom.InvalidLoginPage;
import actitime.pom.LoginPage;

public class ValidateInvalidLoginPage extends BaseTest
{
@Test
public void validateInvalidLoginPage()
{
	LoginPage l1 = new LoginPage(driver);
	l1.setUserName("aaaa");
	l1.setPassWord("bbbbbb");
	l1.clickOnLoginButton();
	InvalidLoginPage i1 = new InvalidLoginPage(driver);
	i1.validateInvalidLoginPage();
}
}
