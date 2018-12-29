package com.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


public class Myclient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost",7788);
		new Thread(new Receive(socket)).start();
		new Thread(new ScannerInput(socket)).start();
//		InputStream is = socket.getInputStream();
//		BufferedReader br =new BufferedReader(new InputStreamReader(is));
//		String s=br.readLine();
//		while(null!=s&& !"".equals(s)){
//			System.out.println(s);
//			s = br.readLine();
//		}//
//		System.out.println("客户端结束了。。。。");
//		
//		
		CloseUtil.close();
//		br.close();
//		is.close();
//		socket.close();
	}
}
