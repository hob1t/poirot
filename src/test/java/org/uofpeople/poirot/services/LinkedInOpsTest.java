package org.uofpeople.poirot.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uofpeople.poirot.dmos.LIPersonDMO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedInOpsTest {
	@InjectMocks
	private LinkedInOps linkedInOps;
	@Mock
	private LIDAService lidaService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void runSearch() {
		linkedInOps.runSearch("Jon Snow");
		assertTrue(true);
	}

	@Test
	void getAllPersons() {
		List<LIPersonDMO> result = linkedInOps.getAllPersons();
		assertNotNull(result);
	}
}