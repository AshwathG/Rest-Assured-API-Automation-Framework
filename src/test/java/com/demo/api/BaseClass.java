package com.demo.api;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.demo.util.ConfigLoader;
import com.demo.util.XMLReader;

public abstract class BaseClass {
	
	public static int ResponseTime;
	protected static HashMap<String, String> XmlStrings = new HashMap<String, String>();

	@BeforeSuite
	public static void setup() throws IOException
	{
		System.out.println("Starting Test Suit.....");
		ResponseTime = ConfigLoader.getInstance().getExpectedResponseTime();
		System.out.println("Loading xml file.....");
		XmlStrings = XMLReader.loadFile();
	}

    @BeforeMethod
    public void startMethod(Method m){
        System.out.println("STARTING TEST: " + m.getName()+ "***** THREAD ID: "+ Thread.currentThread().getId());
    }
    
    @BeforeMethod
    public void endMethod(Method m){
    	System.out.println("ENDING TEST: " + m.getName()+ "***** THREAD ID: "+ Thread.currentThread().getId());
    }
    
    public abstract Object[][] TestData();
    
}
