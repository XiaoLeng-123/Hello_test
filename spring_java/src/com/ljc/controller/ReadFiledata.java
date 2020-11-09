package com.ljc.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFiledata {

	public static void main(String[] args) {
		File file = new File("config/abc.properties");
		System.out.println(txt2String(file));
	}

	public static String txt2String(File file) {
		StringBuilder result = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file)); // 构造一个BufferedReader类来读取文件
			String s = null;
			while ((s = br.readLine()) != null){
				// 使用readLine方法，一次读一行
				result.append(System.lineSeparator() + s);
			}
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

}