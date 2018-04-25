package be.vdab.services;

import be.vdab.entities.Werknemer;
import be.vdab.repositories.WerknemerRepository;

class DefaultWerknemerService implements WerknemerService {
	private final WerknemerRepository werknemerRepository;

	public DefaultWerknemerService(WerknemerRepository werknemerRepository) {
		this.werknemerRepository = werknemerRepository;
	}

	@Override
	public Werknemer findByChefidIsNull() {
		return werknemerRepository.findByChefidIsNull();
	}

	@Override
	public void update(Werknemer werknemer) {
		werknemerRepository.save(werknemer);	
	}
	
}
