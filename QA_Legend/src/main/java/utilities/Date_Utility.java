package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_Utility 
{
	public static String get_UserLogin_Date(String format)
	{
		DateFormat dateformat=new SimpleDateFormat(format);
		Date currentdate=new Date();
		return dateformat.format(currentdate);
	}

	public static String get_UserLogin_Date1(String format) {
		// TODO Auto-generated method stub
		return null;
	}
}
