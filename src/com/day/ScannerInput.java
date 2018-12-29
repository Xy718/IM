package com.day;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/* 分析：
 * 1.这个用于监听用户输入
 * 2.Scanner
 * 3.回车后判断指令
 * 接收消息    输入流  
 * */
public class ScannerInput implements Runnable{
	private boolean flag = true;
	private Scanner scan;
	private Socket socket = null;
	BufferedWriter bWriter=null;
	
	public ScannerInput(Socket socket1) throws IOException {
		socket=socket1;
		OutputStream os = socket.getOutputStream();
		bWriter = new BufferedWriter(new OutputStreamWriter(os));
		
		scan=new Scanner(System.in);
	}
	
	public String getScanner(){
		return scan.nextLine();
	}

	public void run() {
		// TODO Auto-generated method stub
		while(flag){
			String msg=getScanner();
			try {
				sendtoServer(bWriter, msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void sendtoServer(BufferedWriter bWriter, String msg) throws IOException 
	{
		bWriter.write(msg);
		bWriter.newLine();
		bWriter.flush();
	}

}
