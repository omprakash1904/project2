package com.prakash.automation.Supporters;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileReusables {
	static String filepath;
	static File file;
	static Workbook wb;
	static Sheet sheet;
	static String SheetName;
	static Row row;
	static Cell cell;
	static String cellValue;
	static int lastRowNo;
	static int lastCellNo;
	public ExcelFileReusables(String filepath) throws EncryptedDocumentException,IOException, InvalidFormatException
	{
		this.filepath=filepath;
		file=new File(filepath);
		wb=WorkbookFactory.create(file);
	}
	public static void getSheet(String sheetName)
	{
		if(wb!=null)
			sheet=wb.getSheet(sheetName);
		else
			System.out.println("workbook is pointing to null");
	}
	public static int getRow(String sheetName,int rowNo)
	{
		if(wb!=null)
		{
			sheet=wb.getSheet(sheetName);
			if(sheet!=null){
				row=sheet.getRow(rowNo);
			}
			else
				System.out.println("sheet is empty,pointing to null");
		}
		else
			System.out.println("workbook is pointing to null");
		return rowNo;
	}
	public static int getCell(String sheetName,int rowNo,int cellNo)
	{
		if(wb!=null)
		{
			sheet=wb.getSheet(sheetName);
			if(sheet!=null)
			{
				row=sheet.getRow(rowNo);
				if(row!=null){
				cell=row.getCell(cellNo);
				}
				else
					System.out.println("row is pointing to null");
			}
			else
				System.out.println("Sheet is pointing to null");
		}
		else
			System.out.println("workbook is pointing to null");
		return cellNo;
	}
	public static String getCellValue(String workbook,String sheetName,int rowNo,int cellNo,String cellValue) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		if(wb!=null)
		{
			sheet=wb.getSheet(sheetName);
			if(sheet!=null)
			{
				row=sheet.getRow(rowNo);
				if(row!=null)
				{
					cell=row.getCell(cellNo);
					if(cell!=null)
					{
					cellValue=cell.getStringCellValue();
				}
				else
					System.out.println("cell value is null");
			}
			else
				System.out.println("row is empty , null");
		}
		else
		System.out.println("Sheet is pointing to null");
	}
		else
			System.out.println("workbook is pointing to null");
		return cellValue;
	
	}
	public static int getLastRowNo(String SheetName)
	{
		if(wb!=null)
		{
			sheet=wb.getSheet(SheetName);
			if(sheet!=null)
			{
				lastRowNo=sheet.getLastRowNum();
			}
			else
				System.out.println("sheet is pointing to null");
		}
		else
			System.out.println("workbook is pointing to null");
		return lastRowNo;
	}
	public static int getLastCellNo(String sheetName,int rowNo)
	{
		if(wb!=null)
		{
			sheet=wb.getSheet(sheetName);
			if(sheet!=null)
			{
				row=sheet.getRow(rowNo);
				if(row!=null)
					lastCellNo=row.getLastCellNum();
				else
					System.out.println("Row si pointing to null");
			}
			else
				System.out.println("sheet is pointing to null");
		}
		else
			System.out.println("workbook is pointing to null");
		return lastCellNo;
	}
	public static void getAllData(String Workbook,String Sheetname)
	{
		if(wb!=null)
		{
			sheet=wb.getSheet(SheetName);
			if(sheet!=null)
			{
				for(int i=0;i<=sheet.getLastRowNum();i++)
				{
					row=sheet.getRow(i);
					for(int j=0;j<=row.getLastCellNum();j++)
					{
						double cellDoubleData=0;
						String cellStringData=null;
						boolean b=true;
						cell=row.getCell(j);
						if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
						{
							cellDoubleData=cell.getNumericCellValue();
							break;
						}
						else if ((cell.getCellType()==cell.CELL_TYPE_STRING))
							 {
							cellStringData=cell.getStringCellValue();
							break;
						}
						else
							if(cell.getCellType()==cell.CELL_TYPE_BOOLEAN)
								b=cell.getBooleanCellValue();
					}
				}
			}
			else
				System.out.println("sheet is pointing to null");
		}
		else
			System.out.println("workbook is pointing to null");
	}
	
	public static void writeData(String sheetName,int rowNo,int cellNo,String testData)
	{
		//String cellValue=null;
		if(wb!=null)
		{
			sheet=wb.getSheet(sheetName);
			if(sheet!=null)
			{
			row=sheet.getRow(rowNo);
				if(row!=null)
				{
					cell=row.getCell(cellNo);
					if(cell==null)
					{
						cell.setCellValue(testData);
					}	
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
