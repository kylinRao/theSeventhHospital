package rao.serverlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commonsql.bean.CatGameUser;
import commonsql.dao.CatGameUserDao;

public class addUserMsg extends HttpServlet {

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
		PrintWriter out = resp.getWriter();
		CatGameUserDao catUser = new CatGameUserDao();
		System.out.println("doPost");
		String telephone = req.getParameter("telephone");
		String IMEI = req.getParameter("IMEI");
		if (null == IMEI ){
		       StringBuffer sb = new StringBuffer();  
		        Random random = new Random();  
		        
		        for (int i = 0; i < 20; i++) {  
		            sb.append(staticVal.staticVal.ALLCHAR.charAt(random.nextInt(staticVal.staticVal.ALLCHAR.length())));  
		        }  
		         
			Date date=new Date(System.currentTimeMillis());
			System.out.println(date);
			
			CatGameUser user = new CatGameUser();

			user.setTelephone(telephone);
			IMEI = "IMEI"+sb.toString();
			user.setIMEI(IMEI);
			
			user.setCreateTime(date);
			
			catUser.insert(user);			

		}
		
		
		System.out.println("IMEI IS:"+ IMEI);
		System.out.println("telephone is"+telephone);		
		
		
		//判断是否是老用户
		 ArrayList<CatGameUser> catGameUserList = catUser.getListByIMEI(IMEI);
		 if (null == catGameUserList || catGameUserList.size() ==0){
			 
//				提交玩家信息
				Date date=new Date(System.currentTimeMillis());
				System.out.println(date);
				
				CatGameUser user = new CatGameUser();

				user.setTelephone(telephone);
				user.setIMEI(IMEI);
				
				user.setCreateTime(date);
				
				catUser.insert(user);			
				
			 
		 }
//		 返回数据给客户端
			catGameUserList = catUser.getListByIMEI(IMEI);
			
			try {
				Cookie c1 = new Cookie("uid",Integer.toString(catGameUserList.get(0).getCatUserId())) ;
				resp.addCookie(c1);
				out.println(catGameUserList.get(0).getCatUserId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				out.println("system error");
				return ;
			}			
		
		
		
	}

}
