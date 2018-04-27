package be.vdab.services;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

import be.vdab.entities.Jobtitel;
import be.vdab.entities.Werknemer;
import be.vdab.repositories.WerknemerRepository;

@Service
@ReadOnlyTransactionalService
class DefaultWerknemerService implements WerknemerService {
	private final WerknemerRepository werknemerRepository;

	DefaultWerknemerService(WerknemerRepository werknemerRepository) {
		this.werknemerRepository = werknemerRepository;
	}

	@Override
	public Werknemer findByChefIsNull() {
		return werknemerRepository.findByChefIsNull();
	}

	@Override
	public Werknemer read(Long id) {
		return werknemerRepository.findOne(id);
	}
	
	@Override
	@ModifyingTransactionalServiceMethod
	public void opslag(Werknemer werknemer, BigDecimal bedrag) {
		werknemer.opslag(bedrag);
	}
	
	@Override
	public List<Werknemer> findWerknemersByJobtitel(Jobtitel jobtitel) {
		return werknemerRepository.findWerknemersByJobtitel(jobtitel);
	}
	
}
