package com.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Scanner;

/* 分析：
 * 1.这个接受信息的多线程
 * 2.用于TCP网络连接     输入流     socket
 * 3.控制台输入消息  
 * 接收消息    输入流  
 * */
public class Receive implements Runnable{
	private Socket socket = null;
	private InputStream is = null;
	private BufferedReader br = null;
	private boolean flag = true;
	public Receive(){
	}
	//构造方法初始化，获取IO流
	public Receive(Socket socket){
		this.socket = socket;
		try {
			is = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			flag = false;//如果出现异常，当前线程应该停止
		}
	}
	//获取消息
	public void getMessage(){
		try {
			String s=br.readLine();
			//while(null!=s&& !"".equals(s)){
			//	System.out.println(s);
			//	s = br.readLine();
			//}//
			System.out.println(DateFormat.getDateTimeInstance(2, 2, Locale.CHINESE).format(new java.util.Date())+" "+s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			flag = false;//如果出现异常，当前线程应该停止
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag){
			getMessage();
		}//不停的发送消息，直到线程异常或者流通道关闭。
	}

}
