//////////
// Package
//////////
package GestionVol;

//////////
// Librairies
//////////
import Reservation.*;
import java.util.ArrayList;

//////////
// Classe Aeroport
//////////
public class Aeroport {

    //////////
    // Attributs
    //////////
    private String nom;

    public ArrayList<Ville> villes = new ArrayList();

    //////////
    // Constructeur
    //////////
    public Aeroport( String str ) {      
        this.nom = str;
    }

    //////////
    // Setteurs
    //////////
    public void setNom( String nom ){
        this.nom = nom;
    }

     /*Elle nous permet de pouvoir gérer la double navigabilité entre une ville et un aeroport, 
    afin de pouvoir attribuer à un aeroport donné, la ville dans laquelle elle se trouve*/
    public void setVilles( ArrayList<Ville> villes ) {
        for (Ville v : this.villes ){
            v.setAeroportWithoutBidirectional(null);
        } this.villes = villes ;
        if ( this.villes != null ){
            for ( Ville v : this.villes ){
                v.setAeroportWithoutBidirectional(this);
            }
        }
    }

    protected void setVilleWithoutBidirectional( ArrayList<Ville> villes ) {
        this.villes = villes ;
    }

    //////////
    // Getteurs
    //////////
    public String getNom() {
      return this.nom;
    }

    public ArrayList<Ville> getVilles(){
        return this.villes;
    }

    //////////
    // Ajout et suppression de ville
    //////////

    /*Cette methode permet de pouvoir ajouter une ville à notre liste de ville.*/
    public void addVille( Ville ville ) {
        ville.setAeroportWithoutBidirectional( this );
        this.villes.add( ville );
	}

    //Cette methode sert à supprimer une ville de notre liste de ville.
    public void removeVille( Ville ville ) {
        ville.setAeroportWithoutBidirectional( null ); //permet de supprimer un aeroport lorsqu'on supprime une ville
        this.villes.remove( ville );
    }

    /*Les methodes en dessous, permettent de faire la mis à jour de notre liste 
    de ville en sachant si on a ajouté ou supprimé une ville de la liste initiale*/

    protected void addVilleWithoutBidirectional( Ville ville ) {
        this.villes.add( ville );
	}

    protected void removeVilleWithoutBidirectional( Ville ville ) {
        this.villes.remove( ville );
    }
	
    //////////
    // toString()
    //////////
	@Override
    public String toString(){
        String aeroport = "";
        aeroport += this.nom + "\n\n";
        aeroport += " Villes : " + this.villes.toString();
		return aeroport;
	}
}
