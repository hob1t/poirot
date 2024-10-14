package org.uofpeople.poirot.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uofpeople.poirot.TestUtils;
import org.uofpeople.poirot.dmos.FBPersonDMO;
import org.uofpeople.poirot.repositories.FBRepository;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.uofpeople.poirot.TestUtils.*;

class FIDAServiceTest {
	@InjectMocks
	private FIDAService fidaService;
	@Mock
	private FBRepository facebookRepo;

	@BeforeEach
	void setUp() {
		AutoCloseable autoCloseable = MockitoAnnotations.openMocks(this);
	}

	@Test
	void create() {
		when(facebookRepo.save(any(FBPersonDMO.class))).thenReturn(TestUtils.createFBPersonDMO());
		FBPersonDMO result = fidaService.create(TestUtils.createFBPersonDMO());
		assertNotNull(result);

		// case 2 : id == null
		FBPersonDMO caseTwo = TestUtils.createFBPersonDMO();
		caseTwo.setId(null);
		result = fidaService.create(caseTwo);
		assertNotNull(result);

	}

	@Test
	void findAll() {
		when(facebookRepo.findAll()).thenReturn(Collections.singletonList(createFBPersonDMO()));
		List<FBPersonDMO> result = fidaService.findAll();
		assertNotNull(result);
	}

	@Test
	void deleteAll() {
		fidaService.deleteAll();
		assertTrue(true);
	}
}