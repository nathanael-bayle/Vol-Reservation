//////////
// Package
//////////
package GestionVol;

//////////
// Librairies
//////////
import Reservation.*;
import java.util.ArrayList;
import java.util.Date;

//////////
// Classe Compagnie
//////////
public class Compagnie {

    //////////
    // Attributs
    //////////
    private String nom;
	private ArrayList<Vol> vols = new ArrayList<Vol>(); 

    //////////
    // Constructeur
    //////////
    public Compagnie( String str ) {
        this.nom = str;
    }

    //////////
    // Getteurs
    //////////
    public String getName() {
        return this.nom;
    }

    public ArrayList<Vol> getVol(){
		return this.vols;
	}

    //////////
    // Setteurs
    //////////
    public void setName( String name ) {
        this.nom = name;
    }
    
    protected void setVolWithoutBidirectional( ArrayList<Vol> vols ) {
        this.vols = vols ;
    }

    public void setVol( ArrayList<Vol> vols ) {
        for (Vol v : this.vols ){
            v.setCompagnieWithoutBidirectional(null);
        } this.vols = vols ;
        if ( this.vols != null ){
            for ( Vol v : this.vols ){
                v.setCompagnieWithoutBidirectional(this);
            }
        }
    }

    //////////
    // Ajout et suppression de vol
    //////////
	public void addVol( Vol vol ) {
        vol.setCompagnieWithoutBidirectional( this );
        this.vols.add( vol );
	}

    public void removeVol( Vol vol ) {
        vol.setCompagnieWithoutBidirectional( null );
        this.vols.remove( vol );
    }

    //////////
    // Ajout et suppression de vol protected pour la double navigailibté
    //////////
    protected void addVolWithoutBidirectional( Vol vol ) {
        this.vols.add( vol );
	}

    protected void removeVolWithoutBidirectional( Vol vol ) {
        this.vols.remove( vol );
    }


    //////////
    // toString()
    //////////
	@Override
	public String toString(){
        String compagnie = "";
        compagnie += "\n\tCompagnie\n";
        compagnie += "\n Nom : " + this.nom + "\n\n";
        compagnie += this.vols.toString();
		return compagnie;
	}
}
