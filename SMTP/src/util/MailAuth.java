package util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuth extends Authenticator{
	
	private static final String id="aa@gmail.com";
	private static final String pwd = "password";
	private PasswordAuthentication pa=null;	
	
	
	public MailAuth() {

		pa =new PasswordAuthentication(id,pwd);
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
}
