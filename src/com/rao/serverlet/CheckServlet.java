package com.rao.serverlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rao.entity.User;
import com.rao.service.CheckUserService;



public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CheckUserService cku = new CheckUserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		RequestDispatcher rd = null;
		String forward = null;
		
		if (userName == null || passWord == null){
			request.setAttribute("msg", "用户名或密码为空");
			rd = request.getRequestDispatcher("/15/error.jsp");
			rd.forward(request, response);
			
		}else{
			User user = new User();
			user.setUserName(userName);
			user.setPassWord(passWord);
			boolean bool = cku.check(user);
			if (bool){
				forward = "/15/success,jsp";
			}else{
				request.setAttribute("msg", "用户或密码错误");
				forward = "/15/error.jsp";
			}
			rd = request.getRequestDispatcher(forward);
			rd.forward(request, response);
			
		}
		
		
	}

}
