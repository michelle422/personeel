package be.vdab.repositories;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import be.vdab.entities.Werknemer;

@Repository
class DefaultWerknemerRepository implements WerknemerRepository {

	@Override
	public void updateSalaris(BigDecimal salaris) {
		werknemer.setSalaris(salaris);
	}
	
}
