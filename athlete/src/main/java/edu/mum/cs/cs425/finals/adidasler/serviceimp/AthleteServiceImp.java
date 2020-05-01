package edu.mum.cs.cs425.finals.adidasler.serviceimp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.finals.adidasler.repository.AthleteRepository;
import edu.mum.cs.cs425.finals.adidasler.service.AthleteService;
import edu.mum.cs.cs425.finals.adidasler.model.Athlete;

@Service
public class AthleteServiceImp implements AthleteService{

	private AthleteRepository repo;
	
	public AthleteServiceImp(AthleteRepository repo) {
		super();
		this.repo = repo;
	}


	@Override
	public List<Athlete> getAllAthletes() {
		return repo.findAll(Sort.by("fullName"));
	}
	
	@Override
	public Athlete addAthlete(Athlete athlete) {
		return repo.save(athlete);
	}

	@Override
	public List<Athlete> getElite(LocalDate date) {
		return repo.findElites(date);
	}

	@Override
	public int countEliteAthletes() {
		String date = "2020-03-16";		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		
		return repo.findElites(localDate).size();
	}

}
