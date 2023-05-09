package it.unibs.fp.tamagotchivan1project;

import it.unibs.fp.mylib.InputDati;

/**
 * La seguente classe  serve a ricevere gli input dell'utente per la creazione del Tamagotchi. 
 * @return il Tamagotchi (tama).
 */
public class IOUtil {
	
	private static final String CONDIZIONE_DI_CREAZIONE = "\nIl Tamagotchi non puo' essere istanziato con valori di sazieta' o soddisfazione superiori o uguali a 100\nRicrea un nuovo Tamagotchi";
	private static final String DAI_UN_NOME_AL_TUO_TAMAGOTCHI = "Dai un nome al tuo amico:\n";
	private static final String INSERIRE_IL_VALORE_INIZIALE_DI_SODDISFAZIONE = "Inserire un valore iniziale di soddisfazione:\n";
	private static final String INSERIRE_IL_LIVELLO_INIZIALE_DI_SAZIETA = "Inserire un valore iniziale di sazieta':\n";

	// Il seguente metodo serve a ricevere l'input dell'utente per istanziare il Tamagotchi.	
	public static Tamagotchi createTamagotchi() {
			String name = InputDati.leggiStringaNonVuota(DAI_UN_NOME_AL_TUO_TAMAGOTCHI);
			double affection = InputDati.leggiInteroNonNegativo(INSERIRE_IL_VALORE_INIZIALE_DI_SODDISFAZIONE);
			double satiety = InputDati.leggiInteroNonNegativo(INSERIRE_IL_LIVELLO_INIZIALE_DI_SAZIETA);
			Tamagotchi tama = new Tamagotchi (name, affection, satiety);
			if (tama.imDead( )== true) {
				System.out.println(CONDIZIONE_DI_CREAZIONE);
				return createTamagotchi();
			} else return tama;
		}
}
