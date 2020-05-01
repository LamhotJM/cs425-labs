package edu.mum.cs.cs425.finals.adidasler.serviceimp;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs425.finals.adidasler.service.AthleteService;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class AthleteServiceImpTest {

	@Autowired
	private AthleteService athleteService;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//test number of elites		 
	     
	     int actual = athleteService.countEliteAthletes();
	     int expected = 2;
	     assertEquals((long)expected, (long)actual);
	}

}
