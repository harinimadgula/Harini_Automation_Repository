package actitime.pom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddTask extends BasePage
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	@FindBy(xpath="//div[text()='TIME-TRACK']")
	private WebElement timeTrack;
	@FindBy(xpath="//td[@class='formselectpane']//img")
	private WebElement timeTrackDropdown;
	@FindBy(xpath="//span[text()='Barber, Robert']")
	private WebElement selectLoggedUser;
	@FindBy(xpath="//span[text()='Add Tasks from the List']")
	private WebElement addTasks;
	@FindBy(xpath="//div[contains(text(),'Select customer or project')]")
	private WebElement addTaskTitle;
	@FindBy(xpath="(//td[@class='dropdownButton'])[1]")
	private WebElement customerDropdown;
	@FindBy(className="addSelectedButton")
	private WebElement addSelectedButton;
	@FindBy(xpath="//span[@class='task']")
	private WebElement validatedTask;


	public AddTask(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public void selectTimeTrack()
	{
		wait.until(ExpectedConditions.elementToBeClickable(timeTrack));	
		timeTrack.click();
	}
	public void clickOnTimetrackDropdown()
	{
		wait.until(ExpectedConditions.elementToBeClickable(timeTrackDropdown));
		timeTrackDropdown.click();
	}
	public void selectLoggedUser()
	{

		selectLoggedUser.click();
		System.out.println("The user is selected successfully");

	}
	public void selectAddTasks()

	{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Add Tasks from the List']")));
		addTasks.click();
	}
	public void validateAddTaskTitle()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Select customer or project')]")));
		System.out.println("Add Task title is validated");
	}
	public void selectCustomer(String customer)
	{
		wait.until(ExpectedConditions.elementToBeClickable(customerDropdown));
		Actions action = new Actions(driver);
		action.moveToElement(customerDropdown).perform();
		customerDropdown.click();
		List<WebElement> listOfCustomers = driver.findElements(By.xpath("//table[@class='row customer']//tr/td[1]"));

		int count = listOfCustomers.size();
		for(int i=0;i<count;i++)
		{
			if(listOfCustomers.get(i).getText().contains(customer))
			{
				action.moveToElement(listOfCustomers.get(i)).click().perform();
				break;
			}
			
		}

	}
public void selectTask()
{
	List<WebElement> checkBoxList = driver.findElements(By.xpath("(//table//input[@type='checkbox'])[2]"));
	int size = checkBoxList.size();
	for(int i=0;i<size;i++)
	{
		checkBoxList.get(i).click();
	}
	
}
public void clickOnAddSelectedButton()
{
wait.until(ExpectedConditions.elementToBeClickable(addSelectedButton));
addSelectedButton.click();
}
public void getTaskByCustomerAndProject(String customerName, String projectName, List<String> aTasks) 
{
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='successmsg']")));
    // Construct the XPath based on customer and project names
    String xpath = "((//td[@class='task-customer-and-project']/span[@class='customer' and text()='" + customerName + "'] | //span[@class='project' and text()='" + projectName + "'])/../..)/preceding-sibling::tr//span[@class='task']";
    ArrayList<String> eTasks = new ArrayList<String>();
    // Find the task elements using the constructed XPath
    List<WebElement> tasks = driver.findElements(By.xpath(xpath));
    
    // Iterate over tasks and print their names
    for (WebElement task : tasks) {
    	eTasks.add(task.getText());
        System.out.println("Task Name: " + task.getText());
        System.out.println("Expected Tasks "+eTasks);
    }
Assert.assertEquals(aTasks, eTasks);   
}

}

