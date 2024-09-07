package actitime.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoggedInUser extends BasePage
{
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));	
@FindBy(xpath="//a[contains(@class,'userProfileLink')]")
private WebElement loggedUser;

public LoggedInUser(WebDriver driver)
{
	super(driver);
	PageFactory.initElements(driver, this);
}
public void ValidateloggedUser(String eUser)
{
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class,'userProfileLink')]")));
	String aUser = loggedUser.getText();
	Assert.assertEquals(aUser, eUser);
	System.out.println("user validated successfully");
}
}
