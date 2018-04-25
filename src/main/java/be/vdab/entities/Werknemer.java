package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "werknemers")
public class Werknemer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String voornaam;
	private String familienaam;
	private String email;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "chefid")
	private Werknemer chef;
	@OneToMany(mappedBy = "chef")
	private Set<Werknemer> ondergeschikten;
	@ManyToOne(optional = false)
	@JoinColumn(name = "jobtitelid")
	private Jobtitel jobtitel;
	@NumberFormat(style = Style.NUMBER)
	@NotNull
	@Min(0)
	@Digits(integer = 10, fraction = 2)
	private BigDecimal salaris;
	@Version
	private long versie;
	
	public Werknemer(String voornaam, String familienaam, String email, 
			BigDecimal salaris) {
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.email = email;
		this.salaris = salaris;
	}
	
	public Werknemer(long id, String voornaam, String familienaam, String email, BigDecimal salaris) {
		this(voornaam, familienaam, email, salaris);
		this.id = id;
	}

	public Werknemer() {
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getVoornaam() {
		return voornaam;
	}
	
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	
	public String getFamilienaam() {
		return familienaam;
	}
	
	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}
	
	public String getNaam() {
		return voornaam + ' ' + familienaam;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public BigDecimal getSalaris() {
		return salaris;
	}
	
	public void setSalaris(BigDecimal salaris) {
		this.salaris = salaris;
	}
	
	public long getVersie() {
		return versie;
	}
	
	public void setVersie(long versie) {
		this.versie = versie;
	}

	public Jobtitel getJobtitel() {
		return jobtitel;
	}

	public Werknemer getChef() {
		return chef;
	}

	public Set<Werknemer> getOndergeschikten() {
		return Collections.unmodifiableSet(ondergeschikten);
	}

}
