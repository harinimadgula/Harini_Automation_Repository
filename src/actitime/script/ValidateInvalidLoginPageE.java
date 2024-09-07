package actitime.script;

import org.testng.annotations.Test;

import actitime.generics.Excel;
import actitime.pom.InvalidLoginPage;
import actitime.pom.LoginPage;

public class ValidateInvalidLoginPageE extends BaseTest
{
	@Test
	public void validateInvalidLoginPageE() throws InterruptedException
	{
		String sheet ="ValidateInvalidLoginPageE";
		LoginPage l1 = new LoginPage(driver);
		InvalidLoginPage il = new InvalidLoginPage(driver);
		int rowCount = Excel.getRowCount(PATH, sheet);
		for(int r=1;r<=rowCount;r++)
		{

			String un = Excel.getCellValue(PATH, sheet, r, 1);	
			String pw = Excel.getCellValue(PATH, sheet, r, 2);

			Thread.sleep(1000);
			l1.setUserName(un);
			l1.setPassWord(pw);
			Thread.sleep(1000);
			l1.clickOnLoginButton();
			il.validateInvalidLoginPage();
		}

	}

}
