package com.day;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//���շ�
public class UDPClient {
	public static void main(String[] args) throws IOException {
		//ʹ��DatagramPacket���ݰ���������   byte[] 
		byte[] b = new byte[512];
		DatagramPacket packet = new DatagramPacket(b,b.length);
		//��Ҫ�������ݵĹ���DatagramSocket
		DatagramSocket socket = new DatagramSocket(9988);//�Լ��Ķ˿� 
		//��������
		socket.receive(packet);//���ݽ��յ�packet�����ݴ���packet���� 
		//ȡ����
		byte[] data = packet.getData();
		int len = data.length;
		String s = new String(data,0,len);
		System.out.println(s);
	}
}
