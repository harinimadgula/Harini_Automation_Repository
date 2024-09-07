package actitime.pom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public abstract class BasePage 
{
public WebDriver driver;
public BasePage(WebDriver driver)
{
	this.driver =driver;
}
public void getTitle(String eTitle)
{
	String aTitle = driver.getTitle();
	Assert.assertEquals(aTitle, eTitle);
	System.out.println("Successfully validated Title");
}
}
