package com.demo.api;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestResource {
	
	// Create different combination of post, get, put, delete methods.
	// for example post method can have body and path parameter OR only body
	
	// Post request with authorization
	public static Response post(String path, String token, ContentType contentType, Object requestPayload)
	{
		return given(SpecBuilder.getRequestSpec(contentType)).
				header("Authorization", "Bearer "+token).
				body(requestPayload).
			when().
				post(path).
			then().spec(SpecBuilder.getResponseSpec()).
				extract().response();
	}
	
	// Post request without authorization
	public static Response post(String path, ContentType contentType, Object requestPayload)
	{
		return given(SpecBuilder.getRequestSpec(contentType)).
				body(requestPayload).
			when().
				post(path).
			then().spec(SpecBuilder.getResponseSpec()).
				extract().response();
	}
	
	// Post request with multi part payload
	public static Response post(String path, ContentType contentType, String formDataFilePath)
	{
		return given(SpecBuilder.getRequestSpec(contentType)).
				multiPart("file", new File(formDataFilePath)).
			when().
				post(path).
			then().spec(SpecBuilder.getResponseSpec()).
				extract().response();
	}
	
	// Get request with query params
	public static Response get(String path, ContentType contentType, HashMap<String, String> queryParams)
	{
		return given(SpecBuilder.getRequestSpec(contentType)).
				queryParams(queryParams).
			when().
				get(path).
			then().spec(SpecBuilder.getResponseSpec()).
				extract().response();
	}
	
	// Get request without query params
	public static Response get(String path, ContentType contentType)
	{
		return given(SpecBuilder.getRequestSpec(contentType)).
			when().
				get(path).
			then().spec(SpecBuilder.getResponseSpec()).
				extract().response();
	}
	
	// Put request without path param
	public static Response put(String path, ContentType contentType, Object requestPayload)
	{
		return given(SpecBuilder.getRequestSpec(contentType)).
				body(requestPayload).
			when().
				put(path).
			then().spec(SpecBuilder.getResponseSpec()).
				extract().response();
	}
	
	// Put request with path param
	public static Response put(String path, ContentType contentType, String pathParamName, String pathParamValue)
	{
		return given(SpecBuilder.getRequestSpec(contentType)).
				pathParams(pathParamName, pathParamValue).
			when().
				put(path).
			then().spec(SpecBuilder.getResponseSpec()).
				extract().response();
	}
	
	// Put request with request body and path param
	public static Response put(String path, String pathParamName, String pathParamValue, ContentType contentType, Object requestPayload)
	{
		return given(SpecBuilder.getRequestSpec(contentType)).
				pathParams(pathParamName, pathParamValue).
				body(requestPayload).
			when().
				put(path).
			then().spec(SpecBuilder.getResponseSpec()).
				extract().response();
	}
	
	// Delete request with query params
	public static Response delete(String path, ContentType contentType, HashMap<String, String> queryParams)
	{
		return given(SpecBuilder.getRequestSpec(contentType)).
				queryParams(queryParams).
			when().
				delete(path).
			then().spec(SpecBuilder.getResponseSpec()).
				extract().response();
	}
	
	// Delete request with path params
	public static Response delete(String path, String pathParamName, String pathParamValue, ContentType contentType)
	{
		return given(SpecBuilder.getRequestSpec(contentType)).
				pathParams(pathParamName, pathParamValue).
			when().
				delete(path).
			then().spec(SpecBuilder.getResponseSpec()).
				extract().response();
	}
	
	// Below method is for hitting getToken end point
	
	public static Response TokenRequest(String basicValue, HashMap<String, String> formParams)
	{
		Response response = given(SpecBuilder.getAccountRequestSpec()).
				formParams(formParams).
				header("Authorization", "Basic "+basicValue).
			when().
				post(Routes.getToken).
			then().
				spec(SpecBuilder.getResponseSpec()).
				extract().
				response();
		
		return response;
	}

}
