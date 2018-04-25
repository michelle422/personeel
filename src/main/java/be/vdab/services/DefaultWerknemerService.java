package be.vdab.services;

import java.util.List;

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

	@Override
	public String findJobtitel(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Werknemer> findOndergeschikten(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
