package com.selenium.practice;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadData {
	public static final String excel = "M:\\Learn-Automation\\Biodata.xlsx";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XSSFWorkbook book = new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet();
		Object[][] datas = { { "Name", "Age", "Sex", "city" }, {" ", " ", " "," "},{ "Mahes", "26", "Male", "chennai" },
				{ "vignesh", "24", "male", "kkdi" } };
		int rownum = 0;
		for (Object[] data : datas) {
			Row row = sheet.createRow(rownum++);
			int colnum = 0;
			for (Object filed : data) {
				Cell cell = row.createCell(colnum++);
				if (filed instanceof String) {
					cell.setCellValue((String) filed);
				} else if (filed instanceof Integer) {
					cell.setCellValue((Integer) filed);
				}

			}
			
		}
		System.out.println("File Writen Sucessully");
		try {
			FileOutputStream fos = new FileOutputStream(excel);
			book.write(fos);
			book.close();
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}

	}

}
