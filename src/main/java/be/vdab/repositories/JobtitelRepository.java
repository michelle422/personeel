package be.vdab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Jobtitel;
import be.vdab.entities.Werknemer;

public interface JobtitelRepository extends JpaRepository<Jobtitel, Long> {

	@Override
	List<Jobtitel> findAll();
	
	@EntityGraph("Werknemer.metJobtitel")
	List<Werknemer> findWerknemersByJobtitel();
}
