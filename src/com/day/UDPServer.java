package com.day;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;


/*
 * 1.���ͷ� (��Ҫ�󶨶Է���������ַ�Ͷ˿ں�)
 * DatagramPacket  
 * */
//�������� 
public class UDPServer {
	public static void main(String[] args) throws IOException {
		//׼�����͵�����
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		byte[] bytes = s.getBytes();
		int len = bytes.length;
		//�����ݴ������Ϊ���ͷ�����Ҫ��ȷ���շ���������ַ�Ͷ˿ںţ�
		DatagramPacket packet =new DatagramPacket(bytes,len,InetAddress.getByName("whicu12"),9988);
		//�������乤�� DatagramSocket
		DatagramSocket socket = new DatagramSocket(8899);//����˿��Ǳ�����Ķ˿�
		//��������
		socket.send(packet);
		CloseUtil.close();
	}
}
