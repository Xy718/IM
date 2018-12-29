package com.day;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//接收方
public class UDPClient {
	public static void main(String[] args) throws IOException {
		//使用DatagramPacket数据包接收数据   byte[] 
		byte[] b = new byte[512];
		DatagramPacket packet = new DatagramPacket(b,b.length);
		//需要运输数据的工具DatagramSocket
		DatagramSocket socket = new DatagramSocket(9988);//自己的端口 
		//接受数据
		socket.receive(packet);//数据接收到packet，数据存在packet包里 
		//取数据
		byte[] data = packet.getData();
		int len = data.length;
		String s = new String(data,0,len);
		System.out.println(s);
	}
}
