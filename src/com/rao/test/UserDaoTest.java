package com.rao.test;

import java.sql.Connection;

import com.rao.dao.UserDao;
import com.rao.dao.impl.UserDaoImpl;
import com.rao.entity.User;
import com.rao.util.ConnectionFactory;

public class UserDaoTest {
	public static void main(String[] args) {
		Connection conn = null;
		try{
			conn = ConnectionFactory.getInstance().makeConnetion();
			conn.setAutoCommit(false);
			
			UserDao userDao = new UserDaoImpl();
			User tom = new User();
			tom.setUserName("Tom");
			tom.setPassWord("123456");
			tom.setEmail("tom@gmail.com");
			
			userDao.save(conn, tom);
			
			conn.commit();
			
			System.out.println("end");
			
			
			
			
			
		}catch (Exception e){
			try{
				conn.rollback();
			}catch (Exception e2){
				e2.printStackTrace();
			}
			
		}
	}

}
