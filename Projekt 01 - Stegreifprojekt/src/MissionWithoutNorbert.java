
public class MissionWithoutNorbert {
	public static void main (String[] args) {
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
		
		randomMinionWert = Math.random();
		randomAnfangsWert = Math.random();
		
		randomMinionWert *= 10;
		randomMinionWert++;
		
		minionsRechts = Math.round(randomMinionWert);
		anfangsWert = Math.round(randomAnfangsWert);
		
		minionsLinks -= minionsRechts;
		
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
		
		while (minionsLinks > 0 || minionsRechts > 0) {
			
			if (anfangsWert == 1) {
				double randomCompMinionWert;
				double randomCompSeitenWert;
				
				long compMinionWert;
				long compSeitenWert;
				
				randomCompMinionWert = Math.random();
				randomCompMinionWert *= 3;
				
				randomCompMinionWert++;
				compMinionWert = (int)(randomCompMinionWert);
				
				randomCompSeitenWert = Math.random();
				compSeitenWert = Math.round(randomCompSeitenWert);
				
				System.out.println("");
				switch ((int)compSeitenWert) {
				case 0:
					minionsRechts -= compMinionWert;
					leereMinionsRechts += compMinionWert;
					
					System.out.println("Computer nimmt " + compMinionWert + " von Rechts");
					break;
				case 1:
					minionsLinks -= compMinionWert;
					leereMinionsLinks += compMinionWert;
					
					System.out.println("Computer nimmt " + compMinionWert + " von Links");
					break;
				}
				System.out.println("");
				
				if (minionsRechts == 0 && minionsLinks == 0) {
					spielerNorbert = 1;
				}
				
				if (minionsRechts < 0 || minionsLinks < 0) {
					minionsRechts = 0;
					minionsLinks = 0;
					
					compNorbert = 1;
				}
				
				if (compNorbert == 0) {
					anfangsWert = 0;
				}
				
			}
			
			if (anfangsWert == 0) {
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
			
				System.out.println("Von welcher Seite - l)inks oder r)rechts - willst du wählen?)");
				
				seitenWahl = StaticScanner.nextChar();
				
				System.out.println("Wie viele Minions sollen in dein Team? (1 - 3 Minions auswählen)");
				minionsWahl = StaticScanner.nextInt();
				
				if (minionsWahl > 3 || minionsWahl < 1) {
					System.out.println("Eingabefehler!");
					System.out.println("Wie viele Minions sollen in dein Team? (1 - 3 Minions auswählen)");
					minionsWahl = StaticScanner.nextInt();
				}
				
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
				
				if (minionsRechts == 0 && minionsLinks == 0) {
					compNorbert = 1;
				}
				
				if (minionsRechts < 0 || minionsLinks < 0) {
					minionsRechts = 0;
					minionsLinks = 0;
					
					spielerNorbert = 1;
				}
				
				anfangsWert = 1;
				
				System.out.println("");
				
			}
			
		}
		
		if (spielerNorbert == 1) {
			System.out.println("Spieler hat Norbert und darum verloren");
		} else if (compNorbert == 1) {
			System.out.println("Computer hat Norbert und darum veloren");
		}
		
	}
	
}
