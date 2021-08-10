package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CommonExcelRead {
	public ArrayList<String> getData(String testName, String sheetName) throws IOException {
		ArrayList<String> arr = new ArrayList<String>();
        
		FileInputStream fis = new FileInputStream("src/resources/TestAppProject.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int sheetcount = wb.getNumberOfSheets();
		for (int i = 0; i < sheetcount; i++) {
			if (wb.getSheetName(i).equalsIgnoreCase(sheetName)) {
				XSSFSheet sheet = wb.getSheetAt(i);
				// Identify Testcases coloum by scanning the entire 1st row
				Iterator<Row> row = sheet.iterator();
				Row firstRow = row.next();
				Iterator<Cell> ce = firstRow.cellIterator();
				int k = 0;
				
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("Data")) {
						column = k;
					}
					k++;
				}
				System.out.println(k);

				//// once coloumn is identified then scan entire testcase coloum to identify
				//// purcjhase testcase row
				while (row.hasNext()) {
					Row r = row.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testName)) {
						//// after you grab purchase testcase row = pull all the data of that row and
						//// feed into test
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {

							arr.add(cv.next().getStringCellValue());

						}
					}
				}

			}

		}
		return arr;
	}

}
