package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.text.Style;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.examples.CreateCell;



public class Excel_utils {

	   public static FileInputStream fi;
	   public static  Workbook wb;
	   public static Sheet sh;
	   public static Row ro;
	   public static Cell ce;
	   public static FileOutputStream fo;
	   public static CellStyle sy;
	   public static CellStyle cs;
	   
	   
	   
	public static int getRowCount(String file_path,String sheet) throws IOException
	{
	 fi= new FileInputStream(file_path);   
       wb= new XSSFWorkbook(fi);  
      sh=wb.getSheet(sheet);
	  int count=sh.getLastRowNum();
	  
	  wb.close();
	  fi.close();
	  
	  return count;
	
	}
	
	public static short getColCount(String file_path,String sheet,int i) throws IOException
	{
	  fi=new FileInputStream(file_path);
	  wb= new XSSFWorkbook(fi);
	  Sheet sh= wb.getSheet(sheet);
	  ro=sh.getRow(i);
	  short col_count=ro.getLastCellNum();
		
	  wb.close();
	  fi.close();
	  return col_count;
	}
	
	
	public static String getStringCellData(String file_path,String sheet,int row_no,int col_no) throws IOException
	{
	 	fi=new FileInputStream(file_path);
	 	wb=new XSSFWorkbook(fi);
	 	sh=wb.getSheet(sheet);
       	ro=sh.getRow(row_no);
       	ce=ro.getCell(col_no);
       	String data;
       	try
       	{
       		data=ce.getStringCellValue();
       		System.out.println(data);
       	}catch(Exception e)
       	{
       		data="";
       	}
		wb.close();
		fi.close();
       	return data;
		
	}
	
	public static double getNumericCellData(String file_path,String sheet,int row_no,int col_no) throws IOException
	{
		fi=new FileInputStream(file_path);
		wb= new XSSFWorkbook(fi);
		sh=wb.getSheet(sheet);
		ro=sh.getRow(row_no);
		ce=ro.getCell(col_no);
		double num_data;
		
		try
		{
			num_data=ce.getNumericCellValue();
			
		}
		catch(Exception e)
		{
			num_data=0;
		}
		return num_data;	
	}
	
	public static void Create_Cell(String file_path,String sheet,int row_no,int cell_no,String set_value) throws IOException
	{
		fi= new FileInputStream(file_path);
		wb= new XSSFWorkbook(fi);
		sh=wb.getSheet(sheet);
		ro=sh.getRow(row_no);
		ce=ro.createCell(cell_no);
		ce.setCellValue(set_value);
		fo= new FileOutputStream(file_path);
		wb.write(fo);
		
	}
	
	public static void green_colour(String file_path,String sheet,int row_no,int cell_no) throws IOException
	{
		fi= new FileInputStream(file_path);
		wb= new XSSFWorkbook(fi);
		sh=wb.getSheet(sheet);
		ro=sh.getRow(row_no);
	    ce=ro.getCell(cell_no);
	     
		
		 sy=wb.createCellStyle();
		 sy.setFillForegroundColor(IndexedColors.GREEN.index);
		 sy.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		 
		 ce.setCellStyle(sy);
		 fo= new FileOutputStream(file_path);
		 
		 wb.write(fo);
		 
		 fi.close();
		 wb.close();	
		
	}
	
	public static void redcolour(String file,String sheet,int row_no,int cell_no) throws IOException
	{
		fi= new FileInputStream(file);
		wb= new XSSFWorkbook(fi);
		sh=wb.getSheet(sheet);
		ro=sh.getRow(row_no);
		 ce= ro.getCell(cell_no);
		
	
	    cs=wb.createCellStyle();
		cs.setFillForegroundColor(IndexedColors.RED.index);
		cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		ce.setCellStyle(cs);
		
		
		fo=new FileOutputStream(file);
		wb.write(fo);
		
		wb.close();
		fi.close();
		
				
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
