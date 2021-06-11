package com.js.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.js.dto.RegisterDto;

import util.MailSend;


/**
 * Servlet implementation class EmailServlet
 */
@WebServlet("/auth.do")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	//발신자 메일계정과 비밀번호를 설정
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String userId  = request.getParameter("userId");
		String pwd     = request.getParameter("pwd");
		
		//get email info
		String receiver = request.getParameter("email");
		MailSend mailSend = new MailSend();
		final String authCode = mailSend.getAuthCode();
		RegisterDto dto = new RegisterDto();
		HttpSession session = request.getSession();
		
		mailSend.setSendTo(receiver);
		System.out.println(authCode);
		mailSend.MailSend();//메일보내기
		
		dto.setUserId(userId);
		dto.setPwd(pwd);
		dto.setEmail(receiver);
		
		session.setAttribute("onProcess", dto);
		session.setAttribute("authCode", authCode);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./Auth.jsp");
		dispatcher.forward(request, response);
	}

}
