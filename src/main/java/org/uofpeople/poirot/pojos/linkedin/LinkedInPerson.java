package org.uofpeople.poirot.pojos.linkedin;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"@context", "@graph"})
public class LinkedInPerson {

	@JsonProperty("@context")
	private String context;

	@JsonProperty("@graph")
	private List<Graph> graph;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("@context")
	public String getContext() {
		return context;
	}

	@JsonProperty("@context")
	public void setContext(String context) {
		this.context = context;
	}

	@JsonProperty("@graph")
	public List<Graph> getGraph() {
		return graph;
	}

	@JsonProperty("@graph")
	public void setGraph(List<Graph> graph) {
		this.graph = graph;
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
