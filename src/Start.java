//////////
// Librairies
//////////
import GestionVol.*;
import Reservation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

//////////
// Class Start
//////////
public class Start {

    //////////
    // Méthode Main
    //////////
    public static void main( String args[] ) {
		
		Compagnie ARF = new Compagnie("Air France");
        String numeroVol = "ARF001";

       	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		String volD = "21/10/2020 10:00";	
		String volA = "21/10/2020 21:30";

        String escalA = "21/10/2020 13:30";
        String escalD = "21/10/2020 14:30";

		Date dd, da, ed, ea;

		try {
			dd = format.parse( volD );
			da = format.parse( volA );
            ed = format.parse( escalD );
            ea = format.parse( escalA );
		} catch ( Exception e) {
			throw new IllegalArgumentException("");
		}

        Ville paris = new Ville("Paris");
        Ville doubai = new Ville("Doubai");
        Ville narita = new Ville("Narita");

		Aeroport NRT = new Aeroport("Narita International Airport");
		Aeroport DXB = new Aeroport("Dubai International Airport");
        Aeroport ADP = new Aeroport("Aéroport de Paris");

        ADP.addVille(paris);
        NRT.addVille(narita);
        DXB.addVille(doubai);       
    
		Vol vol1 = new Vol( numeroVol, dd, da, ADP, NRT );
  
		Escale escale = new Escale(DXB, ed, ea);

        vol1.addEscale( escale );

        ARF.addVol( vol1 );
        
		

        Client client1 = new Client("Camille");
        Client client2 = new Client("Nathanael");
        

        Passager passager1 = new Passager("Camille");
        Passager passager2 = new Passager("Nathanael");
        Passager passager3 = new Passager("Antoine");
        
        Reservation r1 = new Reservation( vol1, dd, client1, passager1);
        Reservation r2 = new Reservation( vol1, dd, client2, passager2);
        Reservation r3 = new Reservation( vol1, dd, client2, passager3);

        r1.annuler();
        r2.confirmer();
        r3.confirmer();

        System.out.println(ARF.toString());    
        //System.out.println( r2.toString());
        //System.out.println( vol1.getReservation() );
        //vol1.removeReservation( r3 );
        //System.out.println( vol1.getReservation() );
    }

}
