package org.uofpeople.poirot.pojos.facebook;

import static org.junit.jupiter.api.Assertions.*;
import static org.uofpeople.poirot.TestUtils.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uofpeople.poirot.TestUtils;

class FBPersonTest {
	public static final int STR_LEN = 10;
	private FBPerson fbPerson;

	@BeforeEach
	void setUp() {
		fbPerson = new FBPerson();
	}

	@Test
	void getPageName() {
		String pageName = RandomStringUtils.randomAlphabetic(STR_LEN);
		fbPerson.setPageName(pageName);
		assertEquals(pageName, fbPerson.getPageName());
	}

	@Test
	void getPageCategory() {
		String pageCategory = RandomStringUtils.randomAlphabetic(STR_LEN);
		fbPerson.setPageCategory(pageCategory);
		assertEquals(pageCategory, fbPerson.getPageCategory());
	}

	@Test
	void getEmail() {
		String email = TestUtils.createEmail();
		fbPerson.setEmail(email);
		assertEquals(email, fbPerson.getEmail());
	}

	@Test
	void getPageWebsite() {
		String pageWebsite = "https://" + RandomStringUtils.randomAlphabetic(STR_LEN) + ".html";
		fbPerson.setPageWebsite(pageWebsite);
		assertEquals(pageWebsite, fbPerson.getPageWebsite());
	}

	@Test
	void getSocialMediaLinks() {
		fbPerson.setSocialMediaLinks(createLinkList().get(0));
		assertNotNull(fbPerson.getSocialMediaLinks());
	}

	@Test
	void getPhoneNumber() {
		String phoneNumber = generatePhoneNumber();
		fbPerson.setPhoneNumber(phoneNumber);
		assertEquals(phoneNumber, fbPerson.getPhoneNumber());
	}

	@Test
	void getLocation() {
		String location = RandomStringUtils.randomAlphabetic(STR_LEN);
		fbPerson.setLocation(location);
		assertEquals(location, fbPerson.getLocation());
	}

	@Test
	void getRate() {
		String rate = RandomStringUtils.randomNumeric(0, STR_LEN);
		fbPerson.setRate(rate);
		assertEquals(rate, fbPerson.getRate());
	}

	@Test
	void getReviewNumber() {
		String reviewNumber = RandomStringUtils.randomNumeric(0, 3);
		fbPerson.setReviewNumber(reviewNumber);
		assertEquals(reviewNumber, fbPerson.getReviewNumber());
	}

	@Test
	void getPageLikes() {
		String likes = RandomStringUtils.randomNumeric(0, 3);
		fbPerson.setPageLikes(likes);
		assertEquals(likes, fbPerson.getPageLikes());
	}

	@Test
	void getPageFollowers() {
		String followers = RandomStringUtils.randomNumeric(0, 3);
		fbPerson.setPageFollowers(followers);
		assertEquals(followers, fbPerson.getPageFollowers());
	}

	@Test
	void getFollowing() {
		String following = RandomStringUtils.randomNumeric(0, 3);
		fbPerson.setFollowing(following);
		assertEquals(following, fbPerson.getFollowing());
	}

	@Test
	void jsonSerialization() throws JsonProcessingException {
		String json = "{\"page_name\": \"Justin Salhani\", \"page_category\": \"Journalist\", \"email\": \"j.salhani@gmail.com\", \"page_website\": \"http://justinsalhani.com\", \"social_media_links\": null, \"phone_number\": null, \"location\": null, \"rate_\": null, \"review_number\": null, \"page_likes\": null, \"page_followers\": \"1.4K \", \"following\": \"113 \"}";
		ObjectMapper mapper = new ObjectMapper();
		FBPerson result = mapper.readValue(json, FBPerson.class);
		assertNotNull(result);

		// real object
		String realJson = "{\"data\":{\"email\":null,\"following\":null,\"location\":null,\"page_category\":\"The University of Illinois School of Music\",\"page_followers\":null,\"page_likes\":null,\"page_name\":\"Audrey Conklin\",\"page_rate\":null,\"page_review_number\":null,\"page_website\":null,\"phone_number\":null,\"social_media_links\":null},\"isError\":false,\"message\":\"Success\",\"statusCode\":200}\n";
		FBPerson realResult = mapper.readValue(realJson, FBPerson.class);
		assertNotNull(realResult);

		// case 3: should be blank
		String blank = "{\"page_name\":\"Page Not Found\",\"location\":\"None\",\"email\":\"None\",\"phone_number\":\"None\",\"social_media_links\":\"None\",\"page_website\":\"None\",\"page_category\":\"None\",\"page_likes\":\"None\",\"page_followers\":\"None\"}";
		FBPerson blankResult = mapper.readValue(blank, FBPerson.class);
		assertNotNull(blankResult);
		assertTrue(FBPerson.isBlank(blankResult));
	}

	@Test
	void isNotBlank() {
		FBPerson person = createFBPerson();
		int howManyFieldsAreNotBlank = 5;
		assertTrue(FBPerson.isNotBlank(person, howManyFieldsAreNotBlank));
	}
}
