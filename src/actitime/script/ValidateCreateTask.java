package actitime.script;

import java.util.List;

import org.testng.annotations.Test;

import actitime.generics.Excel;
import actitime.pom.CreateTask;
import actitime.pom.LoginPage;

public class ValidateCreateTask extends BaseTest
{
	@Test
	public void validateCreateTask() throws InterruptedException
	{
		String sheet ="ValidLoginPageE";
		LoginPage l1 =new LoginPage(driver);
		String un = Excel.getCellValue(PATH, sheet, 1, 1);
		String pw = Excel.getCellValue(PATH, sheet, 1, 2);
		l1.setUserName(un);
		l1.setPassWord(pw);
		l1.clickOnLoginButton();
		CreateTask t = new CreateTask(driver);
		Thread.sleep(3000);		
		t.clickOnTask();
		Thread.sleep(1000);
		t.clickOnCreateTaskButton();
		t.validateCreateTaskTitle();
		t.selectCustomer();
		String sheet1 ="ValidateTaskE";
		String customerName = Excel.getCellValue(PATH, sheet1, 2, 1);
		String projectName = Excel.getCellValue(PATH, sheet1, 2, 2);
		String taskName = Excel.getCellValue(PATH, sheet1, 2, 3);
		t.enterCustomerName(customerName);
		t.enterProjectName(projectName);
		t.entertaskName(taskName);
		t.clickOnCreateTaskButton();
		Thread.sleep(3000);
		t.validateSelectedCustomer();
	}
}
