package be.vdab.services;

import java.util.List;

import be.vdab.entities.Jobtitel;
import be.vdab.entities.Werknemer;

public interface JobtitelService {
	List<Jobtitel> findAll();
	List<Werknemer> findWerknemersByJobtitel();
}
