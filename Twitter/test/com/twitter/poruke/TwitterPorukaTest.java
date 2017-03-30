package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {

	private TwitterPoruka tp;

	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tp.setKorisnik(null);
		assertEquals(java.lang.RuntimeException.class, tp.getKorisnik());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		tp.setKorisnik("");
		assertEquals(java.lang.RuntimeException.class, tp.getKorisnik());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tp.setPoruka(null);
		assertEquals(java.lang.RuntimeException.class, tp.getPoruka());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaPrazanString() {
		tp.setPoruka("");
		assertEquals(java.lang.RuntimeException.class, tp.getPoruka());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaDugacakString() {
		tp.setPoruka("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		assertEquals(java.lang.RuntimeException.class, tp.getPoruka());
	}

	@Test
	public void testToString() {
		tp.setKorisnik("Mita");
		tp.setPoruka("Danas je lep dan");
		assertEquals("KORISNIK:Mita PORUKA:Danas je lep dan", tp.toString());
	}
}
