package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Ova klasa predstavlja Twitter servis
 * 
 * @author Milan Susa
 * @version V1.1
 */
public class Twitter {

	/**
	 * Ovaj atribut predstavlja sve poruke na Twitteru
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Ova metoda vraca sve poruke na Twitteru
	 * 
	 * @return poruke (Lista svih poruka)
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * Ova metoda unosi poruku ciji je autor korisnik u listu poruka
	 * 
	 * @param korisnik
	 *            (Obelezava korisnika koji se unosi)
	 * @param poruka
	 *            (Obelezava poruku koja se unosi)
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}

	/**
	 * Ova metoda vraca listu odredjenog broja poruka sa odredjenim tagom
	 * 
	 * @param maxBroj
	 *            (Obelezava maksimalni broj poruka koji treba da se vrati)
	 * @param tag
	 *            (Obelezava identifikator za nalazenje zeljenih poruka)
	 * @return rezultat (Lista odredjenog broja poruka sa odredjenim tagom)
	 * @throws java.lang.RuntimeException
	 *             (Tag mora biti unesen)
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++) {
			if (poruke.get(i).getPoruka().indexOf(tag) != -1) {
				if (brojac < maxBroj) {
					rezultat[brojac] = poruke.get(i);
					brojac++;
				} else {
					break;
				}
			}
		}
		return rezultat;
	}
}