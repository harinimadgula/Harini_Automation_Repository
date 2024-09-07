package actitime.pom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




public class CreateTask extends BasePage
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	//D
	@FindBy(xpath="//div[text()='TASKS']")
	private WebElement task;
	@FindBy(xpath="//span[text()='Create Tasks']")
	private WebElement createTask;
	@FindBy(xpath="//div[contains(text(),'Create New Tasks')]")
	private WebElement createTaskTitle;
	@FindBy(xpath="//div[@id='createTasksPopup_customerSelector']//tbody//td[2]")
	private WebElement selectCustomer;
	@FindBy(xpath="//div[contains(@class,'customerProjectListSelector')]/ul/li[2]/a")
	private WebElement newCustomer;
	@FindBy(id="createTasksPopup_newCustomer")
	private WebElement customerName;
	@FindBy(id="createTasksPopup_newProject")
	private WebElement newProjectName;
	@FindBy(xpath="(//input[@placeholder='Enter task name'])[1]")
	private WebElement taskName1;
	@FindBy(xpath="(//input[@placeholder='Enter task name'])[2]")
	private WebElement taskName2;
	@FindBy(xpath="(//input[@placeholder='Enter task name'])[3]")
	private WebElement taskName3;
	@FindBy(xpath="(//input[@placeholder='Enter task name'])[4]")
	private WebElement taskName4;
	@FindBy(xpath="(//input[@placeholder='Enter task name'])[5]")
	private WebElement taskName5;
	@FindBy(xpath="(//span[text()='Create Tasks'])[1]")
	private WebElement createTaskButton;
	@FindBy(xpath="//table[contains(@class,'listTable withRoundCorners')]//tr[3]/td[1]")
	private WebElement customer;


	public String cName1;
	public String cName2;
	//I
	public CreateTask(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);	
	}
	//U
	public List<String> getEnteredTasks() {
	    List<WebElement> enteredTasks = driver.findElements(By.xpath("//input[@placeholder='Enter task name']"));
	    List<String> aTask = new ArrayList<>();
	    for (WebElement aTaskList : enteredTasks) {
	        String text = aTaskList.getAttribute("value");
	        if (text != null && !text.trim().isEmpty()) {
	            aTask.add(text);
	        }
	    }
	    return aTask;
	}
	public void clickOnTask()
	{
		wait.until(ExpectedConditions.elementToBeClickable(task));
		task.click();	
	}
	public void clickOnCreateTask()
	{
		wait.until(ExpectedConditions.elementToBeClickable(createTask));
		createTask.click();
	}
	public void validateCreateTaskTitle()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Create New Tasks')]")));

		System.out.println("****Create Task Screen Displayed****");
	}
	public void selectCustomer()
	{
		wait.until(ExpectedConditions.elementToBeClickable(selectCustomer));
		selectCustomer.click();	

		wait.until(ExpectedConditions.elementToBeClickable(newCustomer));
		newCustomer.click();
	}
	public void enterCustomerName(String cName) 
	{
		customerName.sendKeys(cName);
		cName1 = customerName.getAttribute("value");
		System.out.println(cName1);
	}
	public void enterProjectName(String pName)
	{
		newProjectName.sendKeys(pName);
	}
	public void entertaskName(String tName1)
	{
		taskName1.sendKeys(tName1);
	}
	public void entertaskNames(String tName1,String tName2,String tName3,String tName4,String tName5)
	{
		taskName1.sendKeys(tName1);
		taskName2.sendKeys(tName2);
		taskName3.sendKeys(tName3);
		taskName4.sendKeys(tName4);
		taskName5.sendKeys(tName5);
	}
	public void clickOnCreateTaskButton()
	{
		createTaskButton.click();
	}
	public void validateSelectedCustomer() throws InterruptedException
	{

		cName2 =customer.getText();
		System.out.println(cName2);
		Thread.sleep(2000);
		Assert.assertEquals(cName1, cName2);
	}

}
