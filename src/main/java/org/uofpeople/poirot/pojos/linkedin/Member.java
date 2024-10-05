package org.uofpeople.poirot.pojos.linkedin;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"@type", "startDate", "endDate"})
public class Member {

	@JsonProperty("@type")
	private String type;

	@JsonProperty("startDate")
	private int startDate;

	@JsonProperty("endDate")
	private int endDate;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("@type")
	public String getType() {
		return type;
	}

	@JsonProperty("@type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("startDate")
	public int getStartDate() {
		return startDate;
	}

	@JsonProperty("startDate")
	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	@JsonProperty("endDate")
	public int getEndDate() {
		return endDate;
	}

	@JsonProperty("endDate")
	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}
