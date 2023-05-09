package it.unibs.fp.tamagotchivan1project;

import static org.junit.Assert.*;

import org.junit.Test;

public class TamaTestMatricole
{
    	// Attenzione, costruttore utilizzato:
	// public Tamagotchi (String nome, int gradoAffettivo, int gradoSazieta)
	
	@Test
	public void dieForZeroSatisfaction() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 0, 50);
		assertTrue(tama.imDead());
	}
	
	@Test
	public void dieForZeroHunger() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 0);
		assertTrue(tama.imDead());
	}
	
	@Test
	public void aliveWhenSatisfactionAndHungerAreGood() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		assertFalse(tama.imDead());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cantInstantiatePetWithNegativeSatisfaction() throws Exception 
	{
		new Tamagotchi("Kira", -10, 50);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cantInstantiatePetWithNegativeHunger() throws Exception 
	{
		new Tamagotchi("Kira", 50, -10);
	}
	
	
	@Test
	public void petCanReceivePets() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		tama.receiveCaresses(1);
		assertFalse(tama.imSad());
	}
	
	@Test
	public void petCanReceiveCookies() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		tama.receiveBiscuits(1);
		assertFalse(tama.imSad());
	}
	
	@Test
	public void petIsUnhappyDueToHunger() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 10);
		assertTrue(tama.imSad());
	}
	
	@Test
	public void petIsUnhappyDueToExtremeRepletion() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 95, 50);
		assertTrue(tama.imSad());
	}
	
	@Test
	public void petIsHappyInTheMidlleOfTheRange() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 50);
		assertFalse(tama.imSad());
	}
	/**
	@Test
	public void petAugmentsItsRepletionAndDiesDueToCookies() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 99);
		tama.receiveBiscuits(10);
		boolean res=tama.imDead();
		assertTrue(res);
	}
	**/
	
	//E' stato creato un nuovo test che rispettasse i parametri di ricezione dei biscotti di un Tamagotchi avanzato
	@Test
	public void petAugmentsItsRepletionAndDiesDueToCookies() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 50, 99.9);
		tama.receiveBiscuits(10);
		boolean res=tama.imDead();
		assertTrue(res);
	}
	
	@Test
	public void petAugmentsItsSatisfactionDueToCaresses() throws Exception 
	{
		final Tamagotchi tama = new Tamagotchi("Kira", 29, 50);
		tama.receiveCaresses(10);
		assertFalse(tama.imSad());
	}

}

