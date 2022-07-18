package com.needle.FsoFso.admin.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.Random;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FTPUtil {
	
	@Value("${ftp.url}")
	private String url;
	
	@Value("${ftp.id}")
	private String id;

	@Value("${ftp.password}")
	private String password;

	public boolean uploadImage(MultipartFile fileload,String fileName) {
		FTPClient ftpClient = new FTPClient();

		boolean result;
		try {
			ftpClient.connect(url);

			int reply = ftpClient.getReplyCode();

			if (!FTPReply.isPositiveCompletion(reply)) {
				ftpClient.disconnect();
				System.out.println("연결 실패");
			} else {
				System.out.println("연결 성공");
			}

			ftpClient.login(id, password);

			ftpClient.changeWorkingDirectory("/web");
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

			InputStream in = new BufferedInputStream(fileload.getInputStream());
			result = ftpClient.storeFile("needle/" + fileName, in);
			
			if(result) {
				System.out.println("File 생성 성공");
				return true;
			}else {
				System.out.println("File 생성 실패");
			}
			ftpClient.logout();
			ftpClient.disconnect();

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;

	}
	
	public String getFilePath() {
		return url + "/needle/" ;
	}
	
	public String getFileName() {
		Random rand = new Random(System.currentTimeMillis());
		return rand.nextInt()+".jpg";
	}

}