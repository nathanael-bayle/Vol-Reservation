//////////
// Package
//////////
package GestionVol;

//////////
// Librairies
//////////
import Reservation.*;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;

//////////
// Classe Escale
//////////
public class Escale {

    //////////
    // Attributs
    //////////
    private Aeroport aeroport;
    private Date depart;
    private Date arrivee;
    private Duration duree;

    //////////
    // Constructeur
    //////////
    public Escale (Aeroport aeroport, Date depart, Date arrivee) {
        this.aeroport = aeroport;
        this.arrivee = arrivee;
        this.depart = depart;
        this.duree = Duration.of(depart.getTime() - arrivee.getTime(), ChronoUnit.MILLIS); //donne la durée entre deux dates
    }

    //////////
    // toString()
    //////////
    @Override
    public String toString() {
        String escale = "";
        escale += "\n\n\tESCALE\n";
        escale += "\n Aeroport : " + this.aeroport + "\n";
        escale += "\n Date d'arrivee : " + this.arrivee.toString() + "\n";
        escale += "\n Date de depart : " + this.depart.toString() + "\n";
        escale += "\n Duree : " + this.duree.toString().substring(2) + "\n";
        return escale;
    }
}
