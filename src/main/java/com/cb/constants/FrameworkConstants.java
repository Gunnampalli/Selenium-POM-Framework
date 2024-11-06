package com.cb.constants;

import com.cb.enums.ConfigProperties;
import com.cb.utils.ReadPropertyFile;

public final class FrameworkConstants {
	private FrameworkConstants() {

	}

	private static final int EXPLICITWAIT = 20;
	private static final int IMPLICITWAIT = 20;
	private static final int PAGELOADTIMEOUT = 20;

	private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources/";
	private static final String CONFIGFILEPATH = RESOURCEPATH + "config/config.properties";
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-test-output/";
	private static final String EXCELPATH = RESOURCEPATH + "excel/Testdetails.xlsx";
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	private static final String ITERATIONDATASHEET = "DATA";

	private static String extentReportFilePath = "";

	public static String getExtentreportfolderpath()  {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath()  {
		if (ReadPropertyFile.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH + System.currentTimeMillis() + "/index.html";
		} else {
			return EXTENTREPORTFOLDERPATH + "index.html";
		}

	}

	public static String getRunmanagersheet() {
		return RUNMANAGERSHEET;
	}

	public static String getIterationdatasheet() {
		return ITERATIONDATASHEET;
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}

	public static int getImplicitwait() {
		return IMPLICITWAIT;
	}

	public static int getPageloadtimeout() {
		return PAGELOADTIMEOUT;
	}

	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

}
