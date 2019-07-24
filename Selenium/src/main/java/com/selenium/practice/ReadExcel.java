package com.selenium.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static final String flie = "M:\\Learn-Automation\\Biodata.xlsx";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fos = new FileInputStream(flie);
		Workbook book = new XSSFWorkbook(fos);
		Sheet sheet = book.getSheetAt(0);
		Iterator<Row> itr = sheet.iterator();
		while (itr.hasNext()) {
			Row row = itr.next();
			Iterator<Cell> citr = row.iterator();
			while (citr.hasNext()) {
				Cell cell = citr.next();
				if (cell.getCellType() == CellType.STRING) {
					System.out.println(cell.getStringCellValue() + " ");
				} else if (cell.getCellType() == CellType.NUMERIC) {
					System.out.println(cell.getNumericCellValue() + " ");

				}
				System.out.println();

			}
		}

	}

}
