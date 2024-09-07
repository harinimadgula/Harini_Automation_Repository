package actitime.script;

import java.util.List;

import org.testng.annotations.Test;

import actitime.generics.Excel;
import actitime.pom.AddTask;
import actitime.pom.CreateTask;
import actitime.pom.LoginPage;

public class ValidateAddTask extends BaseTest 
{
@Test
public void validateAddTask() throws InterruptedException
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
	Thread.sleep(1000);
	t.selectCustomer();
	String sheet1 ="ValidateTaskE";
	String customerName = Excel.getCellValue(PATH, sheet1, 1, 1);
	String projectName = Excel.getCellValue(PATH, sheet1, 1, 2);
	String taskName = Excel.getCellValue(PATH, sheet1, 1, 3);
	t.enterCustomerName(customerName);
	t.enterProjectName(projectName);
	t.entertaskName(taskName);
	List<String> aTasks = t.getEnteredTasks();
	t.clickOnCreateTaskButton();
	Thread.sleep(3000);
	t.validateSelectedCustomer();
	AddTask a1 = new AddTask(driver);
	a1.selectTimeTrack();
	a1.clickOnTimetrackDropdown();
	a1.selectLoggedUser();
	a1.selectAddTasks();
	a1.validateAddTaskTitle();
	a1.selectCustomer(customerName);
	a1.selectTask();
	a1.clickOnAddSelectedButton();
	a1.getTaskByCustomerAndProject(customerName, projectName,aTasks);
	Thread.sleep(2000);
}



}
