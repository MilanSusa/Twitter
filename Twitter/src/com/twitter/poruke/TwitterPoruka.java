package com.twitter.poruke;

/**
 * Ova klasa predstavlja Twitter poruku nekog korisnika
 * 
 * @author Milan Susa
 * @version V1.1
 */
public class TwitterPoruka {

	/**
	 * Ovaj atribut predstavlja korisnika cija je poruka
	 */
	private String korisnik;

	/**
	 * Ovaj atribut predstavlja poruku korisnika
	 */
	private String poruka;

	/**
	 * Ova metoda vraca korisnika
	 * 
	 * @return korisnik (Vrednost promenljive korisnik)
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Ova metoda postavlja korisnika
	 * 
	 * @param korisnik
	 *            (Obelezava korisnika koji se unosi)
	 * @throws java.lang.RuntimeException
	 *             (Ime korisnika mora biti uneto)
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.isEmpty())
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Ova metoda vraca poruku
	 * 
	 * @return poruka (Vrednost promenjljive poruka)
	 */
	public String getPoruka() {
		return poruka;
	}

	/**
	 * Ova metoda postavlja poruku
	 * 
	 * @param poruka
	 *            (Obelezava poruku koja se unosi)
	 * @throws java.lang.RuntimeException
	 *             (Poruka mora biti uneta i mora imati najvise 140 znakova)
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.isEmpty() || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/**
	 * Ova metoda formatirano vraca korisnika i poruku
	 * 
	 * @return Vrednost promenljivih:
	 *         <ul>
	 *         <li>korisnik</li>
	 *         <li>poruka</li>
	 *         </ul>
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}
