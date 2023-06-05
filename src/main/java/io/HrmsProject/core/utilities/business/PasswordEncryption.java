package io.HrmsProject.core.utilities.business;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncryption {
	
	public static void passwordEncryption(String password) {
		String hashedPassword =  BCrypt.hashpw(password, BCrypt.gensalt());
	}

}
