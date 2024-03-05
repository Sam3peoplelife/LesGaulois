package personnages;

public class Romain {
	private String nom;
    private int force;
    private Equipement[] equipements;
    private int nbEquipement;
	public String texte;
	
	
    public Romain(String nom, int force) {
        this.nom = nom;
        this.force = force;
        this.equipements = new Equipement[2];
        this.nbEquipement = 0;
    }
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
	    Equipement[] equipementEjecte = null;
	    // Precondition
	    assert force > 0;
	    int oldForce = force;
	    forceCoup = CalculResistanceEquipement(forceCoup);
	    force -= forceCoup;

	    switch (force) {
	        case 0:
	            parler("Aïe");
	            break;
	        default:    
	            equipementEjecte = ejecterEquipement();
	            parler("J'abandonne...");
	            break;
	    }
	    // post condition la force a diminuée
	    assert force < oldForce;
	    return equipementEjecte;
	}
	
	private int CalculResistanceEquipement(int forceCoup) {
			texte = "Ma force est de " + this.force + ", et la force ducoup est de " + forceCoup;
			int resistanceEquipement = 0;
			
			if (nbEquipement != 0) {
				
				texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
				
				for (int i = 0; i < nbEquipement;i++) {
					if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
								resistanceEquipement += 8;
					} else {
						System.out.println("Equipement casque");
						resistanceEquipement += 5;
					}
				}
				
				texte += resistanceEquipement + "!";
			}
			parler(texte);
			forceCoup -= resistanceEquipement;
			return forceCoup;
		}
	
	
		private Equipement[] ejecterEquipement() {
			Equipement[] equipementEjecte = new Equipement[nbEquipement];
			System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
				// TODO
			int nbEquipementEjecte = 0;
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] == null) {
					continue;
				} else {
					equipementEjecte[nbEquipementEjecte] =
					equipements[i];
					nbEquipementEjecte++;
					equipements[i] = null;
				}
			}
			return equipementEjecte;
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

}
