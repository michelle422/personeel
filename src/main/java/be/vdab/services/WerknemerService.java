package be.vdab.services;

import java.util.Optional;

import be.vdab.entities.Werknemer;

public interface WerknemerService {
	Werknemer findByChefIsNull();
	Optional<Werknemer> read(Long id);
	void update(Werknemer werknemer);
}
