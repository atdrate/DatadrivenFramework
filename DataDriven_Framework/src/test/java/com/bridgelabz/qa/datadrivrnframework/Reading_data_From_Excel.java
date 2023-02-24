package com.bridgelabz.qa.datadrivrnframework;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Reading_data_From_Excel {
	@Test
	public  void reading_Data() throws IOException {
  
		FileInputStream file=new FileInputStream("C:\\Users\\AZ\\Downloads\\Username.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int rowcount=sheet.getLastRowNum();
		int colcount=sheet.getRow(0).getLastCellNum();
		
		for(int i=0;i<rowcount;i++)
		{
			XSSFRow currentrow=sheet.getRow(i);
			
			for(int j=0;j<colcount;j++)
			{
				String value=currentrow.getCell(j).toString();
				System.out.print("  " +value);	
			}
			System.out.println();
		}
}
}