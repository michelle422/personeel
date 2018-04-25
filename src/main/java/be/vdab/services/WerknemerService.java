package be.vdab.services;

import be.vdab.entities.Werknemer;

public interface WerknemerService {
	Werknemer findByChefidIsNull();
	void update(Werknemer werknemer);
}
