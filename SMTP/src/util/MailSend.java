package util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSend {
	private String sendTo="";
	//구글은 465번 포트
	private int sendPort = 465;//네이버는 587
	private String host  = "smtp.gmail.com";
	private String authCode ="";

	public MailSend() {
		
	}
	public void setSendTo(String sendTo) {
		this.sendTo=sendTo;
	}
	
	public String getSendTo() {
		return sendTo;
	}
	
//	public void setSendPort(String whoIs) {
//		int res = 0 ;
//		
//		if(whoIs.equals("naver")) {
//			sendPort=587;
//		}else if(whoIs.equals("google")) {
//			sendPort=587;//com.sun.mail.smtp.SMTPSendFailedException: 530 5.7.0 Must issue a STARTTLS command first. p14sm3771394pgb.2 - gsmtp
//			//587시도
//		}
//	}
	
	public int getSendPort() {
		return sendPort;
	}
	
	public void setAuthCode(int digit) {
		StringBuilder authCode = new StringBuilder();
		
		for(int i = 0 ; i < digit; i++) {
			int code = (int)Math.floor(Math.random()*9+1);
			authCode.append(String.valueOf(code));
		}
		
		this.authCode = authCode.toString();
		
	}
	
	public String getAuthCode() {
		setAuthCode(6);
		return authCode;
	}
	public void MailSend() {
		
		final String from = "aa@gmail.com";
		final String pwd  = "password";
		Properties prop = System.getProperties();
		
		prop.put("mail.smtp.host",host);
		prop.put("mail.smtp.protocol","smtp");
		prop.put("mail.smtp.port", sendPort);
		prop.put("mail.smtp.auth","true");
		prop.put("mail.smtp.startttls.enable","true");
		prop.put("mail.smtp.ssl.trust","true");
		prop.put("mail.smtp.socketFactory.port", sendPort);  
	    prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
	    prop.put("mail.smtp.socketFactory.fallback", "false");  
		
		Authenticator auth = new MailAuth();
		
		Session session = Session.getDefaultInstance(prop,auth);
		//인터넷 메일을 위한 클래스로 msg객체 생성
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(from));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));
			//메일 제목
			msg.setSubject("회원가입 인증을 위한 이메일입니다.");
			//메일 내용
			msg.setText("인증번호는 "+authCode+" 입니다");
			
			//메시지 보내기
			Transport.send(msg);
			System.out.println("Mail send success!!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
