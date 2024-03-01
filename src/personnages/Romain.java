package personnages;

public class Romain {
	private String nom;
    private int force;
    private Equipement[] equipements;
    private int nbEquipement;
	
    public Romain(String nom, int force) {
        this.nom = nom;
        this.force = force;
        this.equipements = new Equipement[2];
        this.nbEquipement = 0;
    }
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
	
	public void sEquiper(Equipement equipement) {
	    switch (nbEquipement) {
	        case 0:
	            ajouterEquipement(equipement);
	            System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	            break;
	        case 1:
	            if (equipements[0] == equipement) {
	                System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
	            } else {
	                ajouterEquipement(equipement);
	                System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	            }
	            break;
	        default:
	            System.out.println("Le soldat " + nom + " est déjà bien protégé !");
	            break;
	    }
	}

	private void ajouterEquipement(Equipement equipement) {
	    equipements[nbEquipement] = equipement;
	    nbEquipement++;
	}
	
	public static void main(String[] args) {
	    Romain minus = new Romain("Minus", 10);

	    minus.sEquiper(Equipement.CASQUE);
	    minus.sEquiper(Equipement.CASQUE);
	    minus.sEquiper(Equipement.BOUCLIER);
	    minus.sEquiper(Equipement.CASQUE);
	}

}
