package be.vdab.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Jobtitel;

public interface JobtitelRepository extends JpaRepository<Jobtitel, Long> {

	@Override
	List<Jobtitel> findAll();
}
