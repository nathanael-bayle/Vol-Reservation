//////////
// Package
//////////
package GestionVol;

//////////
// Librairies
//////////
import Reservation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

//////////
// Classe Vol
//////////
public class Vol {

    //////////
    // Attributs
    //////////
	private String numero;

	private Date dateDepart;
	private Date dateArrivee;

	private Aeroport aeroportDepart;
	private Aeroport aeroportArrivee;

    private ArrayList<Escale> escales = new ArrayList<Escale>();

    private ArrayList<Reservation> reservation = new ArrayList<Reservation>();

	private boolean isOpen = true;

    private Compagnie compagnie;
	    

    //////////
    // Constructeurs
    //////////
	public Vol(){
	}

	public Vol( String numero, Date dateDepart, Date dateArrivee, Aeroport aeroportDepart, Aeroport aeroportArrivee ){
        this.numero = numero;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrivee = aeroportArrivee;
	}

    //////////
    // Getteurs
    //////////
    public String getNumero(){
        return this.numero;
    }

	public Date getDateDepart(){
		return this.dateDepart;
	}

	public Date getDateArrivee(){
		return this.dateArrivee;
	}

    public Aeroport getAeroportDepart() {
        return this.aeroportDepart;
    }

    public void setAeroportArrivee( Aeroport aeroportA ) {
        this.aeroportArrivee = aeroportA;
    }

    public Compagnie getCompagnie(){
        return this.compagnie;
    }

    protected Compagnie getCompagnieWithoutBidirectional(){
        return this.compagnie;
    }
    
    public ArrayList<Reservation> getReservation(){
		return this.reservation;
	}

    //////////
    // Setteurs
    //////////
    public void setDateArrivee( Date dateA ){
		this.dateArrivee = dateA;
	}

    public void setNumero( String str ){
        this.numero = str;
    }

	public void setDateDepart( Date dateD ){
		this.dateDepart = dateD;
	}
    public void setAeroportDepart( Aeroport aeroportD ) {
        this.aeroportDepart = aeroportD;
    }

    public Aeroport getAeroportArrivee() {
        return this.aeroportArrivee;
    }

    public void setCompagnie( Compagnie compagnie ) {
        if ( compagnie != null ){
            this.compagnie.addVolWithoutBidirectional(this);
        }
        if ( this.compagnie != null ) {
           this.compagnie.removeVolWithoutBidirectional(this);
        }
        this.compagnie = compagnie;
    }

    protected void setCompagnieWithoutBidirectional( Compagnie compagnie ) {
        this.compagnie = compagnie;
    }

    //////////
    // Méthodes
    //////////

    // Calcule la durée entre deux date
    public Duration getDuree() {
         if ( this.dateDepart != null && this.dateArrivee != null ){
            return Duration.of(dateArrivee.getTime() - dateDepart.getTime(), ChronoUnit.MILLIS);
        }
        return null;
    }
    
    // Renvoie l'état du vol
    public boolean getEtat(){
        return this.isOpen;
    }

    // Change l'état
    public void ouvrir(){
        this.isOpen = true;
    }
    
    // Change l'état
    public void fermer(){
        this.isOpen = false;
    }

    // Ajoute une escale au vol
    public void addEscale( Escale escale ) {
		this.escales.add( escale );
	}
    
    // Ajoute une reservation
	public void addReservation( Reservation reservation ) {
        this.reservation.add( reservation );
	}

    // Supprime une reservation
    public void removeReservation( Reservation reservation ) {
        this.reservation.remove( reservation );
    }

    
    //////////
    // equals()
    //////////
    @Override
    public boolean equals( Object obj ){
        try {
            return ((Vol)obj).getNumero().equals(this.numero);
        } catch (Exception e) {
            return false;
        }
    }

    //////////
    // toString()
    //////////
	@Override
	public String toString(){
        String vol = "";
        vol += "\tVol\n";
        vol += "\n Numero : " + this.numero + "\n";
        vol += "\n Aéroport de Départ : " + this.aeroportDepart.toString();
        vol += "\n\n Date de Départ :" + this.dateDepart.toString() ;
        vol += "\n\n Aéroport d'Arrivée : " + this.aeroportArrivee.toString();
        vol += "\n\n Date de d'arrivée : " + this.dateArrivee.toString() ;
        vol += "\n\n Durée de vol : " + getDuree().toString().substring(2);
        for (Escale e : escales) {
            vol += e.toString();
		}
        vol += this.reservation.toString();
        return vol;
	}
}
