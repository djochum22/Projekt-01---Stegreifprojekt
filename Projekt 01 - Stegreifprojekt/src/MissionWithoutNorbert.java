public class MissionWithoutNorbert {
	public static void main (String[] args) {
		//Konstante Variablen
		final char NORBERT = 'O';
		final int MINIONS_ANZAHL = 10;
		final int MINIONS_UND_NORBERT = 11;
	
		// Variablen
		boolean spielerZug = false;
		boolean compNorbert = false;
		boolean spielerNorbert = false;
		
		int minionsRechts = 0;
		int minionsLinks = 0;
		int norbertPosition = 0;
		
		int spielerTeam = 0;
		int computerTeam = 0;
		
		char seitenWahl;
		int minionsWahl;
		
		char antwort;
		
		// Spiel Tutorial für neue Spieler
		do {
			System.out.println("Hallo, möchtest du eine kleine Erklärung des Spiels? Tippe 'y' für die Erklärung oder 'n' um das Spiel zu starten!");
			antwort = StaticScanner.nextChar();
		} while (!(antwort == 'y' || antwort == 'n'));
		
		if (antwort == 'y') {
			System.out.println("In diesem Spiel geht es darum, ein Team aus Minions zusammenzustellen "
					+ "– allerdings mit einer entscheidenden");
			System.out.println("");
			System.out.println("Regeln: Niemand will Norbert in seinem Team haben, denn er ist bekannt dafür, alles durcheinanderzubringen!");
		
			System.out.println("So funktioniert das Spiel: ");
			System.out.println("Start: Zu Beginn wird Norbert zufällig in eine Gruppe von 10 Minions platziert.");
			System.out.println("");
			System.out.println("Auswahl: Sie und der Computer wählen abwechselnd Minions aus, die in Ihr Team kommen. Dabei können Sie entscheiden, ");
			System.out.println("ob Sie Minions links oder rechts von Norbert nehmen möchten, und wie viele (1, 2 oder 3)");
			System.out.println("");
			System.out.println("Es muss mindestens ein Minion ausgewählt werden – auch wenn es Norbert ist!");
			System.out.println("");
			System.out.println("Ziel: Die Auswahl endet, wenn alle Minions verteilt sind. Wer am Ende Norbert im Team hat, verliert.");
			System.out.println("");
		}
		
		// Random Minion Wert wird erstellt und wer anfängt
		if (Math.random() < 0.5) spielerZug = true;
		
		minionsRechts = (int)((Math.random() * MINIONS_ANZAHL) + 1);
		
		minionsLinks = MINIONS_ANZAHL - minionsRechts;
		
		norbertPosition = minionsLinks + 1;
		
		System.out.println("");
		
		// Spielfeld wird geprinted
		if (!spielerZug) {
			reiheAusgabe(norbertPosition, minionsLinks, minionsRechts, NORBERT, MINIONS_UND_NORBERT);
		}
		
		// Wiederholung des Spieles bis Norbert ausgewählt wird 
		do {
			
			// Computer ist dran und sein Spielmechanismus
			if (!spielerZug) {
				
				System.out.println("");
				System.out.println("Computer ist dran");
				System.out.println("");
				
				// Computer Algorithmus für Spielentscheidung
				if (minionsRechts >= minionsLinks) {
					if (minionsRechts < 3) {
						System.out.println("Computer nimmt " + minionsRechts + " von Rechts");
						computerTeam += minionsRechts;
						minionsRechts = 0;
					} else {
						minionsRechts -= 3;
						computerTeam += 3;
						System.out.println("Computer nimmt 3 von Rechts");
					}
					
				} else if (minionsRechts < minionsLinks) {
					if (minionsLinks < 3) {
						System.out.println("Computer nimmt " + minionsLinks + " von Links");
						computerTeam += minionsLinks;
						minionsLinks = 0;
					} else {
						minionsLinks -= 3;
						computerTeam += 3;
						System.out.println("Computer nimmt 3 von Links");
					}
					
				} 
				
				System.out.println("");
				
				// Gibt es noch Minions zur Auswahl/ Ansonsten Spieler ist dran
				if (minionsRechts == 0 && minionsLinks == 0) 
					spielerNorbert = true;
				else
					spielerZug = true;
			}
			
			// Spieler Spielmechanismus
			if (spielerZug) {
				
				// Spieler ist dran. Aktuelles Spielfeld wird geprinted.
				System.out.println("Du bist am Zug");
				System.out.println("");
				
				reiheAusgabe(norbertPosition, minionsLinks, minionsRechts, NORBERT, MINIONS_UND_NORBERT);
				
				System.out.println("");
				
				// Spieler entscheidet über seinen Zug
				do {
					System.out.println("Von welcher Seite - l)inks oder r)echts - willst du wählen?");
					seitenWahl = StaticScanner.nextChar();
				} while (!(seitenWahl == 'r' || seitenWahl == 'l'));
				
				do {
					System.out.println("Wie viele Minions sollen in dein Team? (1 - 3 Minions auswählen)");
					minionsWahl = StaticScanner.nextInt();
				} while (!(1 <= minionsWahl && minionsWahl <= 3));
				
				spielerTeam += minionsWahl;
				
				// Eingabe vom Spieler wird verarbeitet
				switch (seitenWahl) {
				case 'r':
					minionsRechts -= minionsWahl;
					
					if (minionsRechts < 0) spielerTeam += minionsRechts;
					
					break;
				case 'l':
					minionsLinks -= minionsWahl;
					
					if (minionsLinks < 0) spielerTeam += minionsLinks;
					
					break;
				}
				
				// Gibt es noch Minions zur Auswahl/ Hat der Spieler Norbert gezogen/ Ansonsten Computer ist dran
				if (minionsRechts == 0 && minionsLinks == 0) 
					compNorbert = true;
				else if (minionsRechts < 0 || minionsLinks < 0)
					spielerNorbert = true;
				else 
					spielerZug = false;
			
				System.out.println("");
			}
			
			System.out.println("Du hast " + spielerTeam + " Minions in deinem Team");
			System.out.println("Der Computer hat " + computerTeam + " in seinem Team");
			System.out.println("");
		} while (!(spielerNorbert == true || compNorbert == true));
		
		// Wer hat das Spiel verloren?
		if (spielerNorbert == true) {
			System.out.println("Du hast Norbert gezogen: Spiel verloren :(");
		} else if (compNorbert == true) {
			System.out.println("Computer hat Norbert gezogen und darum veloren!");
			System.out.println("Du hast gewonnen! :)");
		}
		
	} 
	
	public static void reiheAusgabe (int norbertPosition, int minionsLinks, int minionsRechts, final char NORBERT, final int MINIONS_UND_NORBERT) {
		System.out.println("So sieht das aktuelle Spielfeld aus:");
		
		final int LEERE_MINIONS_LINKS = norbertPosition - (minionsLinks + 1);
		
		for (int i = 1; i <= MINIONS_UND_NORBERT; i++) {
			if (i <= LEERE_MINIONS_LINKS) 
				System.out.print("- ");
			else if (i <= minionsLinks + LEERE_MINIONS_LINKS && i > LEERE_MINIONS_LINKS) 
				System.out.print("M ");
			else if (i == norbertPosition) 
				System.out.print(NORBERT);
			else if (i <= (minionsRechts + norbertPosition) && i > norbertPosition) 
				System.out.print(" M");
			else 
				System.out.print(" -");
		}
		
		System.out.println("");
	}
	
} 