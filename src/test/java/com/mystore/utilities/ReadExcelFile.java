package com.mystore.utilities;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class ReadExcelFile {


	public static FileInputStream inputStream;
	public static XSSFWorkbook workBook;
	public static XSSFSheet excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;

// getCellValue Method
	public static String getCellValue(String fileName /*column no*/, String sheetName, int rowNo, int cellNo /*column no*/)
	{

		try {
			inputStream=new FileInputStream(fileName);			
			workBook=new XSSFWorkbook(inputStream);
			excelSheet=workBook.getSheet(sheetName);
			XSSFCell ceLL = workBook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);

			//workBook.close();

			return ceLL.getStringCellValue();

		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();			

			return"";
		}

	}

//getRowCount Method
	
	public static int getRowCount(String fileName, String sheetName)		
	{
		try
		{			
			FileInputStream inputStream=new FileInputStream(fileName); 
			workBook=new XSSFWorkbook(inputStream);
			excelSheet=workBook.getSheet(sheetName);

			//get Total no of Rows
			int ttlRows=excelSheet.getLastRowNum()+1;
		//	workBook.close();
			return ttlRows;
		} catch (Exception e)
		{
			return 0;
		}

	}

//getColCount method
	
	public static int getColCount(String fileName, String sheetName)		
	{
		try
		{			
			FileInputStream inputStream=new FileInputStream(fileName); 
			workBook=new XSSFWorkbook(inputStream);
			excelSheet=workBook.getSheet(sheetName);

			//get Total no of Column
			int ttlCells=excelSheet.getRow(0).getLastCellNum();
			workBook.close();
			return ttlCells;
		} catch (Exception e)
		{
			return 0;
		}

	}




}
