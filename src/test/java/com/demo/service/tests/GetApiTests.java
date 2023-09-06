package com.demo.service.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.api.BaseClass;
import com.demo.service.applicationApi.GetAPI;
import com.demo.service.pojo.GetApiPojos.GetUserFailureResponsePojo;
import com.demo.service.pojo.GetApiPojos.GetUserSuccessResponsePojo;
import com.demo.util.DataProviderHelper;
import com.demo.util.EndpointResponse;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;

@Epic("Profile")
@Feature("User Details")
@Story("Get User")
public class GetApiTests extends BaseClass {
	
	@Description("Verify able to get user successfully")
	@Test(dataProvider = "data-provider", description = "Verify able to get user successfully")
	public void TC01(String page, String statusCode, String Message, String inputType)
	{			
		Response response = GetAPI.get(getQueryParams(page));
		
		// Verify status code
		assertThat(response.statusCode(), equalTo(Integer.parseInt(statusCode)));
		
		// Verify response time
		EndpointResponse.validateResponseTime(response);
				
		boolean Result = false;
		
		if (inputType.equalsIgnoreCase("VALID")) 
		{			
			GetUserSuccessResponsePojo Response = response.as(GetUserSuccessResponsePojo.class);
			assertThat(Response.getPage(), equalTo(Integer.parseInt(page)));
			
			Result = true;
		}
		else if(inputType.equalsIgnoreCase("INVALID"))
		{
			GetUserFailureResponsePojo Response = response.as(GetUserFailureResponsePojo.class);
			assertThat(Response.getMessage(), equalTo(Message));
			Result = true;
		}
		Assert.assertTrue(Result);
	}
	
	public HashMap<String, String> getQueryParams(String pageNo)
	{
		HashMap<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("page", pageNo);
		
		return queryParams;
	}
	
	@DataProvider(name = "data-provider")
	public Object[][] TestData() 
	{
		return DataProviderHelper.getData("GetUserExcelPath", "GetUser", 6, 3);
	}

}
