package com.demo.service.applicationApi;

import com.demo.api.RestResource;
import com.demo.api.Routes;
import com.demo.service.pojo.PutApiPojos.UpdateUserRequestPojo;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutAPI {
	
	@Step
	public static Response put(String pathParamValue, UpdateUserRequestPojo updateUserRequestPojo)
	{
		return RestResource.put(Routes.Put_Users, "userId", pathParamValue, ContentType.JSON, updateUserRequestPojo);
	}

}
