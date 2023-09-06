package com.demo.service.pojo.GetApiPojos;

import java.util.List;

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
public class GetUserSuccessResponsePojo {
	
	@JsonProperty("page")
	public Integer page;
	
	@JsonProperty("per_page")
	public Integer perPage;
	
	@JsonProperty("total")
	public Integer total;
	
	@JsonProperty("total_pages")
	public Integer totalPages;
	
	@JsonProperty("data")
	public List<Data> data;
	
	@JsonProperty("support")
	public Support support;

}
