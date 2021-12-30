package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DewanLoginExcelReader {
static FileInputStream fis=null;
public FileInputStream GetFileInputStream() throws IOException  
{   System.out.println(System.getProperty("user.dir"));
	String FilePath=System.getProperty("user.dir")+"/src/test/java/data/logged users.xlsx";
	File srcfile=new File(FilePath);
	try {
		fis=new FileInputStream(srcfile);
	} catch (FileNotFoundException e)
	{
		System.out.println("there is an error in path");
		System.exit(0);
	}
	return fis;	
}

	public Object[][] GetExcelData() throws IOException
	{
		
		fis=GetFileInputStream();
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int TotalNoOfRows=(sheet.getLastRowNum()+1);
		int TotalNoOfCols=2;
		String[][] ArrayOfExcelData=new String[TotalNoOfRows][TotalNoOfCols];
		for(int i=0;i<TotalNoOfRows;i++)
		{
			for(int j=0;j<TotalNoOfCols;j++)
			{
				XSSFRow row=sheet.getRow(i);
				ArrayOfExcelData[i][j]=row.getCell(j).toString();
			}
		}
		wb.close();
		return ArrayOfExcelData;
		}
}
