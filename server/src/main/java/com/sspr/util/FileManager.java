package com.sspr.util;

import java.io.File;

public class FileManager {
	public static void delete(String uploadPath, String img_src){
		String des = uploadPath + File.pathSeparator + getName(img_src);
		File file = new File(des);
		if(file.exists()){
			file.delete();
		}
	}
	
	public static String getName(String img_src){
		int idx = img_src.lastIndexOf(File.pathSeparator);
		String result = img_src.substring(idx+1);
		return result;
	}
}
