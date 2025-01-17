package actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage
{
//D
@FindBy(id="logoutLink")
private WebElement logoutButton;

//I
public HomePage(WebDriver driver)
{
	super(driver);
PageFactory.initElements(driver, this);	
}

//U

public void clickOnLogoutButton()
{
	logoutButton.click();
}
}
