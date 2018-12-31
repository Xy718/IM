package com.day;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Scanner;

/* ������
 * 1.���������Ϣ�Ķ��߳�
 * 2.����TCP��������     ������     socket
 * 3.����̨������Ϣ  
 * ������Ϣ    ������  
 * */
public class Receive implements Runnable{
	private Socket socket = null;
	private InputStream is = null;
	private BufferedReader br = null;
	private boolean flag = true;
	public Receive(){
	}
	//���췽����ʼ������ȡIO��
	public Receive(Socket socket){
		this.socket = socket;
		try {
			is = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			flag = false;//��������쳣����ǰ�߳�Ӧ��ֹͣ
		}
	}
	//��ȡ��Ϣ
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
			flag = false;//��������쳣����ǰ�߳�Ӧ��ֹͣ
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(flag){
			getMessage();
		}//��ͣ�ķ�����Ϣ��ֱ���߳��쳣������ͨ���رա�
	}

}
