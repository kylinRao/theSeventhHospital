package com.thread;
/** 
* @author 作者 E-mail: 
* @version 创建时间：2017年7月23日 下午6:48:39 
* 类说明 
*/
public class MyRunnable implements Runnable{
	private String name;
	public MyRunnable(String name){
		this.name = name;
	}
	
	public void run(){
		for (int i =0 ;i < 10;i++){
			System.out.println(name+" : "+ i );
		}
	}
	
	
	public static void main(String[] args) {
		MyRunnable r1 = new MyRunnable("A");
		MyRunnable r2 = new MyRunnable("B");
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		 
		t1.start();
		t2.start();
	}

}
