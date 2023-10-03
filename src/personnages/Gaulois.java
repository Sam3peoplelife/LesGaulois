package personnages;

public class Gaulois {
	
	private String nom;
    private int force;
    private int effetPotion;
    private int force, nb_trophees;
    private Equipement trophees[] = new Equipement[100];
    
    public Gaulois(String nom, int force) {
    	this.nom = nom;
    	this.force = force;
    }

    public String getNom() {
    	return nom;
    }
    
    public void parler(String texte) {
    	System.out.println(prendreParole() + "« " + texte + "»");
    }
    
    private String prendreParole() {
    	String texte = "Le gaulois " + nom + " : ";
    	return texte;
    	}
    
    public void frapper(Romain romain) {
    	System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
    	romain.recevoirCoup(force / 3);
    }
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	public static void main(String[] args) {
		//TODO créer un main permettant de tester la classe Gaulois
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
		System.out.println(asterix.prendreParole());
		asterix.parler("GLORY TO UKRAINE");
		Romain rom = new Romain("Roma", 5);
		asterix.frapper(rom);

	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans lamâchoire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) *
		effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++,
		nb_trophees++) {
		this.trophees[nb_trophees] = trophees[i];
		}
		return;
		}
}
