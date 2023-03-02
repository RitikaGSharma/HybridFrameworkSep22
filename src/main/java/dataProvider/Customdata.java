package dataProvider;

import org.testng.annotations.DataProvider;


public class Customdata {
	@DataProvider(name="logindetails")
	public static Object[][] getdata()
	{
		Object arr[][]=Excelreader.getdatafromsheet("Sheet1");
		return arr;
	}


}
