package com.demo.service.applicationApi;

import com.demo.api.RestResource;
import com.demo.api.Routes;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteAPI {
	
	@Step
	public static Response delete(String pathParamValue)
	{
		return RestResource.delete(Routes.Delete_Users, "userId", pathParamValue, ContentType.JSON);
	}

}
