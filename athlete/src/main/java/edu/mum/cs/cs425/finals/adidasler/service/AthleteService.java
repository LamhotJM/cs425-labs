package edu.mum.cs.cs425.finals.adidasler.service;

import java.time.LocalDate;
import java.util.List;

import edu.mum.cs.cs425.finals.adidasler.model.Athlete;

public interface AthleteService {
	public abstract List<Athlete> getAllAthletes();
	public abstract Athlete addAthlete(Athlete athlete);
	public abstract List<Athlete> getElite(LocalDate date);
	public abstract int countEliteAthletes();
}
