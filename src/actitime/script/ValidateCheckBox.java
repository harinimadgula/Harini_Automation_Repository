package actitime.script;

import org.testng.annotations.Test;

import actitime.pom.CheckBox;

public class ValidateCheckBox extends BaseTest
{
@Test
public void validateCheckBox()
{
log.debug("Validate the Checkbox Testcase");	
CheckBox c1 = new CheckBox(driver);
log.debug("Click on the CheckBox and check Chebox is selected or not");
c1.clickOnCheckBox();
}
}
