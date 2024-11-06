package com.cb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cb.constants.FrameworkConstants;
import com.cb.exceptions.InvalidFilePathforFileException;

public final class ExcelUtils {

	private ExcelUtils() {

	}

	public static List<Map<String, String>> getTestDetails(String sheetName) {

		Map<String, String> map = null;
		List<Map<String, String>> list = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelpath())) {

			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int lastRow = sheet.getLastRowNum();
			int lastColNum = sheet.getRow(0).getLastCellNum();
			for (int i = 1; i <= lastRow; i++) {
				map = new HashMap<>();
				for (int j = 0; j < lastColNum; j++) {
					DataFormatter df = new DataFormatter();
					String key = df.formatCellValue(sheet.getRow(0).getCell(j));
					String value = df.formatCellValue(sheet.getRow(i).getCell(j));
					map.put(key, value);
				}
				list.add(map);
			}

		} catch (FileNotFoundException e) {
			throw new InvalidFilePathforFileException("Invalid Excel file Path");
		}catch (IOException e) {
			throw new InvalidFilePathforFileException("Invalid Excel file Path");
		}
		return list;

	}

}
