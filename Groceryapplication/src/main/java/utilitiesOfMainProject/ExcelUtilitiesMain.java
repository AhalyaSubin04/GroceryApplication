package utilitiesOfMainProject;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtilitiesMain {

	static FileInputStream f; // used to input a file
	static XSSFWorkbook w; // used to input a workbook from a file
	static XSSFSheet s;// used to input a sheet from a workbook
	
	public static String getStringData(int row, int column,String sheet) throws IOException
	{
		f = new FileInputStream(Constant.TESTDATA);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(row);
		XSSFCell cell = r.getCell(column);
		return cell.getStringCellValue();
	}
	public static int getIntegerData(int row, int column,String sheet) throws IOException
	{
		f = new FileInputStream(Constant.TESTDATA);
		w = new XSSFWorkbook(f);
		s = w.getSheet(sheet);
		XSSFRow r = s.getRow(row);
		XSSFCell cell = r.getCell(column);
		
//		type casting - default double to int
		int x =(int) cell.getNumericCellValue();
		return x;
	}


}
