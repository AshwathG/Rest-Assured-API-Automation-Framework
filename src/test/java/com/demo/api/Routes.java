package com.demo.api;

import com.demo.util.PropertiesLoader;

public class Routes {
	
	// Access token urls
	
	public static final String Token_BASE_URI = PropertiesLoader.getInstance().getBaseUri();
	public static final String getToken = "";
	
	// Define base url and all end points
	
	public static final String BASE_URI = PropertiesLoader.getInstance().getBaseUri();
	public static final String Post_Users = "/api/users";
	public static final String Get_Users = "/api/users";
	public static final String Put_Users = "/api/users/{userId}";
	public static final String Delete_Users = "/api/users/{userId}";
}
