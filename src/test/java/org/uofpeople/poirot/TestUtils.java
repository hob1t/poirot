package org.uofpeople.poirot;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.uofpeople.poirot.dmos.LIPersonDMO;
import org.uofpeople.poirot.pojos.facebook.FBPerson;
import org.uofpeople.poirot.pojos.linkedin.*;

public final class TestUtils {
	private TestUtils() {
	}

	public static final int STR_LEN = 10;

	/**
	 * Generates a random phone number
	 *
	 * @return randomly generated phone number
	 */
	public static String generatePhoneNumber() {
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		sb.append(RandomStringUtils.randomNumeric(3));
		sb.append(")");

		sb.append(RandomStringUtils.randomNumeric(7));
		return sb.toString();
	}

	/**
	 * Creates random email address.
	 *
	 * @return randomly created email address.
	 */
	public static String createEmail() {
		return RandomStringUtils.randomAlphabetic(STR_LEN) + "@" + RandomStringUtils.randomAlphabetic(STR_LEN) + "."
				+ RandomStringUtils.randomAlphabetic(STR_LEN / 3);
	}

	/**
	 * Creates a PersonDTO
	 *
	 * @return randomly created {@link LIPersonDMO}
	 */
	public static LIPersonDMO createPersonDMO() {
		LIPersonDMO personDMO = new LIPersonDMO();
		personDMO.setFirstName(RandomStringUtils.randomAlphabetic(STR_LEN));
		personDMO.setLastName(RandomStringUtils.randomAlphabetic(STR_LEN));
		personDMO.setEmail(createEmail());
		personDMO.setId(UUID.randomUUID().toString());
		personDMO.setAlumni(new ArrayList<>());
		personDMO.setPhone(generatePhoneNumber());
		personDMO.setLocation(RandomStringUtils.randomAlphabetic(STR_LEN));
		return personDMO;
	}

	public static String createRandomUrlAsStr() {
		return "http://" + RandomStringUtils.randomAlphabetic(STR_LEN) + ".html";
	}

	public static List<String> createLinkList() {
		List<String> linkList = new ArrayList<>();
		IntStream.range(0, STR_LEN).forEach(i -> {
			linkList.add(createRandomUrlAsStr());
		});
		return linkList;
	}

	/**
	 * Creates an {@link Address}
	 *
	 * @return randomly creates address.
	 */
	public static Address createAddress() {
		Address address = new Address();
		address.setAddressCountry("USA");
		address.setAddressLocality("Minesota");
		address.setType(RandomStringUtils.randomAlphabetic(STR_LEN));
		address.setAdditionalProperty("street", RandomStringUtils.randomAlphabetic(STR_LEN));
		return address;
	}

	/**
	 * Creates a {@link Member}
	 *
	 * @return
	 */
	public static Member createMember() {
		Member member = new Member();
		member.setAdditionalProperty(RandomStringUtils.randomAlphabetic(STR_LEN),
				RandomStringUtils.randomAlphabetic(STR_LEN));
		member.setType(RandomStringUtils.randomAlphabetic(STR_LEN));
		member.setStartDate(LocalDateTime.now().getYear());
		member.setEndDate(LocalDateTime.now().getYear());
		return member;
	}

	/**
	 * Creates a list of {@link AlumniOf}.
	 *
	 * @return list of alumniOf
	 */
	public static List<AlumniOf> createAlumniOfList() {
		List<AlumniOf> alumniOfList = new ArrayList<>();
		IntStream.range(0, STR_LEN).forEach(i -> {
			alumniOfList.add(createAlumniOf());
		});
		return alumniOfList;
	}

	/**
	 * Creates {@link AlumniOf}
	 *
	 * @return randomly created AlumniOf
	 */
	public static AlumniOf createAlumniOf() {
		AlumniOf alumniOf = new AlumniOf();
		alumniOf.setAdditionalProperty(RandomStringUtils.randomAlphabetic(STR_LEN),
				RandomStringUtils.randomAlphabetic(STR_LEN));
		alumniOf.setName(RandomStringUtils.randomAlphabetic(STR_LEN));
		alumniOf.setType(RandomStringUtils.randomAlphabetic(STR_LEN));
		alumniOf.setUrl("http://" + RandomStringUtils.randomAlphabetic(STR_LEN) + ".html");
		alumniOf.setMember(createMember());
		return alumniOf;
	}

	/**
	 * Create list of {@link String}s
	 *
	 * @return list of random Strings
	 */
	public static List<String> createListOfString() {
		List<String> list = new ArrayList<>();
		IntStream.range(0, STR_LEN).forEach(i -> {
			list.add(RandomStringUtils.randomAlphabetic(STR_LEN));
		});
		return list;
	}

	/**
	 * Creates a {@link Image}
	 *
	 * @return randomly created image.
	 */
	public static Image createImage() {
		Image image = new Image();
		image.setAdditionalProperty(RandomStringUtils.randomAlphabetic(STR_LEN),
				RandomStringUtils.randomAlphabetic(STR_LEN));
		image.setType(RandomStringUtils.randomAlphabetic(STR_LEN));
		image.setContentUrl("http://" + RandomStringUtils.randomAlphabetic(STR_LEN) + ".png");
		return image;
	}

