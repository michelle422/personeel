package be.vdab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Jobtitel;
import be.vdab.entities.Werknemer;

public interface WerknemerRepository extends JpaRepository<Werknemer, Long> {
	
	@EntityGraph("Werknemer.metJobtitel")
	Werknemer findByChefIsNull();
	
	@Override
	@EntityGraph("Werknemer.metJobtitel")
	Werknemer findOne(Long id);
	
	@EntityGraph("Werknemer.metJobtitel")
	List<Werknemer> findWerknemersByJobtitel(Jobtitel jobtitel);
}
