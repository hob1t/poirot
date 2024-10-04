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
@JsonPropertyOrder({"@type", "addressLocality", "addressCountry"})
public class Address {

  @JsonProperty("@type")
  private String type;

  @JsonProperty("addressLocality")
  private String addressLocality;

  @JsonProperty("addressCountry")
  private String addressCountry;

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

  @JsonProperty("addressLocality")
  public String getAddressLocality() {
    return addressLocality;
  }

  @JsonProperty("addressLocality")
  public void setAddressLocality(String addressLocality) {
    this.addressLocality = addressLocality;
  }

  @JsonProperty("addressCountry")
  public String getAddressCountry() {
    return addressCountry;
  }

  @JsonProperty("addressCountry")
  public void setAddressCountry(String addressCountry) {
    this.addressCountry = addressCountry;
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
