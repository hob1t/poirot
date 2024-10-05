package org.uofpeople.poirot.commons;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.uofpeople.poirot.TestUtils;
import org.uofpeople.poirot.dmos.FBPersonDMO;
import org.uofpeople.poirot.dmos.LIPersonDMO;
import org.uofpeople.poirot.pojos.facebook.FBPerson;
import org.uofpeople.poirot.pojos.linkedin.Graph;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests {@link Utilities} functionality.
 */
class UtilitiesTest {

	@Test
	void buildFromFBPerson() {
		String query = RandomStringUtils.randomAlphabetic(TestUtils.STR_LEN) + " "
				+ RandomStringUtils.randomAlphabetic(TestUtils.STR_LEN);
		FBPerson fbPerson = TestUtils.createFBPerson();
		FBPersonDMO dmoResult = Utilities.buildFrom(fbPerson, query);
		assertNotNull(dmoResult);
	}

	@Test
	void buildFromGraph() {
		Graph graph = TestUtils.createGraph();
		String liUrl = TestUtils.createRandomUrlAsStr();
		LIPersonDMO result = Utilities.buildFrom(graph, liUrl);
		assertNotNull(result);
	}

	@Test
	void checkAndFixUrl() {
		String url = TestUtils.createRandomUrlAsStr().replace("/", "%20");
		String fixedUrl = Utilities.checkAndFixUrl(url);
		assertNotEquals(url, fixedUrl);
	}
}