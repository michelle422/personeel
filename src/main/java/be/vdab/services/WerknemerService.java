package be.vdab.services;

import java.util.List;

import be.vdab.entities.Werknemer;

public interface WerknemerService {
	Werknemer findByChefidIsNull();
	void update(Werknemer werknemer);
	String findJobtitel(long id);
	List<Werknemer> findOndergeschikten(long id);
}
