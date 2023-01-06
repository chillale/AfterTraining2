package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelfileUtils {
	public static String readDataFromExcel(String sheetName, int rowNumber, int cellNumber) throws Throwable {
		FileInputStream fileInputStream = new FileInputStream("./interviewExcel.xlsx");
		Workbook workBook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workBook.getSheet(sheetName);
		Row rowNum = sheet.getRow(rowNumber);
		Cell cellNum = rowNum.getCell(cellNumber);
		return cellNum.getStringCellValue();
	}

}
