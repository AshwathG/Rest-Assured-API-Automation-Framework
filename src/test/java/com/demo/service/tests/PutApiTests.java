package com.demo.service.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.api.BaseClass;
import com.demo.service.applicationApi.PutAPI;
import com.demo.service.pojo.PutApiPojos.UpdateUserFailureResponsePojo;
import com.demo.service.pojo.PutApiPojos.UpdateUserRequestPojo;
import com.demo.service.pojo.PutApiPojos.UpdateUserResponsePojo;
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
@Story("Update User")
public class PutApiTests extends BaseClass {
	
	@Description("Verify able to update user successfully")
	@Test(dataProvider = "data-provider", description = "Verify able to update user successfully")
	public void TC01(String userid, String name, String job, String statusCode, String Message, String inputType)
	{	
		UpdateUserRequestPojo requestBody = requestBuilder(name, job);
		
		Response response = PutAPI.put(userid, requestBody);
		
		// Verify status code
		assertThat(response.statusCode(), equalTo(Integer.parseInt(statusCode)));
		
		// Verify response time
		EndpointResponse.validateResponseTime(response);
				
		boolean Result = false;
		
		if (inputType.equalsIgnoreCase("VALID")) 
		{			
			UpdateUserResponsePojo Response = response.as(UpdateUserResponsePojo.class);
			assertThat(Response.getName(), equalTo(name));
			assertThat(Response.getJob(), equalTo(job));
			
			Result = true;
		}
		else if(inputType.equalsIgnoreCase("INVALID"))
		{
			UpdateUserFailureResponsePojo Response = response.as(UpdateUserFailureResponsePojo.class);
			assertThat(Response.getMessage(), equalTo(Message));
			Result = true;
		}
		Assert.assertTrue(Result);
	}
	
	@Step
    public UpdateUserRequestPojo requestBuilder(String name, String job)
    {
    	return UpdateUserRequestPojo.builder()
    			.name(name)
    			.job(job)
    			.build();
     }
	
	@DataProvider(name = "data-provider")
	public Object[][] TestData() 
	{
		return DataProviderHelper.getData("UpdateUserExcelPath", "UpdateUser", 6, 5);
	}

}
