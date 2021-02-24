//////////
// Packages
//////////
package Reservation;

//////////
// Librairies
//////////
import java.util.Date;
import GestionVol.Vol;

//////////
// Classe Réservation
//////////
public class Reservation {
    
    //////////
    // Enumération d'état
    //////////
    private enum Etat {
        EN_ATTENTE, ANNULEE, CONFIRMER
    }

    //////////
    // Attributs
    //////////
    private String numero;
    private Date date;

    private Vol vol;

    private Client client;
    private Passager passager;

    private Etat etat;


    //////////
    // Constructeur
    //////////
    public Reservation( Vol vol, Date date, Client client, Passager passager ){
        this.vol = vol;
        this.date = date;

        this.client = client;
        this.passager = passager;

        etat = Etat.EN_ATTENTE;
    }

    //////////
    // Getteur
    //////////
    public Vol getVol(){
        return this.vol;
    }

    //////////
    // Méthodes de confirmation de réservation
    //////////
    public void confirmer() {
        switch( this.etat ) {
            case ANNULEE:
            default:            
                this.etat = Etat.CONFIRMER;
                vol.addReservation( this );
        }
    }

    public void annuler() {
         switch( this.etat ) {
            case CONFIRMER:
            default:            
                this.etat = Etat.ANNULEE;
                vol.removeReservation( this );
        }
    }


    //////////
    // toString()
    //////////
    @Override
    public String toString() {
        String reservation = "";
        reservation += "\n\n\tReservation\n";
        reservation += "\n\n Date de depart : " + this.date.toString() + '\n';
        reservation += "\n" + this.client + '\n';
        reservation += "\n" + this.passager + '\n';
        reservation += "\n Etat : " + this.etat;
        return reservation; 
    }
}
