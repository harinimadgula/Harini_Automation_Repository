package actitime.generics;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel 
{
	//count total rows in the sheet
public static int getRowCount(String path,String Sheet)
{
int rc=0;
try
{
	FileInputStream fis = new FileInputStream(path);
	Workbook workbook = WorkbookFactory.create(fis);
	rc = workbook.getSheet(Sheet).getLastRowNum();
}
catch (Exception e) 
{
	
}
return rc;
}
//-----------get the cell value of particular row-----------------------------
public static String getCellValue(String path,String Sheet,int r, int c)
{
	String v=" ";
try
{
	FileInputStream fis = new FileInputStream(path);
	Workbook workbook = WorkbookFactory.create(fis);
	v = workbook.getSheet(Sheet).getRow(r).getCell(c).toString();
}
catch (Exception e) 
{
	
}
return v;
}
}
