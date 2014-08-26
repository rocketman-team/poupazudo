package poupazudo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

	public static boolean vericaEmail(String email) {
		Pattern pattern = Pattern
				.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher matcher = pattern.matcher(email);
		
		return matcher.find();
	}
	
}
