package be.vdab.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "jobtitels")
public class Jobtitel implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naam;
	@OneToMany(mappedBy = "jobtitel")
	private Set<Werknemer> werknemers;
	@Version
	private long versie;
	
	public long getId() {
		return id;
	}
	public String getNaam() {
		return naam;
	}
	public Set<Werknemer> getWerknemers() {
		return Collections.unmodifiableSet(werknemers);
	}
	public long getVersie() {
		return versie;
	}
	
	@Override
	public int hashCode() {
		return naam.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Jobtitel)) {
			return false;
		}
		Jobtitel jobtitel = (Jobtitel) obj;
		return naam.equalsIgnoreCase(jobtitel.naam);
	}
	
}
