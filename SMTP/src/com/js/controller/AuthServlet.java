package com.js.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.js.dao.RegisterDao;
import com.js.dto.RegisterDto;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/authProcess.do")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session   = request.getSession();
		RegisterDto onProcess = (RegisterDto)session.getAttribute("onProcess");
		String      authCode  = (String)session.getAttribute("authCode");
		RegisterDao target    = RegisterDao.getInstance();
		
		String      confirm   = request.getParameter("confirmCode");
		String       msg      = "";
		String      url       = "";
		int         regStatus = 0;
		
		if(confirm.equals(authCode)) {
			regStatus = target.register(onProcess);
			
			if(regStatus > 0) {
				msg = "회원가입에 성공하였습니다!";
			}else {
				msg = "회원가입에 실패하였습니다";
			}
			
			url = "./index.jsp";
			session.invalidate();//세션에 저장했던 모든 정보 무효화
		}else {
			msg = "인증코드를 확인해주세요";
			url = "./Auth.jsp";
		}
		
		request.setAttribute("msg", msg);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
