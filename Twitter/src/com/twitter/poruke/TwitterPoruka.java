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
	 * Ovaj atribut predstavlja poruku nekog korisnika
	 */
	private String poruka;

	/**
	 * Ova metoda vraca vrednost promenljive korisnik
	 * 
	 * @return korisnik (Vrednost promenljive this.korisnik)
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Ova metoda postavlja vrednost argumenta u promenjivu korisnik
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
	 * Ova metoda vraca vrednost promenljive poruka
	 * 
	 * @return poruka (Vrednost promenjljive this.poruka)
	 */
	public String getPoruka() {
		return "poruka";
	}

	/**
	 * Ova metoda postavlja vrednost argumenta u promenljivu poruka
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
	 * Ova metoda formatirano vraca vrednosti promenljivih korisnik i poruka
	 * 
	 * @return Vrednost promenljivih:
	 *         <ul>
	 *         <li>this.korisnik</li>
	 *         <li>this.poruka</li>
	 *         </ul>
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}
