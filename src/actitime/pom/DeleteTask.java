package actitime.pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DeleteTask extends BasePage
{
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
@FindBy(xpath="//a[text()='Open Tasks']")
private WebElement openTasksButton;
@FindBy(xpath="//td[@class='middle-right-cell']")
private WebElement customerProjectDropdown;
@FindBy(xpath="//table[@class='x-table-layout']//tr[2]//div[contains(@class,'x-form-radio-wrap-inner')]/input")
private WebElement selectedCustomerAndProjectRadioB;
@FindBy(xpath="//span[text()='Close']")
private WebElement closeButton;
@FindBy(id="tasksFilterSubmitButton")
private WebElement applyFilterButton;
@FindBy(xpath="//input[@value='Delete Selected Tasks']")
private WebElement deleteSelectedTaskButton;
@FindBy(xpath="//input[@value='Delete Tasks']")
private WebElement deleteTaskButton;
@FindBy(xpath="//span[@class='successmsg']")
private WebElement validateMsg;

public DeleteTask(WebDriver driver)
{
	super(driver);
	PageFactory.initElements(driver, this);
}
public void clickOnOpenTasks()
{
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Open Tasks']")));
	openTasksButton.click();
}
public void filterCustomerAndProject(String customerName)
{
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[@class='middle-right-cell']")));
	customerProjectDropdown.click();
	wait.until(ExpectedConditions.elementToBeClickable(selectedCustomerAndProjectRadioB));
	selectedCustomerAndProjectRadioB.click();
	String xpath ="//span[@title='" + customerName + "']//..//span[@class='checkbox']";
	WebElement customerProjectCheckbox = driver.findElement(By.xpath(xpath));
	wait.until(ExpectedConditions.elementToBeClickable(customerProjectCheckbox));
	customerProjectCheckbox.click();
}
public void clickOnCloseButton()
{
	wait.until(ExpectedConditions.elementToBeClickable(closeButton));	
	closeButton.click();
}
public void clickOnApplyFilterButton() 
{
wait.until(ExpectedConditions.elementToBeClickable(applyFilterButton));
applyFilterButton.click();
}
public void deleteTasks()
{
	List<WebElement> taskList = driver.findElements(By.xpath("((//td[text()='vv'] | //td[text()='vvf'])/..)//input[@type='checkbox']"));
	int size = taskList.size();
	for(WebElement task:taskList)
	{
		task.click();
	}
}
public void clickOnDeleteTaskButton()
{
	wait.until(ExpectedConditions.elementToBeClickable(deleteSelectedTaskButton));
	deleteSelectedTaskButton.click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td[text()='Confirm Tasks Deletion']")));
	deleteTaskButton.click();
}
public void validateDeleteTask()
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='successmsg']")));
	Assert.assertTrue(validateMsg.isDisplayed());
}
}
