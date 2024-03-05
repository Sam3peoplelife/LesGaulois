package personnages;
import villagegaulois.*;

public class Gaulois {
    private String nom;
    private int effetPotion = 1;
    private int force;
    private int nbTrophees;
    private Equipement[] trophees = new Equipement[100];

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
    	return "Le gaulois " + nom + " : ";
    }
    

    public void frapper(Romain romain) {
    	System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
    	Equipement[] trophees = romain.recevoirCoup((force / 3) * effetPotion);
    	for (int i = 0; trophees != null && i < trophees.length; i++,nbTrophees++) {
    		this.trophees[nbTrophees] = trophees[i];
    	}
    	return;
    }

    @Override
    public String toString() {
        return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
    }

    public void boirePotion(int forcePotion) {
        effetPotion = forcePotion;
        parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée.");
    }

    public void faireUneDonnation(Musee musee) {
        if (nbTrophees == 0) {
            parler("Je n'ai aucun trophée à donner au musée.");
            return;
        }

        StringBuilder annonce = new StringBuilder();
        annonce.append("Je donne au musée tous mes trophées :\n");
        for (int i = 0; i < nbTrophees; i++) {
            annonce.append("- ").append(trophees[i].toString()).append("\n");
        }
        parler(annonce.toString());

        for (int i = 0; i < nbTrophees; i++) {
            musee.donnerTrophee(this, trophees[i]);
            trophees[i] = null; // Supprimer la référence au trophée donné
        }
        nbTrophees = 0; // Réinitialiser le nombre de trophées à zéro
    }
}

