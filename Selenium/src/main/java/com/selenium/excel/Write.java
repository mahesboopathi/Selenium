package com.selenium.excel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write {
	public static final String Loc = "M:\\Learn-Automation\\Demo.xlsx";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet("Biodata");
		Object[][] datas = { { "Name", "Age", "Gender" }, { "mahes", "26", "M" }, { "ganesh", "29", "M" } };
		int rownum =22;
		for (Object[] data : datas) {
			Row row = sheet.createRow(rownum++);
			int cellnum = 0;
			for (Object field : data) {
				Cell cel = row.createCell(cellnum++);
				if (field instanceof String) {
					cel.setCellValue((String) field);

				} else if (field instanceof Integer) {
					cel.setCellValue((Integer) field);
				}
			}
		}
		try {
			FileOutputStream fos = new FileOutputStream(Loc);
			book.write(fos);
			book.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
