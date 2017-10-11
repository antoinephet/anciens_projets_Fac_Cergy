package utils;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtility {
	public static byte[] createPortrait(String fileName) {
		File file = new File(fileName);
		byte[] byteFile = new byte[(int) file.length()];

		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(byteFile);
			fileInputStream.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return byteFile;
	}

	public static Date createBirthdate(int day, int month, int year) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			StringBuffer dateString = new StringBuffer();
			dateString.append(String.valueOf(day));
			dateString.append("/");
			dateString.append(String.valueOf(month));
			dateString.append("/");
			dateString.append(String.valueOf(year));
			return format.parse(dateString.toString());
		} catch (ParseException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

}
