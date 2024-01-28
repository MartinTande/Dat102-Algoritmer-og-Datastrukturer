package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

import java.util.Scanner;

public class Tekstgrensesnitt {
	Scanner scanner = new Scanner(System.in);
	// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
	public Film lesFilm(){
		System.out.println("Enter filmnummer: ");
		int filmnr = scanner.nextInt();
		
		System.out.println("Enter produsent: ");
		String produsent = scanner.nextLine();
		
		System.out.println("Enter lanseringsår: ");
		int lanseringsaar = scanner.nextInt();		
		
		System.out.println("Enter tittel: ");
		String tittel = scanner.nextLine();
		
		System.out.println("Enter filmselskap: ");
		String filmselskap = scanner.nextLine();
		
		System.out.println("Enter sjanger: ");
		String sjangerTeskst = scanner.nextLine();
		Sjanger sjanger = Sjanger.valueOf(sjangerTeskst);
		
		Film film = new Film(filmnr, produsent, tittel, lanseringsaar, filmselskap, sjanger);
		return film;
	}
	
	// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void skrivUtFilm(Film film) {
		System.out.println("Film nummer: " + film.getFilmNr());
		System.out.println("Produsent: " + film.getProdusent());
		System.out.println("Tittel: " + film.getTittel());
		System.out.println("Lanseringsår: " + film.getLanseringsAar());
		System.out.println("Filmselskap: " + film.getFilmSelskap());
		System.out.println("Sjanger: " + film.getSjanger().toString());
		System.out.println("-------------------------------------------------------");
	}
	
	// Skriver ut alle filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
		Film[] filmarkiv = arkiv.soekTittel(delstreng);
		for (int i = 0; i < filmarkiv.length; i++) {
			skrivUtFilm(filmarkiv[i]);		
		}
	}
	
	// Skriver ut alle Filmer av en produsent (produsent er delstreng)
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		Film[] filmarkiv = arkiv.soekProdusent(delstreng);
		for (int i = 0; i < filmarkiv.length; i++) {
			skrivUtFilm(filmarkiv[i]);
		}
	}
	
	// Skriver ut en enkel statistikk som inneholder antall filmer totalt
	// og hvor mange det er i hver sjanger.
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		System.out.println("Totalt antall filmer i arkivet: " + arkiv.antall());
		Sjanger[] sjangTab = Sjanger.values();
		for (Sjanger sjanger : sjangTab) {
			System.out.println("Antall filmer i sjanger " + sjanger.toString().toLowerCase() + ": " + arkiv.antall(sjanger));
		}
		System.out.println("-------------------------------------------------------");
	}
	
	public int lesFilmNr() {
		System.out.println("Enter filmnummer: ");
		return scanner.nextInt();
	}
	
	public String lesTittel() {
		System.out.println("Enter tittel delstreng: ");
		return scanner.nextLine();
	}
	
	public String lesProdusent() {
		System.out.println("Enter produsent: ");
		return scanner.nextLine();
	}
	
	public void startTekst() {
		System.out.println("Velkommen til filmarkiv appen!");
		System.out.println("Vennligst velg et av valgene under.");
		System.out.println("-------------------------------------------------------");
	}
	
	public void menyTekst() {
		System.out.println("1: Legg til film");
		System.out.println("2: Slett film");
		System.out.println("3: Skriv ut film");
		System.out.println("4: Skriv ut filmer med gitt tittel delstreng");
		System.out.println("5: Skriv ut filmer med gitt produsent");
		System.out.println("6: Skriv ut filmarkiv statistikk");
		System.out.println("-------------------------------------------------------");
	}
}
