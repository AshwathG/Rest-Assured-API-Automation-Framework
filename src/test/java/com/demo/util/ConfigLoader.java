package com.demo.util;

import java.util.Properties;

// class contains method to get the data from properties file

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
    	System.out.println("Loading configuration file");
        properties = PropertyUtils.propertyLoader("src/test/resources/demo.properties");
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }
    
    public Integer getExpectedResponseTime(){
        Integer prop = Integer.parseInt(properties.getProperty("ExpectedResponseTime"));
        if(prop != null) return prop;
        else throw new RuntimeException("property ExpectedResponseTime is not specified in the config.properties file");
    }
    
    public String getExcelPath(String ExcelPath){
        String prop = properties.getProperty(ExcelPath);
        if(prop != null) return prop;
        else throw new RuntimeException("property ExcelPath is not specified in the config.properties file");
    }
    
    public String getEnvironment(){
        String prop = properties.getProperty("Environment");
        if(prop != null) return prop;
        else throw new RuntimeException("property Environment is not specified in the config.properties file");
    }

}
