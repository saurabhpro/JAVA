package com.saurabh.genericexcelconverter.api.constants;

/**
 * This class will hold all messages sent out from this module.
 *
 * @author dinuka
 */
public final class MessageConstants {

	public static final String MEMBER_ADDED_SUCCESSFULLY = "Member successfully added.";
	private final static String FILE_PATH_2007 = "./src/main/resources/excel-repo/year 2007 for saurabh.xlsx";
	private final static String FILE_PATH_2008 = "./src/main/resources/excel-repo/What's Your Life in 2008.xlsx";

	public static String getFileName(int year) {
		if (year == 2007)
			return FILE_PATH_2007;
		else if (year == 2008)
			return FILE_PATH_2008;
		else
			return "/";
	}

	public static class ErrorMessages {
		public static final String MEMBER_ALREDY_EXISTS = "The member already exists.";
	}

}
