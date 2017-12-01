package com.rao.serverlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String userName = req.getParameter("userName");
//		String passWord = req.getParameter("passWord");
//		System.out.println("用户名是："+ userName);
//		System.out.println("密码是"+passWord);
//	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet");
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost");
		String userName = req.getParameter("userName");
		String passWord = req.getParameter("passWord");
		System.out.println("用户名是："+ userName);
		System.out.println("密码是"+passWord);
		if (userName.equals("aaa")){
//			resp.sendRedirect(req.getContextPath()+"/14/success.jsp");
			String forward = "/14/success.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);
		}else{
//			resp.sendRedirect(req.getContextPath()+"/14/error.jsp");
			String forward = "/14/error.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);
		}
	}

}
