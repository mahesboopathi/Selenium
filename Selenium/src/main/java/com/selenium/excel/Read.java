package com.selenium.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read {
	public static final String NAME = "M:\\\\Learn-Automation\\\\Demo.xlsx";

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(NAME);
		Workbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheetAt(0);
		book.close();
		Iterator<Row> iter = sheet.iterator();
		while (iter.hasNext()) {
			Row currRow = iter.next();
			Iterator<Cell> cell = currRow.iterator();
			while (cell.hasNext()) {
				Cell curcell = cell.next();
				if (curcell.getCellType() == CellType.STRING) {
					System.out.print(curcell.getStringCellValue() + "");

				} else if (curcell.getCellType() == CellType.NUMERIC) {
					System.out.print(curcell.getNumericCellValue() + " ");

				}
				System.out.print(" ");

			}

		}

	}

}
