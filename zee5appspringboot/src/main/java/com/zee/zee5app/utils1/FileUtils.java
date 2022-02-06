package com.zee.zee5app.utils1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class FileUtils {
	public byte[] readFile(File file) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] allBytes = new byte[(int) file.length()];
		fileInputStream.read(allBytes);
		return allBytes;
	}
	
	public String writeFile(byte[] allBytes,String fileName) {
		//Fileoutputstream
		//return success
		//return fail
		FileOutputStream fileOutputStream =null;
		try {
			fileOutputStream = new FileOutputStream(fileName);
			fileOutputStream.write(allBytes);
			return "success adding episode";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "not found";
		}
 	   
	}

}
