package edu.mum.cs.cs425.finals.adidasler.serviceimp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import edu.mum.cs.cs425.finals.adidasler.model.Athlete;
import edu.mum.cs.cs425.finals.adidasler.repository.AthleteRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class AthleteServiceTest {

	@Mock
	private AthleteServiceImp athleteImp;

	@Mock
	private AthleteRepository athleteRepository = mock(AthleteRepository.class);

	@Before
	public void setUp() {
		this.athleteImp = new AthleteServiceImp(athleteRepository);
	}

	@After
	public void tearDown() throws Exception {
		this.athleteImp = null;
	}

	@Test
	public void test() {
		List<Athlete> athelets = Arrays.asList(
				new Athlete(21474836491L, "978-0000000001", "lamhot siagian", "082369", LocalDate.of(2011, 9, 13),
						LocalDate.of(2020, 3, 16), 2, 5.8, "bola@gmail.com"),

				new Athlete(2147483649L, "978-0000000001", "lamhot siagian", "082369", LocalDate.of(2011, 9, 13),
						LocalDate.of(2020, 3, 16), 2, 5.8, "bola@gmail.com"));
		Mockito.doReturn(athelets).when(athleteRepository).findElites(LocalDate.of(2020, 3, 16));
		int actual = athleteImp.countEliteAthletes();
		int expected = 2;
		assertEquals((long) expected, (long) actual);
	}

}
