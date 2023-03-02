package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreader {
static XSSFWorkbook wb;
	
	
	public static Object[][] getdatafromsheet(String sheetname)
	{
		System.out.println("**************Loading data from Excel************");
		Object arr[][]=null;
		
		try {
		 wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+("/testData/Login.xlsx"))));
		XSSFSheet sh = wb.getSheet(sheetname);
		int row = sh.getPhysicalNumberOfRows();
		int column=sh.getRow(0).getPhysicalNumberOfCells();
		arr=new Object[row][column];
		for(int i = 0 ; i<row;i++)
		{
			for(int j = 0 ;j<column;j++)
			{
				arr[i][j]=getdata(sheetname,i,j);
			}
		}
		
		} 
		
		
		catch (IOException e) {
			System.out.println("Could not found the file"+e.getMessage());
		}
		return arr;
	}
	
	public static String getdata(String sheetname , int row , int column)
	{
		String data ="";
		XSSFCell cell=wb.getSheet(sheetname).getRow(row).getCell(column);
		if(cell.getCellType()==CellType.STRING)
		{
		data=cell.getStringCellValue();	
		}
		
		else if(cell.getCellType()==CellType.NUMERIC)
		{
			
		data=	String.valueOf(cell.getNumericCellValue());
		}
		else if(cell.getCellType()==CellType.BLANK)
		{
			data="";
		}
		return data;
	}
}
