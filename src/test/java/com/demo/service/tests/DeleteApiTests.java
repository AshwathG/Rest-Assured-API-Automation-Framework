package com.demo.service.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demo.api.BaseClass;
import com.demo.service.applicationApi.DeleteAPI;
import com.demo.service.pojo.DeleteApiPojos.DeleteUserFailureResponsePojo;
import com.demo.util.DataProviderHelper;
import com.demo.util.EndpointResponse;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;

@Epic("Profile")
@Feature("User Details")
@Story("Delete User")
public class DeleteApiTests extends BaseClass {
	
	@Description("Verify able to delete user successfully")
	@Test(dataProvider = "data-provider", description = "Verify able to delete user successfully")
	public void TC01(String id, String statusCode, String Message, String inputType)
	{			
		Response response = DeleteAPI.delete(id);
		
		// Verify status code
		assertThat(response.statusCode(), equalTo(Integer.parseInt(statusCode)));
		
		// Verify response time
		EndpointResponse.validateResponseTime(response);
				
		boolean Result = false;
		
		if (inputType.equalsIgnoreCase("VALID")) 
		{			
			assertThat(response.statusCode(), equalTo(Integer.parseInt(statusCode)));
			
			Result = true;
		}
		else if(inputType.equalsIgnoreCase("INVALID"))
		{
			DeleteUserFailureResponsePojo Response = response.as(DeleteUserFailureResponsePojo.class);
			assertThat(Response.getMessage(), equalTo(Message));
			Result = true;
		}
		Assert.assertTrue(Result);
	}
	
	@DataProvider(name = "data-provider")
	public Object[][] TestData() 
	{
		return DataProviderHelper.getData("DeleteUserExcelPath", "DeleteUser", 6, 3);
	}

}
