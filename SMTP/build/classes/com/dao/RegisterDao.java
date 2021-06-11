package com.js.dao;

public class RegisterDao {
	
	private RegisterDao() {
		
	}
	
	private static RegisterDao dao = new RegisterDao();
	
	public RegisterDao getInstance() {
		return dao;
	}
	
	
}
