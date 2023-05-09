package it.unibs.fp.tamagotchivan1project;

import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.NumeriCasuali;

/**
 * 
 * Il programma prevede che l'utente crei un Tamagotchi e lo accudisca dandogli da mangiare e facendo carezze.
 * @author Benedetta Anglani, Ruggero Lombardi, Federico Carlo Schettino
 *
 */


public class mainTamagotchi {

	private static final String SALUTI_FINALI = "Grazie e arrivederci";
	private static final int MAX_10 = 10;
	private static final int MIN_1 = 1;
	private static final String IL_TAMAGOTCHI_E_MORTO = "\n\nIl Tamagotchi e' morto per crearne uno nuovo riavviare il programma";
	private static final String SELEZIONA_UN_OPZIONE_VALIDA = "Seleziona un'opzione valida!";
	private static final String SALUTO = "Buongiorno, crea il tuo Tamagotchi";
	private static final String[] VOCI_MENU = new String[] {"Dai carezze", "Dai biscotti"};
	private static final String MENU_TAMAGOTCHI = "Menu tamagotchi";
	
	public static void main(String[] args) {
		
		System.out.println(SALUTO);
		
		Tamagotchi tama = IOUtil.createTamagotchi();
		
		// Il seguente costruttore crea un menu' di interazione per l'utente e permette di scegliere se fare carezze o dare biscotti
		MyMenu menu = new MyMenu(MENU_TAMAGOTCHI, VOCI_MENU);
			boolean finish = false;
			do {
				int choice = menu.scegli();
				switch(choice) {
					case 1:
						tama.receiveCaresses(NumeriCasuali.estraiIntero(MIN_1, MAX_10));
						System.out.println(tama);
						if (tama.imDead()==true) {
							System.out.println(IL_TAMAGOTCHI_E_MORTO);
							System.exit(0);
						}else break;
					case 2:
						tama.receiveBiscuits(NumeriCasuali.estraiIntero(MIN_1, MAX_10));
						System.out.println(tama);
						if (tama.imDead()==true) {
							System.out.println(IL_TAMAGOTCHI_E_MORTO);
							System.exit(0);
						}else break;
					case 0:
						finish = true;
						break;
					default:
						System.out.println(SELEZIONA_UN_OPZIONE_VALIDA);
				}
			} while (!finish);
			System.out.println(SALUTI_FINALI);
			}
}
