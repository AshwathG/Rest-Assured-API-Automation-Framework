package com.demo.service.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.api.BaseClass;
import com.demo.service.applicationApi.PostAPI;
import com.demo.service.pojo.PostApiPojos.SaveUserFailureResponsePojo;
import com.demo.service.pojo.PostApiPojos.SaveUserRequestPojo;
import com.demo.service.pojo.PostApiPojos.SaveUserSuccessResponsePojo;
import com.demo.util.DataProviderHelper;
import com.demo.util.EndpointResponse;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.response.Response;

@Epic("Profile")
@Feature("User Details")
@Story("Save User")
public class PostApiTests extends BaseClass {
	
	@Description("Verify able to save user successfully")
	@Test(dataProvider = "data-provider", description = "Verify able to save user successfully")
	public void TC01(String name, String job, String statusCode, String Message, String inputType)
	{	
		SaveUserRequestPojo requestBody = requestBuilder(name, job);
		
		Response response = PostAPI.post(requestBody);
		
		// Verify status code
		assertThat(response.statusCode(), equalTo(Integer.parseInt(statusCode)));
		
		// Verify response time
		EndpointResponse.validateResponseTime(response);
				
		boolean Result = false;
		
		if (inputType.equalsIgnoreCase("VALID")) 
		{			
			SaveUserSuccessResponsePojo Response = response.as(SaveUserSuccessResponsePojo.class);
			assertThat(Response.getName(), equalTo(name));
			assertThat(Response.getJob(), equalTo(job));
			
			Result = true;
		}
		else if(inputType.equalsIgnoreCase("INVALID"))
		{
			SaveUserFailureResponsePojo Response = response.as(SaveUserFailureResponsePojo.class);
			assertThat(Response.getMessage(), equalTo(Message));
			Result = true;
		}
		Assert.assertTrue(Result);
	}
	
	@Step
    public SaveUserRequestPojo requestBuilder(String name, String job)
    {
    	return SaveUserRequestPojo.builder()
    			.name(name)
    			.job(job)
    			.build();
     }
	
	@DataProvider(name = "data-provider")
	public Object[][] TestData() 
	{
		return DataProviderHelper.getData("SaveUserExcelPath", "SaveUser", 6, 4);
	}

}
