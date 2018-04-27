package be.vdab.services;

import java.math.BigDecimal;
import java.util.List;

import be.vdab.entities.Jobtitel;
import be.vdab.entities.Werknemer;

public interface WerknemerService {
	Werknemer findByChefIsNull();
	Werknemer read(Long id);
	void opslag(Werknemer werknemer, BigDecimal bedrag);
	List<Werknemer> findWerknemersByJobtitel(Jobtitel jobtitel);
}
