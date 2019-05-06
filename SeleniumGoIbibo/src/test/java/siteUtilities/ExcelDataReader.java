package siteUtilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {
	
	XSSFWorkbook workbook;
	ConfigDataReader config=new ConfigDataReader();
	
	public ExcelDataReader() {
		
		File src=new File(config.getExcelPath());
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			workbook=new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String getSheetValue(String SheetName,int row,int col)
	{
		return workbook.getSheet(SheetName).getRow(row).getCell(col).getStringCellValue();
	}
	public double getNumericValue(int SheetNum,int row,int col)
	{
		return workbook.getSheetAt(SheetNum).getRow(row).getCell(col).getNumericCellValue();
	}
	public String getSheetValue(int SheetNum,int row,int col)
	{
		return workbook.getSheetAt(SheetNum).getRow(row).getCell(col).getStringCellValue();
	}
	public double getNumericValue(String SheetName,int row,int col)
	{
		return workbook.getSheet(SheetName).getRow(row).getCell(col).getNumericCellValue();
	}
	

}
