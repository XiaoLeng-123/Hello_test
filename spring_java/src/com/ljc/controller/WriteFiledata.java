package com.ljc.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteFiledata {
	  public static void main(String[] args) {
	         
	        FileWriter fw = null;
	        File file = new File("config/abc.properties");
	        try {
	            if (!file.exists()) {
	                file.createNewFile();
	            }
	            fw = new FileWriter(file);
	            for(int i = 1;i <=3000;i++){
	            fw.write("abcdefgabcdefg"+i+",");              //向文件中写内容
	            fw.write("sssssssssssssss"+i+",\r\n");        //加上换行
	            fw.flush();
	            }
	            System.out.println("写数据成功！");
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally{
	            if(fw != null){
	                try {
	                    fw.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	}
