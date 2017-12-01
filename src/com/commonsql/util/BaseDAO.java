package commonsql.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import commonsql.bean.Animals;
import commonsql.dao.AnimalsDAO;

/** 
* @author 作者 E-mail: 
* @version 创建时间：2017年7月23日 下午1:53:13 
* 类说明 
*/
public class BaseDAO {
	public ArrayList getListBySome(Class cl,String name,Object value){
		ArrayList ar = new ArrayList<>();
		
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Field[] fi = cl.getDeclaredFields();
		String sql = "select * from " + cl.getSimpleName()+" where "+name+" = '"+value+"'";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Object ob = cl.newInstance();
				for (Field ff : fi){
					ff.setAccessible(true);
					ff.set(ob,rs.getObject(ff.getName()));
				}
				ar.add(ob);
			}
			
		} catch (SQLException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return ar;
		
	}
	
	
	
	
	public Object getObById(Class cl,int id){
		Object ob = null;
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Field[] fi = cl.getDeclaredFields();
		String sql = "select * from " + cl.getSimpleName()+" where "+fi[0].getName()+" = "+id;
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				
				ob = cl.newInstance();
				for (Field ff : fi){
					ff.setAccessible(true);
					ff.set(ob, rs.getObject(ff.getName()));
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ob;
	}
	
	
	public ArrayList getList(Class cl){
		ArrayList ar = new ArrayList<>();
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from " + cl.getSimpleName();
		Field[] fi = cl.getDeclaredFields();
		System.out.println(sql);
		
		try {
			ps =  conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Object ob;
				
					ob = cl.newInstance();
				
				for (Field ff  : fi) {
					ff.setAccessible(true);
					ff.set(ob, rs.getObject(ff.getName()));
				}
				ar.add(ob);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			BaseConnection.closeRes(conn, ps, rs);
		}
		
		
		System.out.println(ar);
		return ar;
		
		
	}
	
	
	
	
	
	public boolean insert01(Object ob){
		boolean b = false;
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		Class cl = ob.getClass();
		Field[] fi = cl.getDeclaredFields();
		String sql = "insert into " + cl.getSimpleName()+" (";
		for (int i=1;i<fi.length;i++){
			sql = sql+fi[i].getName();
			if (i!=fi.length-1){
				sql = sql+" , ";
			}
		}
		sql = sql+" ) values ( ";
		for (int i = 1;i<fi.length;i++){
			sql = sql+ " ? ";
			if(i != fi.length -1){
				sql = sql + " , ";
			}
		}
		sql = sql + " ) ";
		
		System.out.println(sql);
		
		
		
		try {
			ps = conn.prepareStatement(sql);
			for (int i=1;i < fi.length;i++){
				fi[i].setAccessible(true);
				
				
				ps.setObject(i, fi[i].get(ob));
			}
			int a = ps.executeUpdate();
			if (a > 0 ){
				b = true;
			}
		} catch (SQLException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
		
		
	}
	public boolean insert(Object ob){
		boolean b = false;
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		Class cl = ob.getClass();
		Field[] fi = cl.getDeclaredFields();
		StringBuffer sb = new StringBuffer();
		sb.append("insert into ");
		sb.append(cl.getSimpleName());
		sb.append(" ( ");
		
		for (int i=1;i<fi.length;i++){
			sb.append(fi[i].getName());
			
			if (i!=fi.length-1){
				sb.append(" , ");
			}
		}
		sb.append("  ) values ( ");
		
		for (int i = 1;i<fi.length;i++){
			sb.append(" ? ");
			
			if(i != fi.length -1){
				sb.append(" , ");
				
			}
		}
		sb.append(" )  ");
		
		
		System.out.println(sb.toString());
		
		
		
		try {
			ps = conn.prepareStatement(sb.toString());
			for (int i=1;i < fi.length;i++){
				fi[i].setAccessible(true);
				
				
				ps.setObject(i, fi[i].get(ob));
			}
			int a = ps.executeUpdate();
			if (a > 0 ){
				b = true;
			}
		} catch (SQLException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
		
		
	}
	public boolean update(Object ob){
		boolean b = false;
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		Class cl = ob.getClass();
		Field[] fi = cl.getDeclaredFields();
		StringBuffer sb = new StringBuffer();
		sb.append("update ");
		sb.append(cl.getSimpleName());
		sb.append(" set ");
		for (int i = 1;i<fi.length;i++){
			sb.append(fi[i].getName());
			sb.append(" =? ");
			if(i!=fi.length-1){
				sb.append(" , ");
			}
		}
		sb.append(" where ");
		sb.append(fi[0].getName());
		sb.append(" =? ");
		
		try {
			ps = conn.prepareStatement(sb.toString());
			for (int i = 1;i<fi.length;i++){
				fi[i].setAccessible(true);
				ps.setObject(i, fi[i].get(ob));
			}
			fi[0].setAccessible(true);
			ps.setObject(fi.length, fi[0].get(ob));
			int a = ps.executeUpdate();
			if (a > 0){
				b = true;
			}
		} catch (SQLException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseConnection.closeRes(conn, ps, null);
		}
		return b;
		
	}
	
	public boolean deleteBySome(Class cl,String name,Object value){
		boolean b = false;
		Connection conn = BaseConnection.getConnection();
		PreparedStatement ps = null;
		Field[] fi = cl.getDeclaredFields();
		String sql = " delete from " + cl.getSimpleName() + " where " + name + " =? " ;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, value);
			int a = ps.executeUpdate();
			if (a > 0){
				b = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseConnection.closeRes(conn, ps, null);
		}
		return b;
		
		
	}
	
	public static void main(String[] args) {
		
//		BaseDAO bd = new BaseDAO();
//		ArrayList<Animals> ar = bd.getList(Animals.class);
//		for (Animals aa : ar) {
//			System.out.println(aa.getName());
//		}
//		
//		Animals an = (Animals) bd.getObById(Animals.class, 2) ;
//		
//			System.out.println(an.getName());
//		ar = bd.getListBySome(Animals.class, "name", "小泉");
//		for (Animals aa : ar){
//			System.out.println(aa.getName()+aa.getId()+aa.getAge()+aa.getAnId());
//		}
//		
//		bd.insert(an);
		
		Animals an = new Animals();
//		an.setName("金丝胖8982536");
//		an.setAnId(1);
//		an.setAge(100);
//		an.setId(1);
		BaseDAO bd = new BaseDAO();
		bd.deleteBySome(Animals.class,"name","金丝胖");
		

		
		
		
		
		
		
	} 

}
