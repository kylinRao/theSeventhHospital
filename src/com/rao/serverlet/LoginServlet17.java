package com.rao.serverlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet17
 */

public class LoginServlet17 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet17() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String returnUri = request.getParameter("return_uri");
		
		System.out.println("用户名 == "+userName);
		System.out.println("密码 == "+passWord);
		System.out.println("return uri == "+returnUri);
		
		RequestDispatcher rd = null;
		if (userName == null || passWord == null){
			request.setAttribute("msg", "用户名或者密码为空");
			rd = request.getRequestDispatcher("/17/login.jsp");
			rd.forward(request, response);
			
		}else{
			if (userName=="饶" && passWord == "123456" ){
				request.getSession().setAttribute("flag", "login_success");
				if (returnUri != null){
					rd = request.getRequestDispatcher(returnUri);
					rd.forward(request, response);
				}else{
					rd = request.getRequestDispatcher("/17/index.jsp");
					rd.forward(request, response);
				}
			}else{
				request.getSession().setAttribute("flag", "login_error");
				request.setAttribute("msg", "用户名或者密码错误！！");
				rd = request.getRequestDispatcher("/17/login.jsp");
				rd.forward(request, response);
			}
			
		}
		
	}

}
