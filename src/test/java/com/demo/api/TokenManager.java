package com.demo.api;

import java.time.Instant;
import java.util.HashMap;

import com.demo.util.PropertiesLoader;
import com.demo.util.UrlEncoderDecoder;

import io.restassured.response.Response;

public class TokenManager {
	
	private static String access_token;
	private static Instant expiry_time; 
	
	// method to get the already available access token, else creates new
	
	public synchronized static String getToken()
	{
		 try{
	            if(access_token == null || Instant.now().isAfter(expiry_time)){
	                System.out.println("Renewing token ...");
	                Response response = renewToken(PropertiesLoader.getInstance().getClientId(), PropertiesLoader.getInstance().getSecretKey());
	                access_token = response.path("access_token");
	                int expiryDurationInSeconds = response.path("expires_in");
	                expiry_time = Instant.now().plusSeconds(expiryDurationInSeconds - 60);
	            } else{
	                System.out.println("Token is good to use");
	            }
	        }
	        catch (Exception e){
	            e.printStackTrace();
	            throw new RuntimeException("ABORT!!! Failed to get token");
	        }
	        return access_token;
	}
	
	// method to create new access token
	
	private static Response renewToken(String clientId, String secretKey)
	{
		HashMap<String, String> formParams = new HashMap<String, String>();
		formParams.put("grant_type", PropertiesLoader.getInstance().getGrantType());
		formParams.put("username", PropertiesLoader.getInstance().getUsername());
		formParams.put("password", PropertiesLoader.getInstance().getPassword());
		
		Response response = RestResource.TokenRequest(UrlEncoderDecoder.encoder(clientId, secretKey), formParams);
		
		if(response.statusCode() != 200)
		{
			throw new RuntimeException("ABORT!! Renew token failed");
		}
		
		return response;
	}

}
