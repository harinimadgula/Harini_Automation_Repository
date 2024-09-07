package actitime.script;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import actitime.generics.Excel;
import actitime.pom.HomePage;
import actitime.pom.LoginPage;

public class ValidateLoginPageE extends BaseTest 
{

@Test
public void validateLoginPageE()
{
String sheet ="ValidLoginPageE";
 LoginPage l1 = new LoginPage(driver);
 String un = Excel.getCellValue(PATH, sheet, 1, 1);
 String pw = Excel.getCellValue(PATH, sheet, 1, 2);
 String lpt = Excel.getCellValue(PATH, sheet, 1, 3);
 String hpt = Excel.getCellValue(PATH, sheet, 1, 4);
 l1.getTitle(lpt);
 l1.setUserName(un);
 l1.setPassWord(pw);
 l1.clickOnLoginButton();

 HomePage h1 = new HomePage(driver);
 h1.getTitle(hpt);
}
}
