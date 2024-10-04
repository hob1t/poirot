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
@JsonPropertyOrder({"@type", "interactionType", "name", "userInteractionCount"})
public class InteractionStatistic {

  @JsonProperty("@type")
  private String type;

  @JsonProperty("interactionType")
  private String interactionType;

  @JsonProperty("name")
  private String name;

  @JsonProperty("userInteractionCount")
  private int userInteractionCount;

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

  @JsonProperty("interactionType")
  public String getInteractionType() {
    return interactionType;
  }

  @JsonProperty("interactionType")
  public void setInteractionType(String interactionType) {
    this.interactionType = interactionType;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("userInteractionCount")
  public int getUserInteractionCount() {
    return userInteractionCount;
  }

  @JsonProperty("userInteractionCount")
  public void setUserInteractionCount(int userInteractionCount) {
    this.userInteractionCount = userInteractionCount;
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
