package org.uofpeople.poirot.pojos.linkedin;

import static org.junit.jupiter.api.Assertions.*;
import static org.uofpeople.poirot.TestUtils.*;

import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Tests {@link Graph} functionality. */
class GraphTest {
  public static final int STR_LEN = 10;
  private Graph graph;

  @BeforeEach
  void setUp() {
    graph = new Graph();
  }

  @Test
  void getType() {
    String type = RandomStringUtils.randomAlphabetic(STR_LEN);
    graph.setType(type);
    assertEquals(type, graph.getType());
  }

  @Test
  void getAddress() {
    Address address = createAddress();
    graph.setAddress(address);
    assertEquals(address, graph.getAddress());
  }

  @Test
  void getAlumniOf() {
    List<AlumniOf> alumniOfList = createAlumniOfList();
    graph.setAlumniOf(alumniOfList);
    assertEquals(alumniOfList, graph.getAlumniOf());
  }

  @Test
  void getAwards() {
    List<String> listOfAwards = createListOfString();
    graph.setAwards(listOfAwards);
    assertEquals(listOfAwards, graph.getAwards());
  }

  @Test
  void getImage() {
    Image image = createImage();
    graph.setImage(image);
    assertEquals(image, graph.getImage());
  }

  @Test
  void getJobTitle() {
    List<String> jobTitles = createListOfString();
    graph.setJobTitle(jobTitles);
    assertEquals(jobTitles, graph.getJobTitle());
  }

  @Test
  void getName() {
    String name = RandomStringUtils.randomAlphabetic(STR_LEN);
    graph.setName(name);
    assertEquals(name, graph.getName());
  }

  @Test
  void getSameAs() {
    String sameAs = RandomStringUtils.randomAlphabetic(STR_LEN);
    graph.setSameAs(sameAs);
    assertEquals(sameAs, graph.getSameAs());
  }

  @Test
  void getUrl() {
    String url = "httpd://" + RandomStringUtils.randomAlphabetic(STR_LEN) + ".com";
    graph.setUrl(url);
    assertEquals(url, graph.getUrl());
  }

  @Test
  void getMemberOf() {
    List<Object> listOfMembers = Collections.singletonList(createListOfString());
    graph.setMemberOf(listOfMembers);
    assertEquals(listOfMembers, graph.getMemberOf());
  }

  @Test
  void getWorksFor() {
    List<WorksFor> worksForList = createWorksForList();
    graph.setWorksFor(worksForList);
    assertEquals(worksForList, graph.getWorksFor());
  }

  @Test
  void getKnowsLanguage() {
    List<String> knowsLanguage = createListOfString();
    graph.setKnowsLanguage(Collections.singletonList(knowsLanguage));
    assertNotNull(graph.getKnowsLanguage());
  }

  @Test
  void getDisambiguatingDescription() {
    String disambiguatingDescription = RandomStringUtils.randomAlphabetic(STR_LEN);
    graph.setDisambiguatingDescription(disambiguatingDescription);
    assertEquals(disambiguatingDescription, graph.getDisambiguatingDescription());
  }

  @Test
  void getInteractionStatistic() {
    InteractionStatistic interactionStatistic = createInteractionStatistic();
    graph.setInteractionStatistic(interactionStatistic);
    assertEquals(interactionStatistic, graph.getInteractionStatistic());
  }

  @Test
  void getDescription() {
    String description = RandomStringUtils.randomAlphabetic(STR_LEN);
    graph.setDescription(description);
    assertEquals(description, graph.getDescription());
  }

  @Test
  void getReviewedBy() {
    ReviewedBy reviewedBy = createReviewedBy();
    graph.setReviewedBy(reviewedBy);
    assertEquals(reviewedBy, graph.getReviewedBy());
  }

  @Test
  void getAdditionalProperties() {
    graph.setAdditionalProperty(
        RandomStringUtils.randomAlphabetic(STR_LEN), RandomStringUtils.randomAlphabetic(STR_LEN));
    assertNotNull(graph.getAdditionalProperties());
  }
}
