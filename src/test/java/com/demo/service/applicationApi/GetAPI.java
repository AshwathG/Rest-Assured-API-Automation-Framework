package com.demo.service.applicationApi;

import java.util.HashMap;

import com.demo.api.RestResource;
import com.demo.api.Routes;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAPI {
	
	@Step
	public static Response get(HashMap<String, String> queryParams)
	{
		return RestResource.get(Routes.Get_Users, ContentType.JSON, queryParams);
	}

}
