package actitime.script;

import org.testng.annotations.Test;

import actitime.generics.Excel;
import actitime.pom.LoggedInUser;
import actitime.pom.LoginPage;

public class ValidateLoggedInUserE extends BaseTest
{
@Test
public void validateLoggedInUserE()
{
	String sheet ="ValidLoginPageE";
	LoginPage l1 = new LoginPage(driver);
	LoggedInUser liu = new LoggedInUser(driver);
	String un = Excel.getCellValue(PATH, sheet, 1, 1);
	String pw = Excel.getCellValue(PATH, sheet, 1, 2);
	String lu = Excel.getCellValue(PATH, sheet, 1, 5);
	l1.setUserName(un);
	l1.setPassWord(pw);
	l1.clickOnLoginButton();
	liu.ValidateloggedUser(lu);
}
}
