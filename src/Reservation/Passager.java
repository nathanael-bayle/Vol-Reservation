//////////
// Package
//////////
package Reservation;

//////////
// Librairies
//////////
import GestionVol.*;
import java.util.ArrayList;

//////////
// Classe Passager
//////////
public class Passager {
    
    //////////
    // Attributs
    //////////
    private String nom;
    private ArrayList<Reservation> reservations;


    //////////
    // Constructeur
    //////////
    public Passager(String str) {
        this.nom = str;
        this.reservations = new ArrayList<Reservation>();
    }

    
    //////////
    // Setteur
    //////////
    public void setReservation( Reservation res ){
        this.reservations.add(res);
    }


    //////////
    // toString()
    //////////
    @Override 
    public String toString() {
        String passager = "";
        passager += "\n\tPassager\n";
        passager += "\n Nom : " + this.nom + "\n";
        return passager;
    }

    
}