	/**
	 * Creates a list of {@link WorksFor}.
	 *
	 * @return a list of random WorksFor
	 */
	public static List<WorksFor> createWorksForList() {
		List<WorksFor> worksForList = new ArrayList<>();
		IntStream.range(0, STR_LEN).forEach(i -> {
			worksForList.add(createWorksFor());
		});
		return worksForList;
	}

	/**
	 * Creates an {@link InteractionStatistic}
	 *
	 * @return randomly create InteractionStatistic.
	 */
	public static InteractionStatistic createInteractionStatistic() {
		InteractionStatistic interactionStatistic = new InteractionStatistic();
		interactionStatistic.setInteractionType(RandomStringUtils.randomAlphabetic(STR_LEN));
		interactionStatistic.setName(RandomStringUtils.randomAlphabetic(STR_LEN));
		interactionStatistic.setUserInteractionCount(STR_LEN);
		return interactionStatistic;
	}

	/**
	 * Creates a {@link WorksFor}
	 *
	 * @return randomly create WorksFor
	 */
	public static WorksFor createWorksFor() {
		WorksFor worksFor = new WorksFor();
		worksFor.setMember(createFellow());
		worksFor.setType(RandomStringUtils.randomAlphabetic(STR_LEN));
		worksFor.setName(RandomStringUtils.randomAlphabetic(STR_LEN));
		worksFor.setUrl("http://" + RandomStringUtils.randomAlphabetic(STR_LEN) + ".html");
		worksFor.setLocation(RandomStringUtils.randomAlphabetic(STR_LEN));
		return worksFor;
	}

	/**
	 * Creates a {@link Fellow}
	 *
	 * @return randomly create Fellow
	 */
	public static Fellow createFellow() {
		Fellow fellow = new Fellow();
		fellow.set_type(RandomStringUtils.randomAlphabetic(STR_LEN));
		fellow.setDescription(RandomStringUtils.randomAlphabetic(STR_LEN));
		fellow.setAdditionalProperty(RandomStringUtils.randomAlphabetic(STR_LEN),
				RandomStringUtils.randomAlphabetic(STR_LEN));
		return fellow;
	}

	/**
	 * Creates {@link ReviewedBy}
	 *
	 * @return randomly created reviewedBy.
	 */
	public static ReviewedBy createReviewedBy() {
		ReviewedBy reviewedBy = new ReviewedBy();
		reviewedBy.setName(RandomStringUtils.randomAlphabetic(STR_LEN));
		reviewedBy.setType(RandomStringUtils.randomAlphabetic(STR_LEN));
		reviewedBy.setAdditionalProperty(RandomStringUtils.randomAlphabetic(STR_LEN),
				RandomStringUtils.randomAlphabetic(STR_LEN));
		return reviewedBy;
	}

	/**
	 * Creates {@link Graph}
	 *
	 * @return randomly created graph
	 */
	public static Graph createGraph() {
		Graph graph = new Graph();
		graph.setAdditionalProperty(RandomStringUtils.randomAlphabetic(STR_LEN),
				RandomStringUtils.randomAlphabetic(STR_LEN));
		graph.setName(RandomStringUtils.randomAlphabetic(STR_LEN) + " " + RandomStringUtils.randomAlphabetic(STR_LEN));
		graph.setReviewedBy(createReviewedBy());
		graph.setInteractionStatistic(createInteractionStatistic());
		graph.setDisambiguatingDescription(RandomStringUtils.randomAlphabetic(STR_LEN));
		graph.setKnowsLanguage(Collections.singletonList(createListOfString()));
		graph.setWorksFor(createWorksForList());
		graph.setMemberOf(Collections.singletonList(createListOfString()));
		graph.setAwards(createListOfString());
		graph.setImage(createImage());
		graph.setAddress(createAddress());
		graph.setJobTitle(createListOfString());
		graph.setUrl("http://" + RandomStringUtils.randomAlphabetic(STR_LEN) + ".html");
		graph.setType(RandomStringUtils.randomAlphabetic(STR_LEN));
		graph.setSameAs(RandomStringUtils.randomAlphabetic(STR_LEN));

		return graph;
	}

	/**
	 * Creates a list of {@link Graph}
	 *
	 * @return a list of graph.
	 */
	public static List<Graph> createGraphList() {
		List<Graph> graphList = new ArrayList<>();
		IntStream.range(0, STR_LEN).forEach(i -> {
			graphList.add(createGraph());
		});
		return graphList;
	}

	public static FBPerson createFBPerson() {
		String json = "{\"page_name\": \"Justin Salhani\", \"page_category\": \"Journalist\", \"email\": \"j.salhani@gmail.com\", \"page_website\": \"http://justinsalhani.com\", \"social_media_links\": null, \"phone_number\": null, \"location\": null, \"rate_\": null, \"review_number\": null, \"page_likes\": null, \"page_followers\": \"1.4K \", \"following\": \"113 \"}";
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, FBPerson.class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
