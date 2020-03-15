package fi.hh.projekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Projekti {
	
	// Tietokanta luo automaattisesti uniikin ID numeron
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String tuote, maara, hinta;


		
	
	// Konstruktorit
	
	public Projekti() {	}
	
	public Projekti(String tuote, String maara, String hinta) {
		super();
		this.tuote = tuote;
		this.maara = maara;
		this.hinta = hinta;
	}
	
	
	// Getterit ja Setterit
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTuote() {
		return tuote;
	}

	public void setTuote(String tuote) {
		this.tuote = tuote;
	}

	public String getMaara() {
		return maara;
	}

	public void setMaara(String maara) {
		this.maara = maara;
	}

	public String getHinta() {
		return hinta;
	}

	public void setHinta(String hinta) {
		this.hinta = hinta;
	}


	@Override
	public String toString() {

			return "Projekti [id=" + id + ", tuote=" + tuote + ", maara=" + maara + ", hinta=" + hinta + "]";
	}

	
	
}
