package com.selenium.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	public static final String NAME = "M:\\Learn-Automation\\Writeexcel.xlsx";

	public static void main(String[] args) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook work = new XSSFWorkbook();
		XSSFSheet sheet = work.createSheet("Bio Data");
		Object[][] datas = { { "Name", "Age", "City" }, { "mahes", "26", "chennai" } };
		int rownum = 0;
		for (Object[] data : datas) {
			Row row = sheet.createRow(rownum++);
			int colnum = 0;
			for (Object da : data) {
				Cell cel = row.createCell(colnum++);
				if (da instanceof String) {
					cel.setCellValue((String) da);
				} else if (da instanceof Integer) {
					cel.setCellValue((Integer) da);

				}

			}

		}
		try {
			FileOutputStream fout = new FileOutputStream(NAME);
			work.write(fout);
			work.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("messge of exception is" + e);
		}

	}

}
