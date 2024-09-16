package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import constants.Constants;

public class Excel_Utility 
{
	
	
		public	static FileInputStream f;
		public static XSSFWorkbook w;
		public static XSSFSheet sh;
		
		public static String get_StringData(int row,int column,String sheet) 
	  {
			try
			{
				String path=Constants.HOMEDIRECTORY+Constants.TESTDATAEXCELPATH;
			f=new FileInputStream(path);
			w=new XSSFWorkbook(f);
			sh=w.getSheet(sheet);
			XSSFRow r=sh.getRow(row);
			XSSFCell c=r.getCell(column);
			return c.getStringCellValue();
			}
			catch(Exception e) 
			{
				throw new RuntimeException("excel sheet not found");
			}
			
	  }
		
		public static String get_IntegerData(int row,int column,String sheet)  
		  {
				try
				{
					String path=Constants.HOMEDIRECTORY+Constants.TESTDATAEXCELPATH;
				f=new FileInputStream(path);
				w=new XSSFWorkbook(f);
				sh=w.getSheet(sheet);
				XSSFRow r=sh.getRow(row);
				XSSFCell c=r.getCell(column);
				int X=(int) c.getNumericCellValue();
				return String.valueOf(X);
				}
				catch(Exception e) 
				{
					throw new RuntimeException("excel sheet not found");
				}
		  }
	}

