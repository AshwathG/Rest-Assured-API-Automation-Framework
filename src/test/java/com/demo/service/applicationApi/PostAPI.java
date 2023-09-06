package com.demo.service.applicationApi;

import com.demo.api.RestResource;
import com.demo.api.Routes;
import com.demo.service.pojo.PostApiPojos.SaveUserRequestPojo;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostAPI {
	
	@Step
	public static Response post(SaveUserRequestPojo saveUserRequestPojo)
	{
		return RestResource.post(Routes.Post_Users, ContentType.JSON, saveUserRequestPojo);
	}

}