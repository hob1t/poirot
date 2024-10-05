package org.uofpeople.poirot.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uofpeople.poirot.TestUtils;
import org.uofpeople.poirot.dmos.FBPersonDMO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.uofpeople.poirot.TestUtils.STR_LEN;

/**
 * Tests {@link FBOps} operations.
 */
class FBOpsTest {
	@InjectMocks
	private FBOps fbOps;
	@Mock
	private FIDAService fidaService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void runSearch() {
		String searchQuery = RandomStringUtils.randomAlphabetic(STR_LEN) + " "
				+ RandomStringUtils.randomAlphabetic(STR_LEN);

		fbOps.runSearch(searchQuery);
		assertTrue(true);
	}

	@Test
	void getAllPersons() {
		when(fidaService.findAll()).thenReturn(List.of(new FBPersonDMO()));
		List<FBPersonDMO> result = fbOps.getAllPersons();
		assertNotNull(result);
	}
}