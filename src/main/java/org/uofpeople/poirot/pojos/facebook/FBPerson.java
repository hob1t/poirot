package org.uofpeople.poirot.pojos.facebook;

import static org.uofpeople.poirot.commons.Constants.NONE;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"page_name", "page_category", "email", "page_website", "social_media_links", "phone_number",
		"location", "rate", "review_number", "page_likes", "page_followers", "following"})
public class FBPerson {
	@JsonProperty("page_name")
	private String pageName;

	@JsonProperty("page_category")
	private String pageCategory;

	@JsonProperty("email")
	private String email;

	@JsonProperty("page_website")
	private String pageWebsite;

	@JsonProperty("social_media_links")
	private String socialMediaLinks;

	@JsonProperty("phone_number")
	private String phoneNumber;

	@JsonProperty("location")
	private String location;

	@JsonProperty("rate_")
	private String rate;

	@JsonProperty("review_number")
	private String reviewNumber;

	@JsonProperty("page_likes")
	private String pageLikes;

	@JsonProperty("page_followers")
	private String pageFollowers;

	@JsonProperty("following")
	private String following;

	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	@JsonProperty("page_name")
	public String getPageName() {
		return pageName;
	}

	@JsonProperty("page_name")
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	@JsonProperty("page_category")
	public String getPageCategory() {
		return pageCategory;
	}

	@JsonProperty("page_category")
	public void setPageCategory(String pageCategory) {
		this.pageCategory = pageCategory;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("page_website")
	public String getPageWebsite() {
		return pageWebsite;
	}

	@JsonProperty("page_website")
	public void setPageWebsite(String pageWebsite) {
		this.pageWebsite = pageWebsite;
	}

	@JsonProperty("social_media_links")
	public String getSocialMediaLinks() {
		return socialMediaLinks;
	}

	@JsonProperty("social_media_links")
	public void setSocialMediaLinks(String socialMediaLinks) {
		this.socialMediaLinks = socialMediaLinks;
	}

	@JsonProperty("phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@JsonProperty("phone_number")
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@JsonProperty("location")
	public String getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(String location) {
		this.location = location;
	}

	@JsonProperty("rate_")
	public String getRate() {
		return rate;
	}

	@JsonProperty("rate_")
	public void setRate(String rate) {
		this.rate = rate;
	}

	@JsonProperty("review_number")
	public String getReviewNumber() {
		return reviewNumber;
	}

	@JsonProperty("review_number")
	public void setReviewNumber(String reviewNumber) {
		this.reviewNumber = reviewNumber;
	}

	@JsonProperty("page_likes")
	public String getPageLikes() {
		return pageLikes;
	}

	@JsonProperty("page_likes")
	public void setPageLikes(String pageLikes) {
		this.pageLikes = pageLikes;
	}

	@JsonProperty("page_followers")
	public String getPageFollowers() {
		return pageFollowers;
	}

	@JsonProperty("page_followers")
	public void setPageFollowers(String pageFollowers) {
		this.pageFollowers = pageFollowers;
	}

	@JsonProperty("following")
	public String getFollowing() {
		return following;
	}

	@JsonProperty("following")
	public void setFollowing(String following) {
		this.following = following;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	/**
	 * {"page_name":"Page Not Found"," location":"None", "email":"None",
	 * "phone_number":"None", "social_media_links":"None", "page_website":"None",
	 * "page_category":"None", "page_likes":"None", "page_followers":"None"}
	 *
	 * @param person
	 * @return
	 */
	public static boolean isBlank(FBPerson person) {
		if (person == null)
			return true;
		if (person.getPageName().equals("Page Not Found") && person.getLocation().equals(NONE)
				&& person.getEmail().equals(NONE) && person.getPhoneNumber().equals(NONE)
				&& person.getSocialMediaLinks().equals(NONE) && person.getPageWebsite().equals(NONE)
				&& person.getPageCategory().equals(NONE) && person.getPageLikes().equals(NONE)
				&& person.getPageFollowers().equals(NONE)) {
			return true;
		}
		return false;
	}

	public static boolean isNotBlank(FBPerson person, int howManyFieldsAreNotBlank) {
		int localNonEmpty = 0;
		if (person == null)
			return true;

		if (person.getPageName() != null) {
			localNonEmpty++;
		}

		if (person.getLocation() != null) {
			localNonEmpty++;
		}

		if (person.getEmail() != null) {
			localNonEmpty++;
		}

		if (person.getPhoneNumber() != null) {
			localNonEmpty++;
		}

		if (person.getSocialMediaLinks() != null) {
			localNonEmpty++;
		}

		if (person.getPageWebsite() != null) {
			localNonEmpty++;
		}

		if (person.getPageCategory() != null) {
			localNonEmpty++;
		}

		if (person.getPageLikes() != null) {
			localNonEmpty++;
		}

		if (person.getPageFollowers() != null) {
			localNonEmpty++;
		}

		return (localNonEmpty >= howManyFieldsAreNotBlank) ? true : false;
	}
}
