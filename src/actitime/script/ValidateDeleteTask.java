package actitime.script;

import org.testng.annotations.Test;

import actitime.generics.Excel;
import actitime.pom.CreateTask;
import actitime.pom.DeleteTask;
import actitime.pom.LoginPage;

public class ValidateDeleteTask extends BaseTest
{
@Test
public void validateDeleteTask() throws InterruptedException
{
	String sheet = "ValidLoginPageE";
	LoginPage l1 = new LoginPage(driver);
	String un = Excel.getCellValue(PATH, sheet, 1, 1);
	String pw = Excel.getCellValue(PATH, sheet, 1, 2);
	l1.setUserName(un);
	l1.setPassWord(pw);
	l1.clickOnLoginButton();
	CreateTask t = new CreateTask(driver);
	String sheet1 = "ValidateTaskE";
	String customerName = Excel.getCellValue(PATH, sheet1, 1, 1);
	String projectName = Excel.getCellValue(PATH, sheet1, 1, 2);
	String task1 = Excel.getCellValue(PATH, sheet1, 1, 3);
	String task2 = Excel.getCellValue(PATH, sheet1, 1, 4);
	String task3 = Excel.getCellValue(PATH, sheet1, 1, 5);
	String task4 = Excel.getCellValue(PATH, sheet1, 1, 6);
	String task5 = Excel.getCellValue(PATH, sheet1, 1, 7);
	Thread.sleep(3000);		
	t.clickOnTask();
	Thread.sleep(1000);
	t.clickOnCreateTaskButton();
	t.validateCreateTaskTitle();
	t.selectCustomer();
	t.enterCustomerName(customerName);
	t.enterProjectName(projectName);
	t.entertaskNames(task1,task2,task3,task4,task5);
	Thread.sleep(2000);
	t.clickOnCreateTaskButton();
	Thread.sleep(3000);
	DeleteTask d1 = new DeleteTask(driver);
	d1.clickOnOpenTasks();
	d1.filterCustomerAndProject(customerName);
	d1.clickOnCloseButton();
	d1.clickOnApplyFilterButton();
	Thread.sleep(2000);
	d1.deleteTasks();
	d1.clickOnDeleteTaskButton();
	d1.validateDeleteTask();
	
}
}
