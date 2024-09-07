package actitime.script;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements AutomationConstantFile
{
public WebDriver driver;
Logger log;
@BeforeMethod
public void preCondition() throws InterruptedException
{
	log = Logger.getLogger("devpinoyLogger");
	log.debug("Open the Browser");
	driver= new ChromeDriver();
	log.debug("Maximize the Browser");
	driver.manage().window().maximize();
	log.debug("Enter the URL");
	driver.get("http://localhost/login.do");
	Thread.sleep(2000);
	log.debug("Apply the Implicit wait 120 seconds");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
}
@AfterMethod
public void postCondition() throws InterruptedException
{
Thread.sleep(2000);
log.debug("Close the Browser");
driver.close();
}
}
