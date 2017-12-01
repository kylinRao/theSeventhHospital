package com.thread;
/** 
* @author 作者 E-mail: 
* @version 创建时间：2017年7月23日 下午6:44:13 
* 类说明 
*/
public class MyThread extends Thread{
	
	private String name;
	
	public MyThread(String name){
		this.name = name;
	}
	public void run(){
		for (int i =0 ;i < 10;i++){
			System.out.println(name+" : "+ i );
		}
	}
	
	
	
	public static void main(String[] args) {
		MyThread t1 = new MyThread("A");
		MyThread t2 = new MyThread("B");
		
		
		t1.start();
		t2.start();
	}
}
