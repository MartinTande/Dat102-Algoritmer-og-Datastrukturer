package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {
	private int filmNr;
	private String produsent;
	private String tittel;
	private int lanseringsAar;
	private Sjanger sjanger;
	private String filmSelskap;
	
	public Film() {}
	
	public Film(int filmNr, String produsent, String tittel, int lanseringsAar, String filmSelskap, Sjanger sjanger) {
		this.filmNr = filmNr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lanseringsAar = lanseringsAar;
		this.filmSelskap = filmSelskap;
		this.sjanger = sjanger;
	}
	
	public int getFilmNr() {
		return filmNr;
	}
	
	public void setFilmNr(int filmNr) {
		this.filmNr = filmNr;
	}
	
	public String getProdusent() {
		return produsent;
	}
	
	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}
	
	public String getTittel() {
		return tittel;
	}
	
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	
	public int getLanseringsAar() {
		return lanseringsAar;
	}
	
	public void setLanseringsAar(int lanseringsAar) {
		this.lanseringsAar = lanseringsAar;
	}
	
	public String getFilmSelskap() {
		return filmSelskap;
	}
	
	public void setFilmSelskap(String filmSelskap) {
		this.filmSelskap = filmSelskap;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmNr);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return filmNr == other.filmNr;
	}
}
