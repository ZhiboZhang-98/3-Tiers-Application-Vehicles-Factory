package bus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validator {
	public static boolean isNumber(String checkNumber ) {
		  try {
			   int i = Integer.parseInt(checkNumber);
		 	  return  true; 
		  } catch (Exception ex) {
			  return false;
		  }
		}
		
		
		public static boolean isLong(String checkNumber ) {
			  try {
				   long i = Long.parseLong(checkNumber);
			 	   return  true; 
			  } catch (Exception ex) {
				  return false;
			  }
			}
		
		public static boolean isDouble(String checkNumber ) {
			  try {
				   double i = Double.parseDouble(checkNumber);
			 	   return  true; 
			  } catch (Exception ex) {
				  return false;
			  }
			}
		
		
		public static boolean isDate (String dateToValidate, String dateFromat) {
			if(dateToValidate == null){
				return false;
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
			sdf.setLenient(false);
			
			try {
				
				Date date = sdf.parse(dateToValidate);
				System.out.println(date);
			
			} catch (ParseException e) {
				
				e.printStackTrace();
				return false;
			}
			return true;
		}
}
