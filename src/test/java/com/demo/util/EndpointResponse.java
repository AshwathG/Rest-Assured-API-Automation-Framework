package com.demo.util;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.demo.api.BaseClass;

import io.restassured.response.Response;

public class EndpointResponse {
	
	// below method is used to validate end point response time
	
	public static void validateResponseTime(Response response)
	{
		Assert.assertTrue(response.getTimeIn(TimeUnit.SECONDS) < BaseClass.ResponseTime);
	}

}
