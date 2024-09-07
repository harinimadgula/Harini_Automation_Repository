package actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage
{
//D
@FindBy(id="username")
private WebElement username;
@FindBy(name="pwd")
private WebElement password;
@FindBy(id="loginButton")
private WebElement LoginButton;

//I
public LoginPage(WebDriver driver)
{
super(driver);
PageFactory.initElements(driver, this);	
}

//Utilization

//set username

public void setUserName(String uName)
{
	username.sendKeys(uName);

}
//set password
public void setPassWord(String pw)
{
	password.sendKeys(pw);
}
//click on login button
public void clickOnLoginButton()
{
	LoginButton.click();
}
}
