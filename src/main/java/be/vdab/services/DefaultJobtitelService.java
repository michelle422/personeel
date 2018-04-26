package be.vdab.services;

import java.util.List;

import org.springframework.stereotype.Service;

import be.vdab.entities.Jobtitel;
import be.vdab.entities.Werknemer;
import be.vdab.repositories.JobtitelRepository;

@Service
@ReadOnlyTransactionalService
class DefaultJobtitelService implements JobtitelService {
	private final JobtitelRepository jobtitelRepository;

	
	DefaultJobtitelService(JobtitelRepository jobtitelRepository) {
		this.jobtitelRepository = jobtitelRepository;
	}

	@Override
	public List<Werknemer> findWerknemersByJobtitel() {
		return jobtitelRepository.findWerknemersByJobtitel();
	}

	@Override
	public List<Jobtitel> findAll() {
		return jobtitelRepository.findAll();
	}

}
