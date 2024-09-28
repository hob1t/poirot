
package org.uofpeople.poirot.pojos;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@type",
    "address",
    "alumniOf",
    "awards",
    "image",
    "jobTitle",
    "name",
    "sameAs",
    "url",
    "memberOf",
    "worksFor",
    "knowsLanguage",
    "disambiguatingDescription",
    "interactionStatistic",
    "description",
    "reviewedBy"
})
public class Graph {

    @JsonProperty("@type")
    private String type;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("alumniOf")
    private List<AlumniOf> alumniOf;
    @JsonProperty("awards")
    private List<String> awards;
    @JsonProperty("image")
    private Image image;
    @JsonProperty("jobTitle")
    private List<String> jobTitle;
    @JsonProperty("name")
    private String name;
    @JsonProperty("sameAs")
    private String sameAs;
    @JsonProperty("url")
    private String url;
    @JsonProperty("memberOf")
    private List<Object> memberOf;
    @JsonProperty("worksFor")
    private List<WorksFor> worksFor;
    @JsonProperty("knowsLanguage")
    private List<Object> knowsLanguage;
    @JsonProperty("disambiguatingDescription")
    private String disambiguatingDescription;
    @JsonProperty("interactionStatistic")
    private InteractionStatistic interactionStatistic;
    @JsonProperty("description")
    private String description;
    @JsonProperty("reviewedBy")
    private ReviewedBy reviewedBy;
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

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("alumniOf")
    public List<AlumniOf> getAlumniOf() {
        return alumniOf;
    }

    @JsonProperty("alumniOf")
    public void setAlumniOf(List<AlumniOf> alumniOf) {
        this.alumniOf = alumniOf;
    }

    @JsonProperty("awards")
    public List<String> getAwards() {
        return awards;
    }

    @JsonProperty("awards")
    public void setAwards(List<String> awards) {
        this.awards = awards;
    }

    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    @JsonProperty("jobTitle")
    public List<String> getJobTitle() {
        return jobTitle;
    }

    @JsonProperty("jobTitle")
    public void setJobTitle(List<String> jobTitle) {
        this.jobTitle = jobTitle;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("sameAs")
    public String getSameAs() {
        return sameAs;
    }

    @JsonProperty("sameAs")
    public void setSameAs(String sameAs) {
        this.sameAs = sameAs;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("memberOf")
    public List<Object> getMemberOf() {
        return memberOf;
    }

    @JsonProperty("memberOf")
    public void setMemberOf(List<Object> memberOf) {
        this.memberOf = memberOf;
    }

    @JsonProperty("worksFor")
    public List<WorksFor> getWorksFor() {
        return worksFor;
    }

    @JsonProperty("worksFor")
    public void setWorksFor(List<WorksFor> worksFor) {
        this.worksFor = worksFor;
    }

    @JsonProperty("knowsLanguage")
    public List<Object> getKnowsLanguage() {
        return knowsLanguage;
    }

    @JsonProperty("knowsLanguage")
    public void setKnowsLanguage(List<Object> knowsLanguage) {
        this.knowsLanguage = knowsLanguage;
    }

    @JsonProperty("disambiguatingDescription")
    public String getDisambiguatingDescription() {
        return disambiguatingDescription;
    }

    @JsonProperty("disambiguatingDescription")
    public void setDisambiguatingDescription(String disambiguatingDescription) {
        this.disambiguatingDescription = disambiguatingDescription;
    }

    @JsonProperty("interactionStatistic")
    public InteractionStatistic getInteractionStatistic() {
        return interactionStatistic;
    }

    @JsonProperty("interactionStatistic")
    public void setInteractionStatistic(InteractionStatistic interactionStatistic) {
        this.interactionStatistic = interactionStatistic;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("reviewedBy")
    public ReviewedBy getReviewedBy() {
        return reviewedBy;
    }

    @JsonProperty("reviewedBy")
    public void setReviewedBy(ReviewedBy reviewedBy) {
        this.reviewedBy = reviewedBy;
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
