import java.text.DecimalFormat;
import java.util.Scanner;

public class fahrkartenautomat {
	
	
	
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner tastatur = new Scanner(System.in);
		double zuZahlenderBetrag;
		double eingezahlterGesamtbetrag;
		boolean something = true;
		//hghghg
//		

		begreussung();
		zuZahlenderBetrag= fahrkartenbestellungErfassen( tastatur);
		// 1 Geldbetrag eingeben
		
		
		// 2 Geldeinwurf
		eingezahlterGesamtbetrag = fahrkartenBezahlen(tastatur,zuZahlenderBetrag);
		
		
		// 3  Fahrscheinausgabe
		fahrkartenAusgeben();
		
		// 4  Rückgeldberechnung und -ausgabe
		rueckgeldAusgeben(zuZahlenderBetrag,eingezahlterGesamtbetrag);


		tastatur.close();
	}
	
	public static void  begreussung() {
		System.out.println("Herzlich Willkommen");
		System.out.println("Fahrkartenbestellvorgang:\n"+"=========================");
		System.out.println("Wählen Sie ihre Wunschfahrkarte für Berlin AB aus:");
		System.out.println("Einzelfahrschein AB [3,00 EUR] (1)\r\n" + "Einzelfahrschein BC [3,50 EUR] (2)\r\n"+ 
		"Einzelfahrschein ABC [3,80 EUR] (3)\r\n"+ "Kurzstrecke AB [2,00 EUR] (4)\r\n" +
		"Tageskarte AB [8,60 EUR](5)\r\n" + "Tageskarte BC [9,20] (6)\r\n" + "Tageskarte ABC [10,00] (7)\r\n"+
		"4-Fahrten-Karte AB [9,40] (8)\r\n" + "4-Fahrten-Karte BC [12,60] (9)\r\n" + "4-Fahrten-Karte ABC [13,80] (10)\r\n"+
		"Kleingruppen-Tageskarte AB [25,50] (11)\r\n" + "Kleingruppen-Tageskarte BC [26,00] (12)\r\n" +
		"Kleingruppen-Tageskarte ABC [26,50] (13)\r\n" + "Bezahlen (14)\r\n");
	}
	

	//Kartenauswahl un Ticketanzahl
	public static double fahrkartenbestellungErfassen(Scanner tastatur) {
		
		int anzahldertickets;
		double zuZahlenderBetrag;
		boolean ticketwahl = true;
		boolean korreteticketzahl = true;
		boolean korreteticketwahl = true;
		int ticketart ;
		double ticketpreis = 0;
		double [] fahrkartenPreise = {3.00,3.50,3.80,2.00,8.60,9.20,10.00,9.40,12.60,13.80,25.50,26.00,26.50};
		String[] fahrkartenNamen = {
				
	            "Einzelfahrschein AB",
	            "Einzelfahrschein BC",
	            "Einzelfahrschein ABC",
	            "Kurzstrecke AB",
	            "Tageskarte AB",
	            "Tageskarte BC",
	            "Tageskarte ABC",
	            "4-Fahrten-Karte AB",
	            "4-Fahrten-Karte BC",
	            "4-Fahrten-Karte ABC",
	            "Kleingruppen-Tageskarte AB",
	            "Kleingruppen-Tageskarte BC",
	            "Kleingruppen-Tageskarte ABC",
	            
	        };
		while(korreteticketwahl) {
			
			System.out.print("Ihre Wahl: ");
			ticketart = tastatur.nextInt();
			
		if(ticketart > 14 ) {
			
			System.out.println(">>falsche Eingabe<<");
			System.out.print("Ihre Wahl: ");
			ticketart = tastatur.nextInt();
		}
		else if (ticketart == 14) {
			
			break;
		}
		else {
			
			ticketpreis += fahrkartenPreise[ticketart-1];
			System.out.println("Ihre Auswahl: " + fahrkartenNamen[ticketart-1]);
			System.out.println("Zwischensumme:" + df.format(ticketpreis) +"€");
			System.out.println("Geben sie '14' ein um zu bezahlen.");
			System.out.println(" ");
			continue;
		}
				

		}//End of while loop
		
		
		System.out.print("Wie viele Tickets würden sie gerne kaufen ?");
		anzahldertickets = tastatur.nextInt();
		
		while(korreteticketzahl) {
			
		if (anzahldertickets < 1 || anzahldertickets > 10) {
			System.out.print("Wie viele Tickets würden sie gerne kaufen ?");
			anzahldertickets = tastatur.nextInt();
			
		}
		else {
			
			korreteticketzahl = false;
		}
			
		}// End of while loop
		
		System.out.println("Anzahl der Tickets: " + anzahldertickets);
		
		zuZahlenderBetrag = anzahldertickets * ticketpreis;
		
		System.out.print("Zu zahlender Betrag (Euro): ");
		
		return zuZahlenderBetrag;
	}//End of Method 
	
	public static double fahrkartenBezahlen(Scanner tastatur,double zuZahlenderBetrag) {
		double eingezahlterGesamtbetrag = 0.0;
		double eingeworfeneMuenze = 0.0;
		double nochZuZahlen = 0.0;
		
		
		while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
			nochZuZahlen = Math.round((zuZahlenderBetrag - eingezahlterGesamtbetrag)*100.0)/100.0;
			
			System.out.println("Noch zu zahlen: " + df.format(nochZuZahlen)+"€");
			System.out.print("Eingabe (mind. 5 Cent, höchstens 20 Euro): ");
			eingeworfeneMuenze = tastatur.nextDouble();
			if (!(eingeworfeneMuenze == 0.05 || eingeworfeneMuenze == 0.1 || eingeworfeneMuenze == 0.2 || 
				eingeworfeneMuenze ==0.5 || eingeworfeneMuenze == 1.0 || eingeworfeneMuenze == 2.0 || 
				eingeworfeneMuenze ==5.0 || eingeworfeneMuenze ==10.0 || eingeworfeneMuenze == 20.0 ))
			{
				System.out.print("Nö");
				System.exit(0); 
				
			}//End of if 
			eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
		}//End of while loop
		return eingezahlterGesamtbetrag;
	}//End of Method
	public static void fahrkartenAusgeben() {
		System.out.println("\nFahrschein wird ausgegeben");
		for (int i = 0; i < 8; i++) {
			System.out.print("=");
			try {
				Thread.sleep(200);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("\n\n");
	}
	public static void rueckgeldAusgeben(double zuZahlenderBetrag,double eingezahlterGesamtbetrag) {
		double rueckgabebetrag;
		rueckgabebetrag = eingezahlterGesamtbetrag - zuZahlenderBetrag;
		if (rueckgabebetrag > 0.0) {
			System.out.println("Der Rückgabebetrag in Höhe von " + rueckgabebetrag + " Euro");
			System.out.println("wird in folgenden Münzen ausgezahlt:");
			muenzRueckgabe(rueckgabebetrag);
		}// End des ifs
		System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
				+ "Wir wünschen Ihnen eine gute Fahrt.");
		
	}
	public static double muenzRueckgabe(double rueckgabebetrag) {
		
		while (rueckgabebetrag >= 20.0) { // 20-Euro-Münzen
			System.out.println("20 Euro");
			rueckgabebetrag = rueckgabebetrag - 20.0;
		}
		while (rueckgabebetrag >= 10.0) { // 2-Euro-Münzen
			System.out.println("10 Euro");
			rueckgabebetrag = rueckgabebetrag - 10.0;
		}
		while (rueckgabebetrag >= 5.0) { // 2-Euro-Münzen
			System.out.println("5 Euro");
			rueckgabebetrag = rueckgabebetrag - 5.0;
		}
		while (rueckgabebetrag >= 2.0) { // 2-Euro-Münzen
			System.out.println("2 Euro");
			rueckgabebetrag = rueckgabebetrag - 2.0;
		}
		while (rueckgabebetrag >= 1.0) { // 1-Euro-Münzen
			System.out.println("1 Euro");
			rueckgabebetrag = Math.round((rueckgabebetrag - 1.0)*100.0)/100.0;
		}
		while (rueckgabebetrag >= 0.5) { // 50-Cent-Münzen
			System.out.println("50 Cent");
			rueckgabebetrag = rueckgabebetrag - 0.5;
		}
		while (rueckgabebetrag >= 0.2) { // 20-Cent-Münzen
			System.out.println("20 Cent");
			rueckgabebetrag = rueckgabebetrag - 0.2;
		}
		while (rueckgabebetrag >= 0.1) { // 10-Cent-Münzen
			System.out.println("10 Cent");
			rueckgabebetrag = rueckgabebetrag - 0.1;
		}
		while (rueckgabebetrag >= 0.049) { // 5-Cent-Münzen
			System.out.println("5 Cent");
			rueckgabebetrag = rueckgabebetrag - 0.05;
		}
		return rueckgabebetrag;
	}
}

