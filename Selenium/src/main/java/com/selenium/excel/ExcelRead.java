package com.selenium.excel;

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

public class ExcelRead {
	public static final String NAME = "M:\\\\Learn-Automation\\\\Writeexcel.xlsx";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream input = new FileInputStream(NAME);
		Workbook book = new XSSFWorkbook(input);
		Sheet shet = book.getSheetAt(0);
		Iterator<Row> itr = shet.iterator();
		while (itr.hasNext()) {
			Row currRow = itr.next();

			Iterator<Cell> cellIterator = currRow.iterator();

			while (cellIterator.hasNext()) {
				Cell currentCell = cellIterator.next();
				// getCellTypeEnum shown as deprecated for version 3.15
				// getCellTypeEnum ill be renamed to getCellType starting from version 4.0
				if (currentCell.getCellTypeEnum() == CellType.STRING) {
					System.out.print(currentCell.getStringCellValue() + "--");
				} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
					System.out.print(currentCell.getNumericCellValue() + "--");
				}
				System.out.println();
			}

		}
		

	}

}
