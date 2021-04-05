package base;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POM_ExcelRead {

	public String[][] ReadingExcelData(String FileSheetName) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook("./Data/Lead_Data.xlsx");
		XSSFSheet sheet = workbook.getSheet(FileSheetName);
		int MaxRowCount = sheet.getLastRowNum();
		int MaxColunCount = sheet.getRow(0).getLastCellNum();
		String Data[][] = new String[MaxRowCount][MaxColunCount];
		for (int i = 1; i <= MaxRowCount; i++) {
			for (int j = 0; j < MaxColunCount; j++) {
				String CellValue = sheet.getRow(i).getCell(j).getStringCellValue();
				Data[i - 1][j] = CellValue;
			}

		}
		workbook.close();
		return Data;

	}

}
