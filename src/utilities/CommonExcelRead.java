package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CommonExcelRead {
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	
   public CommonExcelRead(String path) {
	   try {
		   File src= new File(path);
			FileInputStream file =new FileInputStream(src);
			wb= new XSSFWorkbook(file);
			
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
public String getExcelData(int sheetNum,int row, int column)
   {
	   sheet= wb.getSheetAt(sheetNum);
	   String data= sheet.getRow(row).getCell(column).getStringCellValue();
	   
	   return data;
	   
	   
   }
   public int getrowcount(int sheetIndex) {
	   
	   int rowcount= wb.getSheetAt(sheetIndex).getLastRowNum();
	   rowcount=rowcount+1;
	   return rowcount;
   }
}
