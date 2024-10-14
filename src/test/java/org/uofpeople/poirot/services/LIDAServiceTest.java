package org.uofpeople.poirot.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.uofpeople.poirot.TestUtils;
import org.uofpeople.poirot.dmos.LIPersonDMO;
import org.uofpeople.poirot.repositories.LIRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class LIDAServiceTest {
	@InjectMocks
	private LIDAService lidaService;
	@Mock
	private LIRepository liRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void create() {
		when(liRepository.save(any(LIPersonDMO.class))).thenReturn(TestUtils.createPersonDMO());
		LIPersonDMO result = lidaService.create(TestUtils.createPersonDMO());
		assertNotNull(result);

		// Case 2: id == null
		LIPersonDMO caseTwo = TestUtils.createPersonDMO();
		caseTwo.setId(null);
		result = lidaService.create(caseTwo);
		assertNotNull(result);
	}

	@Test
	void findById() {
		when(liRepository.findById(any(String.class))).thenReturn(Optional.of(TestUtils.createPersonDMO()));
		lidaService.findById(TestUtils.createPersonDMO().getId());
	}

	@Test
	void findAll() {
		when(liRepository.findAll()).thenReturn(Collections.singletonList(TestUtils.createPersonDMO()));
		List<LIPersonDMO> result = lidaService.findAll();
		assertNotNull(result);
	}

	@Test
	void deleteAll() {
		lidaService.deleteAll();
		assertTrue(true);
	}
}