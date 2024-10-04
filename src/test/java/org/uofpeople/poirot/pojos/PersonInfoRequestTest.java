package org.uofpeople.poirot.pojos;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.uofpeople.poirot.TestUtils;
import org.uofpeople.poirot.pojos.linkedin.PersonInfoRequest;

class PersonInfoRequestTest {
  public static final int STR_LEN = 10;
  private PersonInfoRequest personInfoRequest;

  @BeforeEach
  void setUp() {
    personInfoRequest = new PersonInfoRequest();
  }

  @Test
  void getFirstName() {
    String firstName = RandomStringUtils.randomAlphabetic(STR_LEN);
    personInfoRequest.setFirstName(firstName);
    assertEquals(firstName, personInfoRequest.getFirstName());
  }

  @Test
  void getLastName() {
    String lastName = RandomStringUtils.randomAlphabetic(STR_LEN);
    personInfoRequest.setLastName(lastName);
    assertEquals(lastName, personInfoRequest.getLastName());
  }

  @Test
  void getEmail() {
    String email =
        RandomStringUtils.randomAlphabetic(STR_LEN)
            + "@"
            + RandomStringUtils.randomAlphabetic(STR_LEN);
    personInfoRequest.setEmail(email);
    assertEquals(email, personInfoRequest.getEmail());
  }

  @Test
  void getPhone() {
    String phone = TestUtils.generatePhoneNumber();
    personInfoRequest.setPhone(phone);
    assertEquals(phone, personInfoRequest.getPhone());
  }

  @Test
  void getLocation() {
    String location = RandomStringUtils.randomAlphabetic(STR_LEN);
    personInfoRequest.setLocation(location);
    assertEquals(location, personInfoRequest.getLocation());
  }

  @Test
  void testToString() {
    assertNotNull(personInfoRequest.toString());
  }

  @Test
  void pojoToString() throws JsonProcessingException {
    personInfoRequest.setFirstName(RandomStringUtils.randomAlphabetic(STR_LEN));
    personInfoRequest.setLastName(RandomStringUtils.randomAlphabetic(STR_LEN));
    personInfoRequest.setEmail(RandomStringUtils.randomAlphabetic(STR_LEN));
    personInfoRequest.setPhone(RandomStringUtils.randomAlphabetic(STR_LEN));
    personInfoRequest.setLocation(RandomStringUtils.randomAlphabetic(STR_LEN));

    // {"firstName":"OoOuRGFjBX","lastName":"rymMAECYex","email":"VDOGuwCHjj","phone":"YteIwXkmpD","location":"NihFqnneJb"}
    ObjectMapper mapper = new ObjectMapper();
    String objAsStr = mapper.writeValueAsString(personInfoRequest);
    assertNotNull(objAsStr);
  }
}
