package org.uofpeople.poirot.pojos.linkedin;

import static org.junit.jupiter.api.Assertions.*;
import static org.uofpeople.poirot.TestUtils.STR_LEN;
import static org.uofpeople.poirot.TestUtils.createGraphList;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Tests {@link LinkedInPerson} functionality */
class LinkedInPersonTest {
  private LinkedInPerson person;

  @BeforeEach
  void setUp() {
    person = new LinkedInPerson();
  }

  @Test
  void getContext() {
    String context = RandomStringUtils.randomAlphanumeric(STR_LEN);
    person.setContext(context);
    assertEquals(context, person.getContext());
  }

  @Test
  void getGraph() {
    person.setGraph(createGraphList());
    assertNotNull(person.getGraph());
  }

  @Test
  void getAdditionalProperties() {
    person.setAdditionalProperty(
        RandomStringUtils.randomAlphanumeric(STR_LEN),
        RandomStringUtils.randomAlphanumeric(STR_LEN));
    assertNotNull(person.getAdditionalProperties());
  }
}
