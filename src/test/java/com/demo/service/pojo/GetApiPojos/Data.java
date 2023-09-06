package com.demo.service.pojo.GetApiPojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter @Setter
@Jacksonized
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data {
	
	@JsonProperty("id")
	public Integer id;
	
	@JsonProperty("email")
	public String email;
	
	@JsonProperty("first_name")
	public String firstName;
	
	@JsonProperty("last_name")
	public String lastName;
	
	@JsonProperty("avatar")
	public String avatar;

}
