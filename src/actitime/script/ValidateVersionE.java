package actitime.script;

import org.testng.annotations.Test;

import actitime.generics.Excel;
import actitime.pom.Version;

public class ValidateVersionE extends BaseTest
{
@Test
public void validateVersionE()
{
	String sheet ="ValidateVersionE";
	Version v1 = new Version(driver);
	String eVersion = Excel.getCellValue(PATH, sheet, 1, 1);
	v1.validateVersion(eVersion);
}
}
