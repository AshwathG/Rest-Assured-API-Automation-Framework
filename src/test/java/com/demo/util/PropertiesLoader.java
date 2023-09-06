package com.demo.util;

import java.util.Properties;

public class PropertiesLoader {
	
	private final Properties properties;
	private static PropertiesLoader propertiesLoader;
	
	public static String filePath = null;
	
	 private PropertiesLoader(){
		 
		 String env = ConfigLoader.getInstance().getEnvironment();
		 
		 
		 if(env.equalsIgnoreCase("local"))
		 {
			 filePath = "src/test/resources/Credentials/local_credentials.properties";
		 }
		 else if(env.equalsIgnoreCase("qa"))
		 {
			 filePath = "src/test/resources/Credentials/qa_credentials.properties";
		 }
		 else if(env.equalsIgnoreCase("dev"))
		 {
			 filePath = "src/test/resources/Credentials/dev_credentials.properties";
		 }
		 
	     properties = PropertyUtils.propertyLoader(filePath);
	    }
	 
	 public static PropertiesLoader getInstance(){
	        if(propertiesLoader == null){
	        	propertiesLoader = new PropertiesLoader();
	        }
	        return propertiesLoader;
	    }
	 
	 public String getClientId(){
	        String prop = properties.getProperty("clientId");
	        if(prop != null) return prop;
	        else throw new RuntimeException("property clientId is not specified in the credentials.properties file");
	    }

	    public String getSecretKey(){
	        String prop = properties.getProperty("secretKey");
	        if(prop != null) return prop;
	        else throw new RuntimeException("property secretKey is not specified in the credentials.properties file");
	    }

	    public String getGrantType(){
	        String prop = properties.getProperty("grant_type");
	        if(prop != null) return prop;
	        else throw new RuntimeException("property grant_type is not specified in the credentials.properties file");
	    }
	    
	    public String getUsername(){
	        String prop = properties.getProperty("username");
	        if(prop != null) return prop;
	        else throw new RuntimeException("property username is not specified in the credentials.properties file");
	    }
	    
	    public String getPassword(){
	        String prop = properties.getProperty("password");
	        if(prop != null) return prop;
	        else throw new RuntimeException("property password is not specified in the credentials.properties file");
	    }
	    
	    public String getBaseUri(){
	        String prop = properties.getProperty("BASE_URI");
	        if(prop != null) return prop;
	        else throw new RuntimeException("property BASE_URI is not specified in the credentials.properties file");
	    }
	    
	    public String getTokenBaseUri(){
	        String prop = properties.getProperty("Token_BASE_URI");
	        if(prop != null) return prop;
	        else throw new RuntimeException("property Token_BASE_URI is not specified in the credentials.properties file");
	    }
	    
	    public String getDatabaseIP(){
	        String prop = properties.getProperty("Database_IP");
	        if(prop != null) return prop;
	        else throw new RuntimeException("property Database_IP is not specified in the credentials.properties file");
	    }
	    
	    public String getDatabaseName(){
	        String prop = properties.getProperty("Database_Name");
	        if(prop != null) return prop;
	        else throw new RuntimeException("property Database_Name is not specified in the credentials.properties file");
	    }
	    
	    public String getDatabaseUsername(){
	        String prop = properties.getProperty("Database_Username");
	        if(prop != null) return prop;
	        else throw new RuntimeException("property Database_Username is not specified in the credentials.properties file");
	    }
	    
	    public String getDatabasePassword(){
	        String prop = properties.getProperty("Database_Password");
	        if(prop != null) return prop;
	        else throw new RuntimeException("property Database_Password is not specified in the credentials.properties file");
	    }

}
