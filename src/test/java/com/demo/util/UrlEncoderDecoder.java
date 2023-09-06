package com.demo.util;

import java.util.Base64;

public class UrlEncoderDecoder {
	
	// method for Base64 encoding
	
	public static String encoder(String clientId, String secretKey)
	{
		String credential = clientId + ":" + secretKey;
		
		Base64.Encoder encoder = Base64.getEncoder();  
	    String str = encoder.encodeToString(credential.getBytes()); 
	   
	    return str;
	}
	
	// method for Base64 decoding
	
	public static String decoder(String str)
	{
		Base64.Decoder decoder = Base64.getDecoder();  
	    String dStr = new String(decoder.decode(str));  
	    
	    return dStr;
	}
     

}
