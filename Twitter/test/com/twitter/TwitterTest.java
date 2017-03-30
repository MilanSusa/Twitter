package com.twitter;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	private Twitter t;
	private LinkedList<TwitterPoruka> poruke;
	private TwitterPoruka tp;
	private TwitterPoruka[] tagovanePoruke;

	@Before
	public void setUp() throws Exception {
		t = new Twitter();
		poruke = new LinkedList<>();
		tp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVratiSvePoruke() {
		tp.setKorisnik("Mita");
		tp.setPoruka("Danas je lep dan");
		poruke.addLast(tp);
		t.unesi("Mita", "Danas je lep dan");
		assertEquals(poruke.toString(), t.vratiSvePoruke().toString());
	}

	@Test
	public void testUnesi() {
		tp.setKorisnik("Mita");
		tp.setPoruka("Danas je lep dan");
		poruke.add(tp);
		t.unesi("Mita", "Danas je lep dan");
		assertEquals(poruke.getLast().toString(), t.vratiSvePoruke().getLast().toString());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiNullKorisnik() {
		t.unesi(null, "Danas je lep dan");
		assertEquals(java.lang.RuntimeException.class, t.vratiSvePoruke().getLast().toString());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiPrazanStringKorisnik() {
		t.unesi("", "Danas je lep dan");
		assertEquals(java.lang.RuntimeException.class, t.vratiSvePoruke().getLast().toString());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiNullPoruka() {
		t.unesi("Mita", null);
		assertEquals(java.lang.RuntimeException.class, t.vratiSvePoruke().getLast().toString());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiPrazanStringpPoruka() {
		t.unesi("Mita", "");
		assertEquals(java.lang.RuntimeException.class, t.vratiSvePoruke().getLast().toString());
	}

	@Test
	public void testVratiPoruke() {
		tagovanePoruke = new TwitterPoruka[3];
		TwitterPoruka tp1 = new TwitterPoruka();
		TwitterPoruka tp2 = new TwitterPoruka();
		TwitterPoruka tp3 = new TwitterPoruka();
		tp1.setKorisnik("Mika");
		tp1.setPoruka("Danas je lep dan");
		tp2.setKorisnik("Pera");
		tp2.setPoruka("Danas je suncan dan");
		tp3.setKorisnik("Zika");
		tp3.setPoruka("Danas je vedar dan");
		tagovanePoruke[0] = tp1;
		tagovanePoruke[1] = tp2;
		tagovanePoruke[2] = tp3;
		t.unesi("Mika", "Danas je lep dan");
		t.unesi("Pera", "Danas je suncan dan");
		t.unesi("Zika", "Danas je vedar dan");
		assertEquals(Arrays.toString(tagovanePoruke), Arrays.toString(t.vratiPoruke(3, "Danas")));
	}
}
