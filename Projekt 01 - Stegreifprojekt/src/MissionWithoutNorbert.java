
public class MissionWithoutNorbert {
	public static void main (String[] args) {
		
		// Variablen
		char norbert = 'O';
		int compNorbert = 0;
		int spielerNorbert = 0;
		
		long minionsRechts = 0;
		int minionsLinks = 10;
		int leereMinionsRechts = 0;
		int leereMinionsLinks = 0;
		
		double randomMinionWert;
		double randomAnfangsWert;
		
		long anfangsWert;
		
		char seitenWahl;
		int minionsWahl;
		
		// Random Minion Wert wird erstellt und wer anfängt
		randomMinionWert = Math.random();
		randomAnfangsWert = Math.random();
		
		randomMinionWert *= 10;
		randomMinionWert++;
		
		minionsRechts = Math.round(randomMinionWert);
		anfangsWert = Math.round(randomAnfangsWert);
		
		minionsLinks -= minionsRechts;
		
		// Spielfeld wird geprinted
		if (anfangsWert == 1) {
			System.out.println("So sieht das aktuelle Spielfeld aus:");
			
			for (int i = 0; i < minionsLinks; i++) {
				System.out.print("M ");
			}
			
			System.out.print(norbert);
			
			for (int i = 0; i < minionsRechts; i++) {
				System.out.print(" M");
			}
			System.out.println("");
		}
		
		// Wiederholung des Spieles bis Norbert ausgewählt wird
		while (minionsLinks > 0 || minionsRechts > 0) {
			
			// Computer ist dran und sein Spielmechanismus
			if (anfangsWert == 1) {
				
				System.out.println("");
				
				// Computer Algorithmus für Spielentscheidung
				if (minionsRechts >= minionsLinks) {
					switch((int)minionsRechts)  {
					case 1:
						minionsRechts--;
						System.out.println("Computer nimmt 1 von Rechts");
						leereMinionsRechts += 1;
						break;
					case 2:
						minionsRechts -= 2;
						System.out.println("Computer nimmt 2 von Rechts");
						leereMinionsRechts += 2;
						break;
					default:
						minionsRechts -=3;
						System.out.println("Computer nimmt 3 von Rechts");
						leereMinionsRechts += 3;
						break;
					}
				} else if (minionsLinks > minionsRechts){
					switch(minionsLinks)  {
					case 1:
						minionsLinks--;
						System.out.println("Computer nimmt 1 von Links");
						leereMinionsLinks += 1;
						break;
					case 2:
						minionsLinks -= 2;
						System.out.println("Computer nimmt 2 von Links");
						leereMinionsLinks += 2;
						break;
					default:
						minionsLinks -=3;
						System.out.println("Computer nimmt 3 von Links");
						leereMinionsLinks += 3;
						break;
					}
				} 
				
				System.out.println("");
				
				// Hat jemand Norbert gezogen? Wer hat gewonnen/verloren?
				if (minionsRechts == 0 && minionsLinks == 0) {
					spielerNorbert = 1;
				} else if (minionsRechts < 0 || minionsLinks < 0) {
					minionsRechts = 0;
					minionsLinks = 0;
					
					compNorbert = 1;
				}
				
				if (compNorbert == 0) {
					anfangsWert = 0;
				}
				
			}
			
			// Spieler Spielmechanismus
			if (anfangsWert == 0) {
				
				// Spieler ist dran. Aktuelles Spielfeld wird geprinted.
				System.out.println("Du bist am Zug.");
				System.out.println("So sieht das aktuelle Spielfeld aus:");
				
				for (int i = 0; i < leereMinionsLinks; i++) {
					System.out.print("- ");
				}
				
				for (int i = 0; i < minionsLinks; i++) {
					System.out.print("M ");
				}
				
				System.out.print(norbert);
				
				for (int i = 0; i < minionsRechts; i++) {
					System.out.print(" M");
				}
				
				for (int i = 0; i < leereMinionsRechts; i++) {
					System.out.print(" -");
				}
				System.out.println("");
				
				// Spieler entscheidet über seinen Zug
				System.out.println("Von welcher Seite - l)inks oder r)rechts - willst du wählen?)");
				
				seitenWahl = StaticScanner.nextChar();
				
				System.out.println("Wie viele Minions sollen in dein Team? (1 - 3 Minions auswählen)");
				minionsWahl = StaticScanner.nextInt();
				
				if (minionsWahl > 3 || minionsWahl < 1) {
					System.out.println("Eingabefehler!");
					System.out.println("Wie viele Minions sollen in dein Team? (1 - 3 Minions auswählen)");
					minionsWahl = StaticScanner.nextInt();
				}
				
				// Eingabe vom Spieler wird verarbeitet
				switch (seitenWahl) {
				case 'r':
					minionsRechts -= minionsWahl;
					leereMinionsRechts += minionsWahl;
					break;
				case 'l':
					minionsLinks -= minionsWahl;
					leereMinionsLinks += minionsWahl;
					break;
				default:
					System.out.println("bitte wähle von r und l");
					break;
				}
				
				// Hat jemand Norbert gezogen? Wer hat gewonnen/verloren?
				if (minionsRechts == 0 && minionsLinks == 0) {
					compNorbert = 1;
				} else if (minionsRechts < 0 || minionsLinks < 0) {
					minionsRechts = 0;
					minionsLinks = 0;
					
					spielerNorbert = 1;
				}
				
				anfangsWert = 1;
				
				System.out.println("");
				
			}
			
		}
		
		// Wer hat das Spiel verloren?
		if (spielerNorbert == 1) {
			System.out.println("Spieler hat Norbert und darum verloren");
		} else if (compNorbert == 1) {
			System.out.println("Computer hat Norbert und darum veloren");
		}
		
	}
	
}
