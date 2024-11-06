package com.cb.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.cb.constants.FrameworkConstants;

public final class DataProviderUtils {

	private DataProviderUtils() {

	}

	private static List<Map<String, String>> list = new ArrayList<>();

	@DataProvider
	public static Object[] getData(Method m) {

		String testName = m.getName();
		if (list.isEmpty()) {
			list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationdatasheet());
		}
		List<Map<String, String>> executionList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (testName.equalsIgnoreCase(list.get(i).get("TestName")) && 
					list.get(i).get("Execute").equalsIgnoreCase("yes")) {
				executionList.add(list.get(i));
			}
		}
		// System.out.println(executionList);
		return executionList.toArray();
	}
	

}
