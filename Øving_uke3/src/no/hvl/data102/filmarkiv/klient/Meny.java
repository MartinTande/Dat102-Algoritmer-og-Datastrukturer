package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {
	private Tekstgrensesnitt tekstgr; 
	private FilmarkivADT filmarkiv;
	private Scanner scanner = new Scanner(System.in);
	private int userInput;
	
	public Meny(FilmarkivADT filmarkiv){
		tekstgr = new Tekstgrensesnitt(); 
		this.filmarkiv = filmarkiv;
	}
	
	public void start(){
		leggTilStartArkiv();
		tekstgr.startTekst();
		tekstgr.menyTekst();
		
		while (true) {
			userInput = scanner.nextInt();
			switch (userInput) {
				case 1:
					filmarkiv.leggTilFilm(tekstgr.lesFilm());
					break;
				case 2:
					filmarkiv.slettFilm(tekstgr.lesFilmNr());
					break;
				case 3:
					Film film = filmarkiv.finnFilm(tekstgr.lesFilmNr());
					tekstgr.skrivUtFilm(film);
					break;
				case 4:
					tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, tekstgr.lesTittel());
					break;
				case 5:				
					tekstgr.skrivUtFilmProdusent(filmarkiv, tekstgr.lesProdusent());
					break;
				case 6:
					tekstgr.skrivUtStatistikk(filmarkiv);
			}
			tekstgr.menyTekst();
		}
	}
	
	public void leggTilStartArkiv() {
		Film film1 = new Film(1, "Joss Whedon", "The Avengers", 2012, "Marvel Studios", Sjanger.ACTION);
		Film film2 = new Film(2, "Christopher Nolan", "Batman Begins", 2008, "Warner Brothers", Sjanger.ACTION);
		Film film3 = new Film(3, "Morten Tyldum", "The Imitation Game", 2014, "StudioCanal", Sjanger.DRAMA);
		Film film4 = new Film(4, "Sylvester Stallone", "Rocky", 1976, "United Artists", Sjanger.DRAMA);
		Film film5 = new Film(5, "Christopher Nolan", "Dark Knight Rises", 2012, "Warner Brothers", Sjanger.ACTION);
		Film film6 = new Film(6, "James Cameron", "Aliens", 1986, "Brandywine Productions", Sjanger.SCIFI);
		filmarkiv.leggTilFilm(film1);
		filmarkiv.leggTilFilm(film2);
		filmarkiv.leggTilFilm(film3);
		filmarkiv.leggTilFilm(film4);
		filmarkiv.leggTilFilm(film5);
		filmarkiv.leggTilFilm(film6);
	}
}
