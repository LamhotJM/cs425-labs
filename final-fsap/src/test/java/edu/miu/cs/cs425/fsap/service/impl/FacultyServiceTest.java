package edu.miu.cs.cs425.fsap.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import edu.miu.cs.cs425.fsap.model.Faculty;
import edu.miu.cs.cs425.fsap.repository.FacultyRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class FacultyServiceTest {

	@Mock
	private FacultyServiceImpl athleteImp;

	@Mock
	private FacultyRepository athleteRepository = mock(FacultyRepository.class);

	@Before
	public void setUp() {
		this.athleteImp = new FacultyServiceImpl(athleteRepository);
	}

	@After
	public void tearDown() throws Exception {
		this.athleteImp = null;
	}

	@Test
	public void test() {
		List<Faculty> athelets = Arrays.asList(
				new Faculty("1", "001", "lamhot@gmail.com", "111", "111", "mac")
			);
		Mockito.doReturn(athelets).when(athleteRepository).findAll();
		int actual = athleteImp.getAllFaculties().size();
		int expected = 0;
		assertEquals(expected,  actual);
	}

}
