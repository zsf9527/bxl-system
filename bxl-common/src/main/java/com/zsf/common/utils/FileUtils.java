package com.zsf.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

/**
 * 文件相关操作
 * @author zsf
 * @date Jan 14, 2019
 */
public class FileUtils {

	/**
	 * 下载文件
	 * @param response
	 * @param file
	 * @param newFileName
	 */
	public static void downloadFile(HttpServletResponse response, File file, String newFileName) {
		try {
			response.setHeader("Content-Disposition", "attachment; filename=" + new String(newFileName.getBytes("ISO-8859-1"), "UTF-8"));
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			InputStream is = new FileInputStream(file.getAbsolutePath());
			BufferedInputStream bis = new BufferedInputStream(is);
			int length = 0;
			byte[] temp = new byte[1 * 1024 * 10];
			while ((length = bis.read(temp)) != -1) {
				bos.write(temp, 0, length);
			}
			bos.flush();
			bis.close();
			bos.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 递归删除文件
	 * @param file
	 */
    public static void deleteFile(File file) {
		if(file.isDirectory()){
			File[] subfiles = file.listFiles();
			for (File subfile : subfiles) {
				deleteFile(subfile);
			}
		}
		file.delete();
    }
}
