package com.demo.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
	
	// Default request spec for all end points
	
	public static RequestSpecification getRequestSpec(ContentType contentType)
	{
		return new RequestSpecBuilder().
				setBaseUri(Routes.BASE_URI).
		//		setBasePath(basePath).
				setRelaxedHTTPSValidation().
				setContentType(contentType).
		//		addHeader("Authorization", "Bearer "+TokenManager.getToken()).
				addFilter(new AllureRestAssured()).
				log(LogDetail.ALL).build();
	}
	
	// Default response for all end points
	
	public static ResponseSpecification getResponseSpec()
	{
		return new ResponseSpecBuilder().
				log(LogDetail.ALL).build();
	}
	
	// Request spec for access token end point
	
	public static RequestSpecification getAccountRequestSpec()
	{
        return new RequestSpecBuilder().
                setBaseUri(Routes.Token_BASE_URI).
                setContentType(ContentType.URLENC).
                setRelaxedHTTPSValidation().
                addFilter(new AllureRestAssured()).
                log(LogDetail.ALL).
                build();
    } 

}
