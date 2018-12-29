package com.day;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtil {
	public static void close(Closeable...io) throws IOException{
		for(Closeable temp:io){
			if(temp!=null){
				temp.close();
			}
		}
	}
}
