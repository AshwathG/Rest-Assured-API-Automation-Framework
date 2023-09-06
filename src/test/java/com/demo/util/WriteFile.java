package com.demo.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class WriteFile {
	
	@Test
	public static void appendStringInFile(String filename, String key, String value) throws IOException
	{   
	        FileInputStream in = new FileInputStream(filename);
	        Properties props = new Properties();
	        props.load(in);
	        in.close();

	        FileOutputStream out = new FileOutputStream(filename);
	        props.setProperty(key, value);
	        props.store(out, null);
	        out.close();
	}

}
