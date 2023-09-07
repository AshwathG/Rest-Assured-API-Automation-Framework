
package com.demo.generatedjsonpojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "locality",
    "city"
})
public class Address {

    @JsonProperty("locality")
    public String locality;
    @JsonProperty("city")
    public String city;

}
