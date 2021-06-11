package com.js.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.js.dto.RegisterDto;
import static common.JDBCTemplate.*;

public class RegisterDao {
	
	Connection conn = null;
	Statement  stat = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	private RegisterDao() {
		
	}
	
	private static RegisterDao dao = new RegisterDao();
	
	public static RegisterDao getInstance() {
		return dao;
	}
	
	//회원인증 처리
	public int register(RegisterDto target) {
		int    regIns = 0 ;
		String regQuery= "INSERT INTO SENDMAILEX VALUES(?,?,?,'Y')";
		
		conn = getConnection();
		
		try {
			
			ps = conn.prepareStatement(regQuery);
			ps.setString(1, target.getUserId());
			ps.setString(2, target.getPwd());
			ps.setString(3, target.getEmail());
			
			regIns = ps.executeUpdate();
			
			if(regIns > 0) {
				System.out.println("회원가입 성공!");
				commit(conn);
			}else {
				System.out.println("회원가입 실패!");
				rollback(conn);
			}
			
		}catch(Exception e) {
			System.out.println("[ERR]회원가입 과정 처리 중 실패");
			e.printStackTrace();
		}finally {
			close(ps);
			close(conn);
		}
		
		return regIns;
	}
}
