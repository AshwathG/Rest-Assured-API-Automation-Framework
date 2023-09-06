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
public class Support {
	
	@JsonProperty("url")
	public String url;
	
	@JsonProperty("text")
	public String text;

}
