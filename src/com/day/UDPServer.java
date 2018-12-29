package com.day;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;


/*
 * 1.发送方 (需要绑定对方的主机地址和端口号)
 * DatagramPacket  
 * */
//发送数据 
public class UDPServer {
	public static void main(String[] args) throws IOException {
		//准备发送的数据
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		byte[] bytes = s.getBytes();
		int len = bytes.length;
		//把数据打包（作为发送方，需要明确接收方的主机地址和端口号）
		DatagramPacket packet =new DatagramPacket(bytes,len,InetAddress.getByName("whicu12"),9988);
		//创建运输工具 DatagramSocket
		DatagramSocket socket = new DatagramSocket(8899);//这个端口是本程序的端口
		//发送数据
		socket.send(packet);
		CloseUtil.close();
	}
}
