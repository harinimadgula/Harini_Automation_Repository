package actitime.pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUser extends BasePage
{
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
@FindBy(xpath="//div[text()='USERS']")
private WebElement users;
@FindBy(xpath="//div[text()='Add User']")
private WebElement addUser;
public CreateUser(WebDriver driver)
{
	super(driver);
	PageFactory.initElements(driver, this);
}
public void clickOnUser()
{
	wait.until(ExpectedConditions.elementToBeClickable(users));
	users.click();
}
public void clickOnAddUser()
{
	wait.until(ExpectedConditions.elementToBeClickable(addUser));
	addUser.click();
}
}
