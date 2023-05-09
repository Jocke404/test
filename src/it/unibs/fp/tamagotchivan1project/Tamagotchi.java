package it.unibs.fp.tamagotchivan1project;

/**
 * La seguente serve a gestire il Tamagotchi.
 * @param name Nome che l'utente decide di dare al Tamagothci
 * @param affection Valore di affetto del Tamagotchi
 * @param satiety Valore di sazieta' del Tamagotchi
 */

public class Tamagotchi {
	private static final int MAX_HAP_SATIETY = 55;
	private static final int MIN_HAP_SATIETY = 45;
	private static final int MAX_HAP_AFFECTION = 55;
	private static final int MIN_HAP_AFFECTION = 45;
	private static final int MAX_SAD_AFFECTION = 99;
	private static final int MIN_SAD_AFFECTION = 95;
	private static final int MAX_SAD_SATIETY = 20;
	private static final int MIN_SAD_SATIETY = 1;
	private static final int SOGLIA_MIN_FELICITA = 50;
	private static final double CARESSES_INCREASE_FACTOR = 1.5;
	private static final int SOGLIA_MAX = 100;
	private static final int SOGLIA_MIN = 0;
	private static final int BISCUIT_FACTOR_AFFECTION = 4;
	private static final double BISCUIT_FACTOR = 0.1;
	private static final int CARESSES_FACTOR = 2;
	private static final double BISCUIT_DECREASE_FACTOR = 0.01;
	private String name;
	private double satiety;
	private double affection;
	
	public Tamagotchi(String _name, double _affection, double _satiety) {
		this.name = _name;
		this.satiety = _satiety;
		this.affection = _affection;
	}
	// Il seguente metodo serve a fare le carezze modificando la sazieta' e l'affetto in base al mood precedente del Tamagotchi.
	void receiveCaresses(int numCaresses) {
		if(affection <= SOGLIA_MAX) {
		affection += numCaresses;
		satiety -= (numCaresses/CARESSES_FACTOR);
		} else {
			affection += numCaresses/CARESSES_FACTOR;
			satiety -= numCaresses*CARESSES_INCREASE_FACTOR;
		}
	}
	// Il seguente metodo serve a dare biscotti modificando la sazieta' e l'affetto in base al mood precedente del Tamagotchi.
	void receiveBiscuits(int numBiscuit) {
		if(satiety <= SOGLIA_MIN_FELICITA) {
		for(int i=SOGLIA_MIN; i < numBiscuit; i++) {
			satiety += numBiscuit*BISCUIT_FACTOR;
		}
		affection -= Math.max(SOGLIA_MIN, numBiscuit - numBiscuit/BISCUIT_FACTOR_AFFECTION);
		} else {
			for(int i=SOGLIA_MIN; i < numBiscuit; i++) {
				satiety += numBiscuit*BISCUIT_DECREASE_FACTOR;
			}
			affection -= Math.max(SOGLIA_MIN, numBiscuit - numBiscuit/CARESSES_FACTOR);
		}
	}

	public double getAffection() {
		return affection;
	}
	
	public void setAffection(double affection) {
		this.affection = affection;
	}

	public double getSatiety() {
		return satiety;
	}

	public void setSatiety(double satiety) {
		this.satiety = satiety;
	}
	// Il seguente metodo serve a definire i parametri di sazieta' e affetto per cui il Tamagotchi muore.
	public boolean imDead() {
		return(satiety <= SOGLIA_MIN || satiety >= SOGLIA_MAX || affection <= SOGLIA_MIN || affection >= SOGLIA_MAX);
	 }
	// Il seguente metodo serve a definire i parametri di sazieta' e affetto per cui il Tamagotchi e' triste.
	public boolean imSad() {
		if (satiety >= MIN_SAD_SATIETY && satiety <= MAX_SAD_SATIETY || affection >= MIN_SAD_AFFECTION && affection <= MAX_SAD_AFFECTION) {
			return true;
		} else {
			return false;
		}
	}
	// Il seguente metodo serve a definire i parametri di sazieta' e affetto per cui il Tamagotchi e' felice.
	public boolean imHappy() {
		if (affection >= MIN_HAP_AFFECTION && affection <= MAX_HAP_AFFECTION && satiety >= MIN_HAP_SATIETY && satiety <= MAX_HAP_SATIETY) {
			return true;
		} else return false;
	}
	// Il seguente metodo serve a definire i parametri di sazieta' e affetto per cui il Tamagotchi e' in uno stato di normalita'.
	public boolean imFine() {
		if (!imHappy() == true && !imSad() == true && !imDead() == true) {
			return true;
		} else return false;
	}
	
	// Il seguente metodo serve a visualizzare lo stato del Tamagotchi dopo ogni interazione  da parte dell'utente e restituisce anche il mood del Tamagotchi.
	public String toString() {
		StringBuffer description = new StringBuffer();
		description.append("\nNome: " +name);
		description.append("\nSazieta': " +satiety);
		description.append("\nSoddisfazione: " +affection);
	
		if (imSad()) {
			description.append("\nSono Triste!!");
		}
		
		if (imHappy()) {
			description.append("\nSono Felice!!!!!");
		}
		
		if (imDead()) {
			description.append("\nIl Tamagotchi e' morto!");	
		}
		
		if (imFine()) {
			description.append("\nSto bene adesso!!!");
		}
		return description.toString();
	}
}
