//////////
// Package
//////////
package Reservation;

//////////
// Librairies
//////////
import GestionVol.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

//////////
// Classe Client
//////////
public class Client {

    //////////
    // Attributs
    //////////
    private String nom;

    private String payment;

    private String contact;    

    private ArrayList<Reservation> reservations = new ArrayList<Reservation>();


    //////////
    // Constructeurs
    //////////
    public Client( String nom ){
        this.nom = nom;
    }
    
    public void setName( String nom ){
        this.nom = nom; 
    }


    //////////
    // Getteurs
    //////////
    public String getName() {
        return this.nom;
    }

    public String getContact(){
        return this.contact;
    }

    public String getPayment(){
        return this.payment;
    }


    //////////
    // Setteurs
    //////////
    public void setPayment( String payment ){
        this.payment = payment;
    }

    public void setContact( String contact ){
        this.contact = contact;
    }
    

    //////////
    // Méthode de réservation de vol
    //////////
    public Reservation reserver( Vol vol, Passager passager ){
        if (vol.getEtat()) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            Date date = new Date(System.currentTimeMillis());                       // On prend la date au moment de la réservation 
            Reservation r = new Reservation(vol, date, this, passager);
            reservations.add(r);
            passager.setReservation(r);
            return r;
        }

        return null;
    }

  
    //////////
    // toString()
    //////////
    @Override
    public String toString(){
        String client = "";
        client += "\n\tClient\n";
        client += "\n Nom : " + this.nom;
        return client;
    }
}
