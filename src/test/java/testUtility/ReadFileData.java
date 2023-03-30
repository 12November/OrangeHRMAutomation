package testUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFileData 
{
	public static String fetchDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException
	{
	/*	String path = "src\\test\\resources\\TestExcel";  */
	//since in mac we use"/" as file separator than windows "\\" the above path must be compatible with all OS
//By using File.separator, it will call appropriate separator accordingly		
		
		String data="";
		//String path = "src\\test\\resources\\TestExcel\\ExcelTestdata.xlsx";
		String path = "src"+File.separator+"test"+File.separator+"resources"+File.separator+"TestExcel"+File.separator+"ExcelTestdata.xlsx";
		System.out.println(path);
		FileInputStream file = new FileInputStream(path);
		Sheet s = WorkbookFactory.create(file).getSheet("userlogin");
		
		Cell c = s.getRow(row).getCell(cell);
		CellType type = c.getCellType();
		
		if(type==CellType.STRING)
		{
			 data = c.getStringCellValue();
			 System.out.println(data);
		}
		else if(type==CellType.NUMERIC)
		{
			 double number = c.getNumericCellValue();
			 data = Double.toString(number);    //double is wrapper class of double data type
		}
		else if(type==CellType.BLANK)
		{
			 data = "";
		}
		return data; 
	
	}
}
