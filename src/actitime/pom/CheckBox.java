package actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckBox extends BasePage
{
//D
@FindBy(id="keepLoggedInCheckBox")	
private WebElement checkbox;

//I
public CheckBox(WebDriver driver)
{
	super(driver);
	PageFactory.initElements(driver, this);
}

//U

public void clickOnCheckBox()
{
	checkbox.click();
	Assert.assertTrue(checkbox.isSelected());
	
}
}
