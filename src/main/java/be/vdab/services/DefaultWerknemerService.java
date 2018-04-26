package be.vdab.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import be.vdab.entities.Werknemer;
import be.vdab.repositories.WerknemerRepository;

@Service
@ReadOnlyTransactionalService
class DefaultWerknemerService implements WerknemerService {
	private final WerknemerRepository werknemerRepository;

	public DefaultWerknemerService(WerknemerRepository werknemerRepository) {
		this.werknemerRepository = werknemerRepository;
	}

	@Override
	public Werknemer findByChefIsNull() {
		return werknemerRepository.findByChefIsNull();
	}

	@Override
	public Optional<Werknemer> read(Long id) {
		return Optional.ofNullable(werknemerRepository.findOne(id));
	}
	
	@Override
	@ModifyingTransactionalServiceMethod
	public void update(Werknemer werknemer) {
		werknemerRepository.save(werknemer);	
	}
	
}
