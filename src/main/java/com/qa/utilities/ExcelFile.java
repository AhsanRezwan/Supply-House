package com.qa.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelFile {

	Workbook workbook;
	Sheet sheet;

	public ExcelFile(String filename, String sheetname) {
		try {
			if (filename.endsWith(".xls")) {
				workbook = new HSSFWorkbook(new FileInputStream(filename));
				sheet = (HSSFSheet) workbook.getSheet(sheetname);
			} else if (filename.endsWith(".xlsx")) {
				workbook = new XSSFWorkbook(new FileInputStream(filename));
				sheet = (XSSFSheet) workbook.getSheet(sheetname);
			} else {
				System.out.println("File Not Supported");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File Not Found");
		}
	}

	public Object[][] getData() {
		Object[][] info = {};
		int rows = sheet.getLastRowNum()+1;
		System.out.println(rows);
		int cells = sheet.getRow(0).getLastCellNum();
		info = new Object[rows][cells];
		DataFormatter dataFormatter = new DataFormatter();

		for (int i = 0; i < rows; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < cells; j++) {
				try {
				Cell cell = row.getCell(j);
				Object value = dataFormatter.formatCellValue(cell);
				info[i][j] = value;
				}catch (NullPointerException e) {
					
				}
			}
		}
		return info;
	}

}
