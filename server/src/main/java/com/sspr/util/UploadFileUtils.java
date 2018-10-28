package com.sspr.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

//파일 관리 유틸
public class UploadFileUtils {
	private static final Logger logger =
			LoggerFactory.getLogger(UploadFileUtils.class);
	
	public static String uploadFile(String uploadPath,
			String originalName,
			byte[] fileData)throws Exception{
		
		UUID uid = UUID.randomUUID();
		
		String savedName = uid.toString() + "_" + originalName;

		String savedPath = "";
		
		File target = new File(uploadPath + savedPath, savedName);
		
		FileCopyUtils.copy(fileData, target);
		
		String formatName = originalName.substring(originalName.lastIndexOf(".") + 1);
		
		String uploadedFileName = null;
		
		uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
		return uploadedFileName;
	}
	
	//경로 계산
	private static String calPath(String uploadPath){
		Calendar cal = Calendar.getInstance();
		
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		
		String monthPath = yearPath + File.separator +
				new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		
		String datePath = monthPath + File.separator +
				new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
//		makeDir(uploadPath, yearPath,monthPath,datePath);
		
		logger.info(datePath);
		
		return datePath;
	}
	
	//디렉토리 생성
	private static void makeDir(String uploadPath, String... paths){
		if(new File(paths[paths.length-1]).exists()){
			return;
		}
		
		for(String path : paths){
			File dirPath = new File(uploadPath + path);
			
			if(! dirPath.exists()){
				dirPath.mkdirs();
			}
		}
	}
	
	//썸네일 생성
	private static String makeThumbnail(
			String uploadPath,
			String path,
			String fileName
			)throws Exception{
		
		BufferedImage sourceImg =
				ImageIO.read(new File(uploadPath + path, fileName));
		
		BufferedImage destImg = sourceImg;
		
		String thumbnailName =
				uploadPath + path + File.separator + "s_" + fileName;
		
		
		File newFile = new File(thumbnailName);
		String formatName =
				fileName.substring(fileName.lastIndexOf(".")+1);
		
		ImageIO.write(destImg,formatName.toUpperCase(), newFile);
		return thumbnailName.substring(
				uploadPath.length()).replace(File.separatorChar, '/');
	}
	
	private static String makeIcon(
			String uploadPath, String path, String fileName) throws Exception{
		String iconName =
				uploadPath + path + File.separator + fileName;
		
		return iconName.substring(
				uploadPath.length()).replace(File.separatorChar, '/');
	}
}
