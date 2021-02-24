//////////
// Package
//////////
package GestionVol;

//////////
// Librairies
//////////
import Reservation.*;

//////////
// Classe Ville
//////////
public class Ville {

    //////////
    // Attributs
    //////////
    private String nom;
    private Aeroport aeroport;

    //////////
    // Constructeur
    //////////
    public Ville (String str ){
        this.nom = str;
    }

    //////////
    // Getteurs
    //////////
    public String getVille(){
        return this.nom;
    }

    public Aeroport getAeroport(){
        return this.aeroport;
    }

    protected Aeroport getAeroportWithoutBidirectional(){
        return this.aeroport;
    }

  

    //////////
    // Setteurs
    //////////
    public void setAeroport( Aeroport aeroport ) {
        if ( aeroport != null ){                    
            this.aeroport.addVilleWithoutBidirectional(this);
        }
        if ( this.aeroport != null ) {
           this.aeroport.removeVilleWithoutBidirectional(this);
        }
        this.aeroport = aeroport;
    }

    public void setVille( String nom ){
        this.nom = nom;
    }

    protected void setAeroportWithoutBidirectional( Aeroport aeroport ) {
        this.aeroport = aeroport;
    }

    
    //////////
    // toString()
    //////////
	@Override
	public String toString(){
        String ville = "";
        ville += this.nom;
		return ville;
	}
}
