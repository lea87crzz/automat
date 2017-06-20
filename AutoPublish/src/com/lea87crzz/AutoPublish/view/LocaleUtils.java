package com.lea87crzz.AutoPublish.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleUtils {
	
	private static ResourceBundle messages=ResourceBundle.getBundle("ApplicationMessages");
	private static Locale currentLocalen=new Locale("es", "AR");
	
	
	public static String getString(String key) {
		try{
			return messages.getString(key);
		} catch(Exception e){
			return key;
		}
	}


}
